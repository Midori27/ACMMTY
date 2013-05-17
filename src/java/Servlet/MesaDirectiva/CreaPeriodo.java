/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.MesaDirectiva;

import Controlador.Query;
import Modelo.Periodo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class CreaPeriodo extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/MesaDirectiva/creaPeriodo.jsp";
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
        String mInicio = request.getParameter(Periodo.COL_M_INICIO);
        String mFin = request.getParameter(Periodo.COL_M_FIN);
        String aInicioS = request.getParameter(Periodo.COL_A_INICIO);
        String aFinS = request.getParameter(Periodo.COL_A_FIN);
        if(aInicioS == null || aFinS == null || aInicioS.isEmpty() || aFinS.isEmpty()){
            request.setAttribute("mensaje", "Debe de introducir un año inicial y final");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        Integer aInicio = Integer.parseInt(request.getParameter(Periodo.COL_A_INICIO));
        Integer aFin = Integer.parseInt(request.getParameter(Periodo.COL_A_FIN));
        
        Query q = new Query();
        Periodo periodo;
        
        if(aFin < aInicio){
            request.setAttribute("mensaje", "El año inicial debe de ser menor al final");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        periodo = new Periodo(aInicio, aFin, mInicio, mFin);
        
        if(q.insertaPeriodoBD(periodo)){
            response.sendRedirect("AdminMesaDirectiva");
            return;
        } else{
            request.setAttribute("mensaje", "Hubo un problema insertando el periodo a la base de datos, intente mas tarde.");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
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
