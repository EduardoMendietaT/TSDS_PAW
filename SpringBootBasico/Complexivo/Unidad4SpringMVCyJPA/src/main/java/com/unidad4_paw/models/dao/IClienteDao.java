package com.unidad4_paw.models.dao;

import java.util.List;

import com.unidad4_paw.models.entity.Cliente;

public interface IClienteDao {
    public List<Cliente> findAll();
}
