/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanjo
 */
public class ServletUsuario extends HttpServlet {
    private static final String URL_REDIRECCION_USUARIO_CREADO = "index.jsp";
    private static final String URL_REDIRECCION_MODIFICAR_USUARIO = "";
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
        HttpSession s = request.getSession();
        if(s==null || s.getAttribute(ServletLogin.ATRIBUTO_ID) == null){
            creaUsuario(request);
            response.sendRedirect(URL_REDIRECCION_USUARIO_CREADO);
            
        }else{
            String modifica = request.getParameter("nombreUsuario");
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

    public void creaUsuario(HttpServletRequest request){
        ControladorQuery cq = new ControladorQuery();
        Usuario u = null;
        String nombreUsuario = request.getParameter("nombreUsuario");
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
        Integer tipo = null;
        
        if(universidad.equals("ITESM")){
            tipo = 1;
        } else{
            tipo = 2;
        }
        
        u = new Usuario(nombreUsuario, password, nombre, apellidoP, apellidoM, email, new Date(), telefono, ciudad, estado, tipo, carrera, matricula, campus, universidad);
        cq.insertaUsuarioBD(u);  
        
    }
    
    public void modificaUsuario(){
        
    }
}
