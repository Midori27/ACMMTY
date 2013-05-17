/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet;

import Controlador.Email;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class Contacto extends HttpServlet {
    public static String URL_VISTA="/WEB-INF/Contacto/contacto.jsp";
    public static String URL_EXITO="/WEB-INF/Mensaje/exito.jsp";

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
        String nombre = request.getParameter("name");
        String mail = request.getParameter("email");
        String asunto = request.getParameter("subject");
        String mensaje = request.getParameter("message");
        if(nombre == null || mail == null || asunto == null || mensaje == null || nombre.isEmpty() || mail.isEmpty() || asunto.isEmpty() || mensaje.isEmpty()){
            request.setAttribute("mensaje", "Asegurate de llenar todos los campos.");
            Usuario u = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
            if(u != null){
                request.setAttribute("nombre", u.getNombreUsuario());
                request.setAttribute("email", u.getEmail());
            }
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        Email ce = new Email();
        ce.enviaMail(mail, "acm.monterrey+contacto@gmail.com", asunto, mail+" >> "+nombre + "\n" + mensaje);
        request.setAttribute("mensaje", "Gracias por comunicarte con nosotros, te atenderemos en la brevedad posible.");
        request.getRequestDispatcher(URL_EXITO).forward(request, response);
        
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
        Usuario u = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        if(u != null){
            request.setAttribute("nombre", u.getNombreUsuario());
            request.setAttribute("email", u.getEmail());
        }
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
