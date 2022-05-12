package com.complexivo_paw_unidad_3.controllers;

import com.complexivo_paw_unidad_3.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;;

@Controller
@SessionAttributes("usuario")
public class FormController {
    
    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Eduardo");
        usuario.setApellido("Mendieta");
        usuario.setIdentificador("112.356.242-J");

        model.addAttribute("titulo", "Registrar Usuario");
        model.addAttribute("usuario", usuario);
        return "form";
    }


    @PostMapping("/form")
    public String procesar(@Validated Usuario usuario, BindingResult result, Model model, SessionStatus status){
        
        model.addAttribute("titulo", "Resultado Form");

        if(result.hasErrors()){            
            return "form";
        }
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
