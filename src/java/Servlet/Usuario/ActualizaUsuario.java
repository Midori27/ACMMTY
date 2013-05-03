/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.Usuario;

import Controlador.Query;
import Helper.Fecha;
import Modelo.Usuario;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author juanjo
 */
public class ActualizaUsuario extends HttpServlet {
    public static final String URL_VISTA="/WEB-INF/Usuario/actualizaUsuario.jsp";
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
        Usuario usuario = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        Integer id = usuario.getId();
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String email = request.getParameter("email");
        Integer tipo = 1;
        Query q = new Query();
        
        Usuario u = new Usuario(id, password, nombre, apellidoP, apellidoM, email, tipo);
        
        Validator validator = new Validator();
        List<ConstraintViolation> violation = validator.validate(u);
        if(violation.size()>0){
            request.setAttribute("mensaje", "Porfavor corrija los errores.");
            request.setAttribute("errores", violation);
            request.setAttribute("usuario", u);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        if(q.actualizaUsuarioBD(u)){
            Usuario usuarioActualizado = q.getUsuarioBD(u.getId());
            request.getSession().setAttribute(Usuario.NOMBRE_TABLA, usuarioActualizado);
            request.setAttribute("usuario", usuarioActualizado);
            request.setAttribute("mensaje", "Tu cuenta ha sido actualizada exitosamente.");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos, tu cuenta no puede ser actualizada en este momento.");
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
        Usuario u = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        request.setAttribute("usuario", u);
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
