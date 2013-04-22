/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Evento;

import Controlador.ParseaParametros;
import Controlador.Query;
import Modelo.Evento;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class CreaEvento extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/Evento/creaEvento.jsp";
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap<String,String> parametros = ParseaParametros.parsea(request,this.getServletConfig().getServletContext());
        String imagen = parametros.get(Evento.COL_IMAGEN);
        String nombre = parametros.get(Evento.COL_NOMBRE);
        String fecha = parametros.get(Evento.COL_FECHA);
        String lugar = parametros.get(Evento.COL_LUGAR);
        String descripcion = parametros.get(Evento.COL_DESCRIPCION);
        int maxIntegrantesEquipo = Integer.parseInt(parametros.get(Evento.COL_MAX_INTEGRANTES_POR_EQUIPO));
        
        Evento ev = new Evento(imagen,nombre, new Date(), lugar, descripcion, maxIntegrantesEquipo);
        Query q = new Query();
        String mensaje="";
        
        if(q.insertaEventoBD(ev)){    
            mensaje="Evento creado exitosamente";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
        }else{
            mensaje="El evento no pudo ser creado.";
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("evento", ev);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
        }
        
        
        
                
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher(URL_VISTA).forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
