/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.MesaDirectiva;

import Controlador.ParseaParametros;
import Controlador.Query;
import Modelo.MiembroMesa;
import java.io.IOException;
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
public class ActualizaMiembroMesa extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/MesaDirectiva/actualizaMiembroMesa.jsp";
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
        HashMap<String,String> parametros = ParseaParametros.parsea(request, this.getServletConfig().getServletContext());
        Integer id = Integer.parseInt(parametros.get(MiembroMesa.COL_ID));
        String periodo = parametros.get(MiembroMesa.COL_PERIODO);
        String foto = parametros.get(MiembroMesa.COL_FOTO);
        if(foto.isEmpty()){
            foto = parametros.get("fotoSubida");
        }
        String nombre = parametros.get(MiembroMesa.COL_NOMBRE);
        String posicion = parametros.get(MiembroMesa.COL_POSICION);
        Query cq = new Query();
        RequestDispatcher rd = getServletContext().getRequestDispatcher(URL_VISTA);
        MiembroMesa m = new MiembroMesa(id, periodo, foto, nombre, posicion);
        request.setAttribute("miembro", m);
        if(cq.actualizaMiembroMesaBD(m)){
            request.setAttribute("mensaje", "El miembro de la mesa ha sido actualisado exitosamente.");
            rd.forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos, el miembro de la mesa no puede ser actualisado en este momento.");
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        Query cq = new Query();
        MiembroMesa m = cq.getMiembroMesaBD(id);
        request.setAttribute("miembro", m);
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
