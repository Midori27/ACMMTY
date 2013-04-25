/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Filtro;

import Modelo.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author juanjo
 */
public class FiltroAdmin extends FiltroAuth {

    @Override
    protected boolean isAuth(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute(Usuario.NOMBRE_TABLA);
        if(u.getTipo()==0){
            return true;
        }else{
            return false;
        }
    }
}
