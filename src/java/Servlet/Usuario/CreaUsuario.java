/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Usuario;

import Controlador.Query;
import Helper.Validacion;
import Modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class CreaUsuario extends HttpServlet {
    private static final String URL_VISTA = "/WEB-INF/Public/creaUsuario.jsp";
    private static final String URL_EXITO = "/WEB-INF/Mensaje/exito.jsp";
    public static final String ATRIBUTO_USUARIO = "usuario";
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
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        String confirmaPassword = request.getParameter("confirmaPassword");
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String email = request.getParameter("email");
        Integer tipo = 1;
        
        
        Usuario u = new Usuario(nombreUsuario, password, confirmaPassword, nombre, apellidoP, apellidoM, email, tipo);
        ArrayList<String> errores = Validacion.valida(u);
        if(errores.size()>0){
            request.setAttribute("errores", errores);
            request.setAttribute(Usuario.NOMBRE_TABLA, u);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        Query cq = new Query();
        if(cq.existeUsuarioConEmail(email)!=null){
            request.setAttribute(Usuario.NOMBRE_TABLA, u);
            request.setAttribute("errores", Validacion.creaError("Ya existe un usuario con ese email"));
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
        }
          
        
        if(cq.insertaUsuarioBD(u)){
            request.setAttribute("mensaje", "Tu usuario ha sido creado exitosamente");
            request.getRequestDispatcher(URL_EXITO).forward(request, response);
        }else{
            request.setAttribute("usuario", u);
            ArrayList<String> errores2 = new ArrayList<String>();
            errores.add("Lo sentimos, tu usuario no puede ser creado en este momento.");
            request.setAttribute("errores", errores);
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
