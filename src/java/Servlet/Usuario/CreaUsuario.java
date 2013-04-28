/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Usuario;

import Controlador.Query;
import Helper.Fecha;
import Modelo.Usuario;
import java.io.IOException;
import java.util.Date;
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
    private static final String URL_EXITO = "/WEB-INF/Especial/exito.jsp";
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
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String email = request.getParameter("email");
        Date fechaNacimiento = Fecha.parseFechaAnoMesDia((String) request.getParameter("fechaNacimiento"));
        String telefono = request.getParameter("telefono");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String carrera = request.getParameter("carrera");
        String matricula = request.getParameter("matricula");
        String campus = request.getParameter("campus");
        String universidad = request.getParameter("universidad");
        Integer tipo = (universidad.equals("ITESM")) ? 1 : 2;
        
        
        Usuario u = new Usuario(nombreUsuario, password, nombre, apellidoP, apellidoM, email, fechaNacimiento, telefono, ciudad, estado, tipo, carrera, matricula, campus, universidad);
        
        Validator validator = new Validator();
        List<ConstraintViolation> violation = validator.validate(u);
        if(violation.size()>0){
            request.setAttribute("mensaje", "Porfavor corrija los errores.");
            request.setAttribute("errores", violation);
            request.setAttribute("usuario", u);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        Query cq = new Query();
        
        if(cq.insertaUsuarioBD(u)){
            request.setAttribute("mensaje", "Tu usuario ha sido creado exitosamente");
            request.getRequestDispatcher(URL_EXITO).forward(request, response);
        }else{
            request.setAttribute("usuario", u);
            request.setAttribute("mensaje", "Lo sentimos, tu usuario no puede ser creado en este momento.");
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
