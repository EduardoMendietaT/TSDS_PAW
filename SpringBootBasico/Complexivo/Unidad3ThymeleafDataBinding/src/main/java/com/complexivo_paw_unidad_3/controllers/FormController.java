package com.complexivo_paw_unidad_3.controllers;

import java.util.HashMap;
import java.util.Map;

import com.complexivo_paw_unidad_3.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "Registrar Usuario");
        return "form";
    }


    @PostMapping("/form")
    public String procesar(@Validated Usuario usuario, BindingResult result, Model model){
        
        model.addAttribute("titulo", "Resultado Form");

        if(result.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(
                err -> {
                    errores.put(
                        err.getField(),
                        "El campo "+err.getField()+" "+err.getDefaultMessage()
                    );
                }
            );
            model.addAttribute("error", errores);
            return "form";
        }
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
