package com.tutorial.crud.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/** La utilizaremos en caso de que nos de un error en la aplicación */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{

    /** Lo utilizaremos unicamente para desarrollo, 2 clases se importan de slf4j */
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        
        logger.error("Error en el método commence de security/jwt/JwtEntryPoint.java");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado!");
    }
    
}
