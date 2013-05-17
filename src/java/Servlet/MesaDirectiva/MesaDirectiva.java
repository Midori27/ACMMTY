/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.MesaDirectiva;

import Controlador.Query;
import Helper.ParPeriodoMiembros;
import Modelo.MiembroMesa;
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
public class MesaDirectiva extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/MesaDirectiva/mesaDirectiva.jsp";

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
        Query q = new Query();
        ParPeriodoMiembros[] pm;
        Periodo[] periodos;
        MiembroMesa[] miembrosMesa;
        
        periodos = q.getPeriodosBD();
        
        if(periodos != null){
            pm = new ParPeriodoMiembros[periodos.length];
            for(int i=0; i<periodos.length;i++){
                miembrosMesa = q.getMiembrosPeriodoBD(periodos[i].getId());
                if(miembrosMesa == null) miembrosMesa = new MiembroMesa[0];
                pm[i] = new ParPeriodoMiembros(periodos[i], miembrosMesa);
            }
            request.setAttribute("paresPeriodoMiembros", pm);
        }
        request.getRequestDispatcher(URL_VISTA).forward(request, response);
        
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
