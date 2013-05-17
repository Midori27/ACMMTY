/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Helper;

import java.util.ArrayList;
import java.util.List;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author Juan Jose Leñero
 */
public class Validacion {
    public static ArrayList<String> valida(Object o){
        ArrayList<String> errores = new ArrayList<String>();
        Validator validator = new Validator();
        List<ConstraintViolation> violation = validator.validate(o);
        
        if(violation.size()>0){
            for(int i=0; i<violation.size();i++){
                   errores.add(violation.get(i).getMessage());
            }
        }
        return errores;
    }
   
    public static ArrayList<String> creaError(String error){
        ArrayList<String> errores = new ArrayList<String>();
        errores.add(error);
        return errores;
    }
}
