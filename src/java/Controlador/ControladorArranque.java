/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Esta clase se encarga de implementar la interface ServlertContextListener
 * para estar a la escucha de la creación del servlet y llevar a cabo las 
 * tareas de inicialización.
 * 
 * @author juanjo
 */
public class ControladorArranque implements ServletContextListener {

   ServletContext context;
   
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.setAttribute("query", new ControladorQuery());
        
    }

    
    public void contextDestroyed(ServletContextEvent sce) {
      
    }
    
}
