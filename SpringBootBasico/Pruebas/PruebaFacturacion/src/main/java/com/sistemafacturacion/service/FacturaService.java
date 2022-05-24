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
public class FacturaService {
    
    @Autowired
    private FacturaRepository facturaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private DetalleFacturaRepository detFacturaRepo;


    public Factura crearFactura(Factura factura, Long id_cliente, List<DetalleFactura> detalles){
        Cliente cliente = clienteRepo.findById(id_cliente).get();
        if(cliente != null){
            factura.setCliente(cliente);
            factura = facturaRepo.save(factura);
            for(DetalleFactura detalle : detalles){
                detalle.setFactura(factura);
                detFacturaRepo.save(detalle);
            }
            return factura;
        }
        return null;
    }
}
