/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Modelo;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author juanjo
 */
public class RecuperacionCuenta {
    public static final String NOMBRE_TABLA = "RecuperacionCuenta";
    public static final String COL_ID = "id";
    public static final String COL_IDUSUARIO = "idUsuario";
    public static final String COL_FECHA_EXPEDICION = "fechaExpedicion";
    public static final String COL_FECHA_EXPIRACION = "fechaExpiracion";
    public static final String COL_UUID = "uuid";
    public static final String COL_RECLAMO = "reclamo";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s,%s)", COL_IDUSUARIO, COL_FECHA_EXPEDICION, COL_FECHA_EXPIRACION, COL_UUID, COL_RECLAMO);
    private int id;
    private int idUsuario;
    private Date fechaExpedicion;
    private Date fechaExpiracion;
    private UUID uuid;
    private boolean reclamo;

    public RecuperacionCuenta(int id, int idUsuario, Date fechaExpedicion, Date fechaExpiracion, UUID uuid, boolean reclamo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaExpiracion = fechaExpiracion;
        this.uuid = uuid;
        this.reclamo = reclamo;
    }

    public RecuperacionCuenta(int idUsuario, Date fechaExpedicion, Date fechaExpiracion, UUID uuid) {
        this.idUsuario = idUsuario;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaExpiracion = fechaExpiracion;
        this.uuid = uuid;
        reclamo=false;
    }

    
    
    public RecuperacionCuenta(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);;
            this.idUsuario = rs.getInt(COL_IDUSUARIO);;
            this.fechaExpedicion = rs.getTimestamp(COL_FECHA_EXPEDICION);
            this.fechaExpiracion = rs.getTimestamp(COL_FECHA_EXPIRACION);
            this.uuid = uuid.fromString(rs.getString(COL_UUID));
            this.reclamo = rs.getBoolean(COL_RECLAMO);
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean getReclamo() {
        return reclamo;
    }

    public void setReclamo(boolean reclamo) {
        this.reclamo = reclamo;
    }
    
    
}
