/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanjo
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
    //Error a desplegar en caso de datos inválidos.
    private static final String ERR_LOGIN = "Nombre de usuario y/o contraseña inválidos.";
    //Url de la redirección en caso de login exitoso.
    private static final String URL_REDIRECCION = "index.jsp";
    //Url del forward en caso de login inválido.
    private static final String URL_FORWARD = "/login.jsp";
    //Nombre del atributo con el que se guardara el id del usuario en la sesion.
    public static final String ATRIBUTO_ID = "idusuario";
    //Nombre del atributo que contiene el mensaje de error.
    public static final String ATRIBUTO_ERR = "mensaje";
    
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
        //Se obtiene el controlador de consultas del contexto del servidor.
        ControladorQuery cq = (ControladorQuery) getServletContext().getAttribute("query");
        //Se obtiene el despachador.
        RequestDispatcher despachador = getServletContext().getRequestDispatcher(URL_FORWARD);
        //Se obtiene el nombre y password de los parametros en el request.
        String nombreUsuario = request.getParameter("uname");
        String password = request.getParameter("pass");
        //Se verifica el usuario y password.
        Integer id = cq.existeUsuario(nombreUsuario, password);
        if(id != null){
            //Se obtiene la sesión.
            HttpSession sesion = request.getSession();
            //Se guarda el id del usuario en la sesion.
            sesion.setAttribute(ATRIBUTO_ID, id);
        }else{
            //Falló el login.
            request.setAttribute(ATRIBUTO_ERR, ERR_LOGIN);
            //Forward de regreso al login.
            despachador.forward(request, response);
            return;
        }
        //Se hace la redirección.
        response.sendRedirect(URL_REDIRECCION);
        
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
