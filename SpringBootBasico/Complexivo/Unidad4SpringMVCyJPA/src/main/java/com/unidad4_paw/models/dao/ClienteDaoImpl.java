package com.unidad4_paw.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unidad4_paw.models.entity.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements IClienteDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente){
        if(cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
    }
    
    @Override
    public Cliente findOne(Long id){
        return em.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id){
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }
}
