/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Controlador;

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
public class ServletRecuperacionCuenta extends HttpServlet {

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
        
        String campo = request.getParameter("campo");
        String email = request.getParameter("email");
        ControladorQuery cq = (ControladorQuery) getServletContext().getAttribute("query");
        Integer id = cq.existeUsuarioConEmail(email);
        String mensaje="";
        if(id == null){
            mensaje="La dirección de correo no existe en nuestra base de datos.";
            request.setAttribute("mensaje", mensaje);
            RequestDispatcher despachadur = getServletContext().getRequestDispatcher("/recuperaCuenta.jsp");
            despachadur.forward(request,response);
        }
        
        if (campo.equals("usuario")){
            recuperaUsuario(id);
        } else{
            if(campo.equals("password")){
                recuperaPassword(id);
            }
        }
            request.setAttribute("mensaje", mensaje);
            //Se obtiene el despachador.
            RequestDispatcher despachador = getServletContext().getRequestDispatcher("/exito.jsp");
            //Forward de regreso al login.
            despachador.forward(request, response);
            return;
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

    public Boolean recuperaUsuario(Integer id){
        //envia mail con usuario
    }
    
    public Boolean recuperaPassword(Integer id){
        //crea hash
        //crea timestamp limite
        //agrega registro a tabla recuperacion
    }
}
