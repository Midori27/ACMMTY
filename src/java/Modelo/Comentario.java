/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author juanjo
 */
public class Comentario {
    public static final String NOMBRE_TABLA_EVENTO = "ComentarioEvento";
    public static final String NOMBRE_TABLA_NOTICIA = "ComentarioNoticia";
    public static final String COL_ID ="id";
    public static final String COL_DESCRIPCION ="descripcion";
    public static final String COL_FECHA = "fecha";
    public static final String COL_ID_EVENTO = "idEvento";
    public static final String COL_ID_NOTICIA = "idNoticia";
    public static final String COL_ID_USUARIO = "idUsuario";
    public static final String COL_NOMBRE_USUARIO = "nombreUsuario";
    
    public static final String CAMPOS_TABLA_EVENTO = String.format("(%s,%s,%s, %s, %s)", COL_DESCRIPCION, COL_FECHA, COL_ID_EVENTO, COL_ID_USUARIO, COL_NOMBRE_USUARIO);
    public static final String CAMPOS_TABLA_NOTICIA = String.format("(%s,%s,%s, %s, %s)", COL_DESCRIPCION, COL_FECHA, COL_ID_NOTICIA, COL_ID_USUARIO, COL_NOMBRE_USUARIO);
    
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Integer idPadre;
    private Integer idUsuario;
    private String nombreUsuario;
    
    public Comentario(){
        id=-1;
        descripcion="";
        fecha=new Date();
        idPadre=-1;
        idUsuario=-1;
        nombreUsuario="";
    }

    public Comentario(Integer id, String descripcion, Date fecha, Integer idPadre, Integer idUsuario, String nombreUsuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idPadre = idPadre;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public Comentario(String descripcion, Date fecha, Integer idPadre, Integer idUsuario, String nombreUsuario) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idPadre = idPadre;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }
    
    public Comentario(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.descripcion = rs.getString(COL_DESCRIPCION);
            this.fecha = rs.getDate(COL_FECHA);
            this.idPadre = rs.getInt(4);
            this.idUsuario = rs.getInt(COL_ID_USUARIO);
            this.nombreUsuario = rs.getString(COL_NOMBRE_USUARIO);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    
    
}
