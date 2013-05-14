/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Controlador;

import Modelo.Usuario;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanjo
 */
public class Sesion {

    public static boolean iniciaSesion(HttpServletRequest req){
        String email = req.getParameter(Usuario.COL_EMAIL);
        String password = req.getParameter(Usuario.COL_PASSWORD);
        boolean auth = false;
        Query q = new Query();

        Usuario u = q.getUsuarioBD(email, password);
        
        if(u != null){
            // datos de login validos
            auth = true;
            // obtiene la sesión.
            HttpSession sesion = req.getSession();
            // guarda el usuario en la sesion.
            sesion.setAttribute(Usuario.NOMBRE_TABLA, u);
        }
        
        return auth;
    }
}
