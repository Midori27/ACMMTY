/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.Usuario;

import Controlador.ControladorQuery;
import Modelo.Usuario;
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
public class ActualizaUsuario extends HttpServlet {

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
        Integer id = Integer.parseInt((String)request.getSession().getAttribute("id"));
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String telefono = request.getParameter("telefono");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String carrera = request.getParameter("carrera");
        String matricula = request.getParameter("matricula");
        String campus = request.getParameter("campus");
        String universidad = request.getParameter("universidad");
        Integer tipo = (universidad.equals("ITESM")) ? 1 : 2;
        ControladorQuery cq = new ControladorQuery();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/actualizaNoticia");
        Usuario u = new Usuario(id, password, nombre, apellidoP, apellidoM, email, new Date(), telefono, ciudad, estado, tipo, carrera, matricula, campus, universidad);
        
        if(cq.actualizaUsuarioBD(u)){
            request.setAttribute("mensaje", "Tu cuenta ha sido actualizada exitosamente.");
            rd.forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos, tu cuenta no puede ser actualizada en este momento.");
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
