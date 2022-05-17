package com.unidad4_paw.controllers;

import java.util.Map;

import com.unidad4_paw.models.entity.Cliente;
import com.unidad4_paw.models.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado Clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }


    @RequestMapping(value = "/form")
    public String mostrar(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario del Cliente");
        return "form";
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:listar";
    }


    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Cliente cliente = null;
        if(id > 0){
            clienteService.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar del Cliente");
        return "form";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value =  "id") Long id){
        if(id > 0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }
}
