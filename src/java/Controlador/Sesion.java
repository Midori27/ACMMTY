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
        HashMap<String,String> parametros = ParseaParametros.parsea(req, req.getServletContext());
        String nombreUsuario = parametros.get(Usuario.COL_NOMBRE_USUARIO);
        String password = parametros.get(Usuario.COL_PASSWORD);
        boolean auth = false;
        Query q = new Query();

        Usuario u = q.getUsuarioBD(nombreUsuario, password);
        
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
