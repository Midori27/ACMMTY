/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
package Servlet.Noticia;

import Controlador.Query;
import Controlador.ParseaParametros;
import Modelo.Noticia;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
public class CreaNoticia extends HttpServlet {
    public static final String URL_VISTA="/WEB-INF/Noticia/creaNoticia.jsp";
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
        HashMap<String,String> parametros = ParseaParametros.parsea(request,this.getServletConfig().getServletContext());
        String imagen = parametros.get(Noticia.COL_IMAGEN);
        if(imagen.isEmpty()){
            imagen = parametros.get("imagenSubida");
        }
        String titulo = parametros.get(Noticia.COL_TITULO);
        String descripcion = parametros.get(Noticia.COL_DESCRIPCION);
        Date fecha = new Date();
        Query cq = new Query();
        Noticia n = new Noticia(imagen, titulo, descripcion, fecha);
        
        Validator validator = new Validator();
        List<ConstraintViolation> violation = validator.validate(n);
        if(violation.size()>0){
            request.setAttribute("mensaje", "Porfavor corrija los errores.");
            request.setAttribute("errores", violation);
            request.setAttribute("noticia", n);
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
            return;
        }
        
        if(cq.insertaNoticiaBD(n)){
            request.setAttribute("mensaje", "La noticia ha sido creada exitosamente.");
            request.getRequestDispatcher(URL_VISTA).forward(request, response);
        }else{
            request.setAttribute("mensaje", "Lo sentimos, la noticia no puede ser creada en este momento.");
            request.setAttribute("noticia", n);
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
