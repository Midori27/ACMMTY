/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Filtro;

import Servlet.Login;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
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
public abstract class FiltroAuth implements Filter {
    public static String URL = "localhost:8484";
    protected ServletContext servletContext;
    public void init(FilterConfig filterConfig){
       servletContext =  filterConfig.getServletContext();
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
        
        
        
        if(!isAuth(req)){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        chain.doFilter(request, response);
    }
    
    protected abstract boolean isAuth(HttpServletRequest req);
}
     

