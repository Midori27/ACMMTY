/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Query;
import Modelo.Usuario;
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
public class Login extends HttpServlet {
    //Error a desplegar en caso de datos inválidos.
    private static final String ERR_LOGIN = "Nombre de usuario y/o contraseña inválidos.";
    //Url de la redirección en caso de login exitoso.
    private static final String URL_INDEX = "/index.jsp";
    //Url del forward en caso de login inválido.
    private static final String URL_LOGIN = "/login.jsp";
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
        RequestDispatcher despachador;
        if (iniciaSesion(request)){
            //Se hace forward al inicio.
            despachador = getServletContext().getRequestDispatcher(URL_INDEX);
            despachador.forward(request, response);
        }else{
            //Falló el login.
            request.setAttribute(ATRIBUTO_ERR, ERR_LOGIN);
            //Se obtiene el despachador.
            despachador = getServletContext().getRequestDispatcher(URL_LOGIN);
            //Forward de regreso al login.
            despachador.forward(request, response);
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

    public boolean iniciaSesion(HttpServletRequest request){
        //
        boolean login = false;
        //Se obtiene el controlador de consultas del contexto del servidor.
        Query cq = new Query();
        //Se obtiene el nombre y password de los parametros en el request.
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        if(nombreUsuario == null || password == null){
            return false;
        }
        //Se verifica el usuario y password.
        Integer id = cq.existeUsuario(nombreUsuario, password);
        if(id != null){
            //Se obtiene la sesión.
            HttpSession sesion = request.getSession();
            //Se guarda el id del usuario en la sesion.
            sesion.setAttribute(ATRIBUTO_ID, id);
            login = true;
        }else{
            login = false;
        }
        return login;
    }
}
