package com.complexivo_paw_unidad_3.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequeridoValidator implements ConstraintValidator<Requerido, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || !StringUtils.hasText(value)){
            return false;
        }
        return true;
    }
    
}
