/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Filtro;

import Modelo.Usuario;
import Servlet.Login;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author juanjo
 */
public class FiltroUsuario extends Filtro.FiltroAuth {

    @Override
    protected boolean isAuth(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        if(u==null){
            return false;
        }else{
            return true;
        }
    }

}
