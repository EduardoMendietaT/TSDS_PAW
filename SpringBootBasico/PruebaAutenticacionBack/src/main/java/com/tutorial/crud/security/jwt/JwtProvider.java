package com.tutorial.crud.security.jwt;

import java.util.Date;

import com.tutorial.crud.security.entity.UsuarioPrincipal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**Esta clase genera el token, posee un metodo de validación*/
@Component
public class JwtProvider {
    /** Lo utilizaremos unicamente para desarrollo, 2 clases se importan de slf4j */
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final String RUTA_CLASE = "security/jwt/JwtProvider.java.validateToken()";

    /** Tine que ver con el application.properties --> #security */
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()) 
            .setExpiration(new Date(new Date().getTime() + expiration * 1000))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact(); //Token generado.
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("Token mal formado, en: !");
        }catch(UnsupportedJwtException e){
            logger.error("Token no Soportado, en: "+RUTA_CLASE+"!");
        }catch(ExpiredJwtException e){
            logger.error("Token expirado, en: "+RUTA_CLASE+"!");
        }catch(IllegalArgumentException e){
            logger.error("Token vacio, en: "+RUTA_CLASE+"!");
        }catch(SignatureException e){
            logger.error("Fallo en la firma, en: "+RUTA_CLASE+"!");
        }
        return false;
    }
}
