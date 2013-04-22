/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanjo
 */
public class Fecha {
    public static Date parseFechaAnoMesDia(String fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaParseada = null;
        try{
            fechaParseada = formatoFecha.parse(fecha);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return fechaParseada;
    }
    
    public static java.sql.Date aFechaSql(java.util.Date fechaJava){
        return new java.sql.Date(fechaJava.getTime());
    }
    
    public static java.util.Date aFechaJava(java.sql.Date fechaSql){
        return new java.util.Date(fechaSql.getTime());
    }
}
