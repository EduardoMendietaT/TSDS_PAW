package com.sistemafacturacion.service;

import com.sistemafacturacion.model.Producto;
import com.sistemafacturacion.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepo;


    public Producto crearProducto(Producto producto){
        return productoRepo.save(producto);
    }
}
