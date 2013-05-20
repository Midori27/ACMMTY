/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet;

import Controlador.Email;
import Controlador.ParseaParametros;
import Controlador.Query;
import Modelo.RecuperacionCuenta;
import Modelo.Usuario;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
public class RecuperaCuenta extends HttpServlet {
    public static final String URL_VISTA = "/WEB-INF/Public/recuperaCuenta.jsp";
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
        String email = request.getParameter("email");
        if(email == null || email.isEmpty()){
            request.setAttribute("mensaje", "Es necesario que llenes el campo de email.");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        String url = "http://localhost:"+request.getServerPort()+request.getContextPath();
        Query cq = new Query();
        Integer id = cq.existeUsuarioConEmail(email);
        if(id == null){
            request.setAttribute("mensaje", "La direccion no existe en nuestra base de datos.");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        Usuario u = cq.getUsuarioBD(id);    
            
        if(recuperaPassword(u, url)){
            request.setAttribute("mensaje", "Se ha enviado un correo a tu dirección con más información para recuperar tu cuenta.");
            request.getRequestDispatcher(URL_EXITO).forward(request, response);
            return;
        }else{
            request.setAttribute("mensaje", "Lo sentimos, ya existe una peticion de recuperación de cuenta activa.");
            request.getRequestDispatcher(URL_FALLO).forward(request, response);
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
    
    public boolean recuperaPassword(Usuario u, String url){
       Query cq = new Query();
        if(cq.ExisteRecuperacionCuentaActivoBD(u.getId())){
            return false;
        }
        // crea identificador unico para el link de la recuperacion
        UUID uuid = UUID.randomUUID();
        // registra el tiempo de la peticion
        Date fechaExpedicion = new Date();
        // agrega 12 horas a la fecha de expedicion para formar la de expiracion
        Date fechaExpiracion = new Date(fechaExpedicion.getTime()+(1000*60*60*12));
        String urlRecuperacion = url+"/ReestableceContrasena?uuid="+uuid.toString();
        String de = "acm.monterrey@gmail.com";
        String para = u.getEmail();
        String asunto = "Recuperacion de cuenta ACM Monterrey.";
        String contenido="Hola "+u.getNombre()+",\n Hemos recibido una solicitud de recuperación de contraseña para la cuenta asignada a este correo en monterrey.acm.org.\n\n"
                +"Porfavor accede a la siguiente liga para reestablecer tu contraseña:\n"+urlRecuperacion;
        RecuperacionCuenta rc = new RecuperacionCuenta(u.getId(), fechaExpedicion, fechaExpiracion, uuid);
        cq.insertaRecuperacionCuentaBD(rc);
        Email ce = Email.getInstanceControladorEmail();
        ce.enviaMail(de, para, asunto, contenido);
        return true;
    }
}
