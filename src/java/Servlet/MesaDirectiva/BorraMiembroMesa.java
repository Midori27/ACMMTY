/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.MesaDirectiva;

import Controlador.ControladorQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class BorraMiembroMesa extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/MesaDirectiva/adminMesaDirectiva.jsp";
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        ControladorQuery cq = new ControladorQuery();
        RequestDispatcher rd = getServletContext().getRequestDispatcher(URL_VISTA);
        if(cq.borraMiembroMesaBD(id)){
            request.setAttribute("mensaje", "El miembro de la mesa ha sido borrado exitosamente.");
            rd.forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos el miembro de la mesa no puede ser eliminado en este momento. Es probable que el miembro no existiera antes de intentar borrarlo o que haya problemas con la base de datos.");
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
