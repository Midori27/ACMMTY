/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Helper.Error;
import Helper.Fecha;
import net.sf.oval.constraint.Future;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
/**
 *
 * @author juanjo
 */
public class Evento {
    public static final String NOMBRE_TABLA = "Evento";
    public static final String COL_ID = "id";
    public static final String COL_IMAGEN = "imagen";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_FECHA = "fecha";
    public static final String COL_LUGAR = "lugar";
    public static final String COL_DESCRIPCION = "descripcion";
    public static final String COL_MAX_INTEGRANTES_POR_EQUIPO = "integrantesPorEquipo";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s,%s,%s)", COL_IMAGEN, COL_NOMBRE, COL_FECHA, COL_LUGAR, COL_DESCRIPCION, COL_MAX_INTEGRANTES_POR_EQUIPO);
    @NotNull
    @Min(value=0)
    private int id;
    @NotBlank(message=COL_IMAGEN+": "+Error.EN_BLANCO)
    private String imagen;
    @NotNull(message=COL_NOMBRE+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_NOMBRE+": "+Error.EN_BLANCO)
    @MaxLength(value=32, message=COL_NOMBRE+": "+Error.TAM_MAX+" 32")
    private String nombre;
    @NotNull(message=COL_FECHA+": "+Error.EN_BLANCO)
    @Future(message=COL_FECHA+": "+Error.FUTURO)
    private Date fecha;
    @NotNull(message=COL_LUGAR+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_LUGAR+": "+Error.EN_BLANCO)
    @MaxLength(value=32, message=COL_LUGAR+": "+Error.TAM_MAX+" 32")
    private String lugar;
    @NotNull(message=COL_DESCRIPCION+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_DESCRIPCION+": "+Error.EN_BLANCO)
    @MaxLength(value=2000, message=COL_DESCRIPCION+": "+Error.TAM_MAX+": 2000")
    private String descripcion;
    @Max(value=20, message=COL_MAX_INTEGRANTES_POR_EQUIPO+": "+Error.MAX+" 20")
    @Min(value=1, message=COL_MAX_INTEGRANTES_POR_EQUIPO+": "+Error.MIN+" 1")
    @NotNull(message=COL_MAX_INTEGRANTES_POR_EQUIPO+": "+Error.EN_BLANCO)
    private int maxIntegrantesEquipo;
    
    public Evento(int id, String imagen, String nombre, Date fecha, String lugar, String descripcion, int maxIntegrantesEquipo) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.maxIntegrantesEquipo = maxIntegrantesEquipo;
    }

    public Evento(String imagen, String nombre, Date fecha, String lugar, String descripcion, int maxIntegrantesEquipo) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.maxIntegrantesEquipo = maxIntegrantesEquipo;
    }
    
    public Evento(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.imagen = rs.getString(COL_IMAGEN);
            this.nombre = rs.getString(COL_NOMBRE);
            this.fecha = Fecha.aFechaJava(rs.getDate(COL_FECHA));
            this.lugar = rs.getString(COL_LUGAR);
            this.descripcion = rs.getString(COL_DESCRIPCION);
            this.maxIntegrantesEquipo = rs.getInt(COL_MAX_INTEGRANTES_POR_EQUIPO);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Evento() {
        this.id=-1;
        this.imagen="";
        this.nombre="";
        this.fecha= new Date();
        this.lugar="";
        this.descripcion="";
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMaxIntegrantesEquipo() {
        return maxIntegrantesEquipo;
    }

    public void setMaxIntegrantesEquipo(int maxIntegrantesEquipo) {
        this.maxIntegrantesEquipo = maxIntegrantesEquipo;
    }
    
    public String getFechaString(){
        return Fecha.aString(fecha);
    }   
    
}
