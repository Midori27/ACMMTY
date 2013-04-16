/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.Evento;

import Controlador.Query;
import Modelo.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class ActualizaEvento extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nombre = (String) request.getParameter("nombre");
        String fecha = (String) request.getParameter("fecha");
        String lugar = (String) request.getParameter("lugar");
        String descripcion = (String) request.getParameter("descripcion");
        Integer maxIntegrantesxEquipo = Integer.parseInt("maxIntegrantesxEquipo");
       
        Query cq = new Query();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/actualizaEvento");
        Evento ev = new Evento(id,nombre, Evento.parseFecha(fecha), lugar, descripcion, maxIntegrantesxEquipo);
        
        if(cq.actualizaEventoBD(ev)){
            request.setAttribute("mensaje", "El evento ha sido actualizado exitosamente.");
            rd.forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos, el evento no puede ser actualizado en este momento.");
            rd.forward(request, response);
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
        processRequest(request, response);
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
