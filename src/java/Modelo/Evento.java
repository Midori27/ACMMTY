/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author juanjo
 */
public class Evento {
    public static final String NOMBRE_TABLA = "Evento";
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_FECHA = "fecha";
    public static final String COL_LUGAR = "lugar";
    public static final String COL_DESCRIPCION = "descripcion";
    public static final String COL_MAX_INTEGRANTES_POR_EQUIPO = "integrantesPorEquipo";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s,%s)", COL_NOMBRE, COL_FECHA, COL_LUGAR, COL_DESCRIPCION, COL_MAX_INTEGRANTES_POR_EQUIPO);
    private int id;
    private String nombre;
    private Date fecha;
    private String lugar;
    private String descripcion;
    private int maxIntegrantesEquipo;

    public Evento(int id, String nombre, Date fecha, String lugar, String descripcion, int maxIntegrantesEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.maxIntegrantesEquipo = maxIntegrantesEquipo;
    }

    public Evento(String nombre, Date fecha, String lugar, String descripcion, int maxIntegrantesEquipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.maxIntegrantesEquipo = maxIntegrantesEquipo;
    }
    
    public Evento(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.nombre = rs.getString(COL_NOMBRE);
            this.fecha = rs.getDate(COL_FECHA);
            this.lugar = rs.getString(COL_LUGAR);
            this.descripcion = rs.getString(COL_DESCRIPCION);
            this.maxIntegrantesEquipo = rs.getInt(COL_MAX_INTEGRANTES_POR_EQUIPO);
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
   
   
}
