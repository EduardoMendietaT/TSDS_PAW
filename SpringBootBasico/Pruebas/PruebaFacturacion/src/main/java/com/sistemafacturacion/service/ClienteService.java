package com.sistemafacturacion.service;

import java.util.List;

import com.sistemafacturacion.model.Cliente;
import com.sistemafacturacion.model.DetalleFactura;
import com.sistemafacturacion.model.Factura;
import com.sistemafacturacion.repository.ClienteRepository;
import com.sistemafacturacion.repository.DetalleFacturaRepository;
import com.sistemafacturacion.repository.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private FacturaRepository facturaRepo;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepo;


    public List<Cliente> getAllClientes(){
        return clienteRepo.findAll();
    }

    public Cliente agregarCliente(Cliente cliente){
        return clienteRepo.save(cliente);
    }



    public boolean eliminarCliente(Long id_cliente){
        if(clienteRepo.existsById(id_cliente)){
            Cliente cliente = clienteRepo.findById(id_cliente).get();
            List<Factura> facturas = cliente.getFacturas();
            for(Factura factura: facturas){
                for(DetalleFactura detalle: factura.getDetalles()){
                    detalleFacturaRepo.delete(detalle);
                }
                facturaRepo.delete(factura);
            }
            clienteRepo.delete(cliente);
            return true;
        }
        return false;
    }
}
