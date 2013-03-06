/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Evento;
import java.io.IOException;
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
public class ServletEvento extends HttpServlet {
    public static final String URL_FORWARD = "/listaEventos.jsp";
    public static final String ATRIBUTO_EVENTOS = "eventos";
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
         //Se obtiene el despachador.
        RequestDispatcher despachador = getServletContext().getRequestDispatcher(URL_FORWARD);
        ControladorQuery cq = (ControladorQuery) getServletContext().getAttribute("query");
        creaEvento(cq, request);
        Evento[] eventos = cq.getEventosBd();
        request.setAttribute(ATRIBUTO_EVENTOS, eventos);
        //Forward de regreso a la lista de eventos.
        despachador.forward(request, response);
        return;        
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

    public void creaEvento(ControladorQuery cq, HttpServletRequest request){
        String nombreE = request.getParameter("nombre");
        String fechaE = request.getParameter("fecha");
        String lugarE = request.getParameter("lugar");
        String descripcionE = request.getParameter("descripcion");
        int maxIntegrantesEquipo = Integer.parseInt(request.getParameter("integrantesPorEquipo"));
        Evento ev = new Evento(nombreE, new Date(), lugarE, descripcionE, maxIntegrantesEquipo);
        cq.insertaEventoBD(ev);
    }
    
    public void getEventos(){
        
    }
}
