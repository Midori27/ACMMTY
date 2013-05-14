/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Modelo;

import Helper.Error;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author juanjo
 */
public class Noticia {
    public static final String NOMBRE_TABLA = "Noticia";
    public static final String COL_ID = "id";
    public static final String COL_IMAGEN = "imagen";
    public static final String COL_TITULO = "titulo";
    public static final String COL_DESCRIPCION = "descripcion";
    public static final String COL_FECHA = "fecha";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s, %s)", COL_IMAGEN, COL_TITULO, COL_DESCRIPCION, COL_FECHA);

    private int id;
    @NotNull(message=COL_IMAGEN+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_IMAGEN+": "+Error.EN_BLANCO)
    private String imagen;
    @NotNull(message=COL_TITULO+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_TITULO+": "+Error.EN_BLANCO)
    @MaxLength(value=60, message=COL_TITULO+": "+Error.TAM_MAX+": 60")
    private String titulo;
    @NotNull(message=COL_DESCRIPCION+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_DESCRIPCION+": "+Error.EN_BLANCO)
    @MaxLength(value=150, message=COL_DESCRIPCION+": "+Error.TAM_MAX+": 150")
    private String descripcion;
    private Date fecha;
    
    
    public Noticia(int id, String imagen, String titulo, String descripcion, Date fecha) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Noticia(String imagen, String titulo, String descripcion, Date fecha) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    public Noticia(Integer id, String imagen, String titulo, String descripcion) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = null;
    }
    
      public Noticia(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.imagen = rs.getString(COL_IMAGEN);
            this.titulo = rs.getString(COL_TITULO);
            this.descripcion = rs.getString(COL_DESCRIPCION);
            this.fecha = rs.getDate(COL_FECHA);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    

    public Noticia() {
        this.imagen="";
        this.titulo="";
        this.descripcion="";
        this.fecha=null;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
