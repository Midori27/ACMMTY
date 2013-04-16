/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Controlador;

import Servlet.Login;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanjo
 */
public class Filtro implements Filter {
    public static String URL = "localhost:8484";

    public void init(FilterConfig filterConfig){
        
    }
    public void destroy(){
        
    }
    
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)throws IOException, ServletException{
        
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        Integer idUsuario = (Integer) session.getAttribute(Login.ATRIBUTO_ID);
        // Permitir acceso al login.
        if (servletPath.equals("/login.jsp"))
        {
           if(idUsuario == null){
            chain.doFilter(req, resp);
            return;
           }else{
               //Ya esta autentificado
               resp.sendRedirect("index.jsp");
           }
        }
        if (servletPath.equals("/registro.jsp")) {
          if(idUsuario == null){
            chain.doFilter(req, resp);
            return;
           }else{
               //Ya esta registrado
               resp.sendRedirect("index.jsp");
           }
        }
        // Permitir acceso a recuperar cuenta
        if (servletPath.equals("/recuperaCuenta.jsp"))
        {
           if(idUsuario == null){
            chain.doFilter(req, resp);
            return;
           }else{
               //Ya esta autentificado
               resp.sendRedirect("index.jsp");
           }
        }
        // Permitir acceso a reestablecer contrasena
        if (servletPath.equals("/reestableceContrasena.jsp"))
        {
           if(idUsuario == null){
            chain.doFilter(req, resp);
            return;
           }else{
               //Ya esta autentificado
               resp.sendRedirect("index.jsp");
           }
        }
        // Permitir accesso a mensaje de exito
        if (servletPath.equals("/exito.jsp"))
        {
           if(idUsuario == null){
            chain.doFilter(req, resp);
            return;
           }else{
               //Ya esta autentificado
               resp.sendRedirect("index.jsp");
           }
        }
         if (servletPath.equals("/eventos.html")) {
          chain.doFilter(req, resp);
          return;
        }
         if (servletPath.equals("/index.jsp")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.equals("/nosotros.html")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.startsWith("/css")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.startsWith("/images")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.startsWith("login")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.startsWith("/js")) {
          chain.doFilter(req, resp);
          return;
        }
        if (servletPath.startsWith("/jsGV")) {
          chain.doFilter(req, resp);
          return;
        }
        // All other functionality requires authentication.
        if (idUsuario != null)
        {
           // User is logged in.
           chain.doFilter(req, resp);
           return;
        }

        // Request is not authorized.
        resp.sendRedirect("login.jsp");
    }
}
