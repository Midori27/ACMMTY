/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet;

import Controlador.Query;
import Modelo.RecuperacionCuenta;
import Modelo.Usuario;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanjo
 */
public class ReestableceContrasena extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/Public/reestableceContrasena.jsp";
    public static final String URL_EXITO = "/WEB-INF/Mensaje/exito.jsp";
    public static final String URL_FALLO = "/WEB-INF/Mensaje/fallo.jsp";
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
        String password = (String) request.getParameter("password");
        String confirmaPassword = (String) request.getParameter("confirmaPassword");
        String textuuid = (String) request.getParameter("uuid");
        UUID uuid = UUID.fromString(textuuid);
        if(password.equals(confirmaPassword) && password != null && !password.isEmpty()){
            Query cq = new Query();
            RecuperacionCuenta rc = cq.getRecuperacionCuentaBD(uuid);
            if(validaRecuperacionCuenta(rc)){
                if(cq.actualizaPasswordUsuarioBD(rc.getIdUsuario(), password)){
                    cq.reclamaRecuperacionCuentaBD(rc.getId());
                    request.setAttribute("mensaje", "Tu contraseña ha sido actualizada exitosamente.");
                    request.getRequestDispatcher(URL_EXITO).forward(request, response);
                    return;
                }else{
                    request.setAttribute("mensaje", "Lo sentimos, hubo un problema con la base de datos.");
                    request.getRequestDispatcher(URL_VISTA).forward(request, response);
                    return;
                }
            }else{
                request.setAttribute("mensaje", "Lo sentimos la petición de recuperación de cuenta ha caducado o ya fue efectuada.");
                request.getRequestDispatcher(URL_FALLO).forward(request, response);
                return;
            }
           
        }else{
            request.setAttribute("uuid", textuuid);
            request.setAttribute("mensaje", "Las contraseñas no coinciden.");
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
        String uuid = (String) request.getParameter("uuid");
        if(uuid==null || uuid.isEmpty()){
                request.setAttribute("mensaje", "Si intentabas recuperar tu contraseña, asegurate de copiar la dirección como viene en el correo.");
                request.getRequestDispatcher(URL_FALLO).forward(request, response);
                return;
        }
        request.setAttribute("uuid", uuid);
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

    private boolean validaRecuperacionCuenta(RecuperacionCuenta rc){
        Date ahora = new Date();
        if(rc.getReclamo() || rc.getFechaExpiracion().before(ahora)){
            return false;
        }
        return true;
    }
}
