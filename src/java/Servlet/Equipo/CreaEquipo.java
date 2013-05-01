/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.Equipo;

import Controlador.ParseaParametros;
import Controlador.Query;
import Modelo.Equipo;
import Modelo.Evento;
import Modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class CreaEquipo extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/creaEquipo.jsp";

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
        Usuario u = (Usuario)request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        ArrayList<Integer> idUsuarios = new ArrayList<Integer>();
        idUsuarios.add(u.getId());
        HashMap<String,String> parametros = ParseaParametros.parsea(request, this.getServletConfig().getServletContext());
        Integer idEvento = Integer.parseInt(parametros.get(Equipo.COL_ID_EVENTO));
        String nombre = parametros.get(Equipo.COL_NOMBRE);
        String estado = "";
        int puntaje = 0;
        String clave = parametros.get(Equipo.COL_CLAVE);
        Query q = new Query();
        Evento evento = q.getEventoBD(idEvento);
        Integer maxIntegrantes = evento.getMaxIntegrantesEquipo();
        
        Equipo equipo = new Equipo(idEvento, idUsuarios, nombre, estado, puntaje, clave, maxIntegrantes);
        
        if(q.insertaEquipoBD(equipo)){
            request.setAttribute("mensaje", "Equipo creado exitosamente.");
        }else{
            request.setAttribute("mensaje", "Lo sentimos, el equipo no puede ser creado en este momento.");
            request.getRequestDispatcher(URL_VISTA).forward(request,response);
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
