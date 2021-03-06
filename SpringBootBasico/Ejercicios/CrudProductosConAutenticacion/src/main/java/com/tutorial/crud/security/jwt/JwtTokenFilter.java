package com.tutorial.crud.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutorial.crud.security.service.UserDetailsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**Esta clase se va ha ejecutar por cada peticion, va ha comprovar que el token se valido usando el JwtProvider
 * Si es valido le da acceso al recurso, caso contrario, lanzara la excepción.
*/
public class JwtTokenFilter extends OncePerRequestFilter{

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    /** Lo utilizaremos unicamente para desarrollo, 2 clases se importan de slf4j */
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    /** Va decir si esta autenticado y tambien va ha comprobar si el token es valido o no*/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token != null  && jwtProvider.validateToken(token)){
                /**Autenticacion. */
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
                /**Autorización:Saber quien esta logeado y a recursos puede acceder. */
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch(Exception e){
            logger.error("Error en el método security/jwt/JwtTokenFilter.java.doFilterInternal()!");
        }
        filterChain.doFilter(request, response);
    }

    /**Metodo para extraer el Token*/
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer", "");
        return null;
    }
    
}
