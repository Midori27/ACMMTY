/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Helper;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author juanjo
 */
public class Fecha {
    
    public static final String PATRON = "";
    public static final String FORMATO = "yyyy-MM-dd";
    public static final String MAX_NACIMIENTO = "2012-01-01";
    public static final String MIN_NACIMIENTO = "1900-01-01";
    
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
    
    public static String parseFechaDateTime(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(fecha);
    }
    
    public static java.sql.Date aFechaSql(java.util.Date fechaJava){
        return new java.sql.Date(fechaJava.getTime());
    }
    
    public static java.util.Date aFechaJava(java.sql.Date fechaSql){
        return new java.util.Date(fechaSql.getTime());
    }
    
    public static String aString(java.util.Date fecha){
        Format formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fecha);
    }
}
