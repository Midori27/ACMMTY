/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import Helper.Error;

/**
 *
 * @author juanjo
 */
public class MiembroMesa {
    public static final String NOMBRE_TABLA = "MesaDirectiva";
    public static final String COL_ID = "id";
    public static final String COL_PERIODO = "periodo";
    public static final String COL_FOTO = "foto";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_POSICION = "posicion";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s)",COL_PERIODO, COL_FOTO, COL_NOMBRE, COL_POSICION);
    
    
    private int id;
    @NotNull(message=COL_PERIODO+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_PERIODO+": "+Error.EN_BLANCO)
    @MaxLength(value=60, message=COL_PERIODO+": "+Error.TAM_MAX+": 60")
    private String periodo;
    @NotNull(message=COL_FOTO+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_FOTO+": "+Error.EN_BLANCO)
    private String foto;
    @NotNull(message=COL_NOMBRE+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_NOMBRE+": "+Error.EN_BLANCO)
    @MaxLength(value=60, message=COL_NOMBRE+": "+Error.TAM_MAX+": 60")
    private String nombre;
    @NotNull(message=COL_POSICION+": "+Error.EN_BLANCO)
    @NotBlank(message=COL_POSICION+": "+Error.EN_BLANCO)
    @MaxLength(value=60, message=COL_POSICION+": "+Error.TAM_MAX+": 60")
    private String posicion;

    
    public MiembroMesa() {
        this.id=-1;
        this.periodo="";
        this.foto="";
        this.nombre="";
        this.posicion="";
    }

    public MiembroMesa(String periodo, String foto, String nombre, String posicion) {
        this.id=-1;
        this.periodo = periodo;
        this.foto = foto;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public MiembroMesa(int id, String periodo, String foto, String nombre, String posicion) {
        this.id = id;
        this.periodo = periodo;
        this.foto = foto;
        this.nombre = nombre;
        this.posicion = posicion;
    }
    
     public MiembroMesa(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.periodo = rs.getString(COL_PERIODO);
            this.foto = rs.getString(COL_FOTO);
            this.nombre = rs.getString(COL_NOMBRE);
            this.posicion = rs.getString(COL_POSICION);
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    
    
    
    
    
}
