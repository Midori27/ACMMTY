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
public class Persona {
    private static final String COL_ID = "Id";
    private static final String COL_NOMBRE_USUARIO = "username";
    private static final String COL_PASSWORD = "password";
    private static final String COL_NOMBRE = "nombre";
    private static final String COL_APELLIDO_P = "apellidoP";
    private static final String COL_APELLIDO_M = "apellidoM";
    private static final String COL_EMAIL = "email";
    private static final String COL_FECHA_NACIMIENTO = "fechaNacimiento";
    private static final String COL_TELEFONO = "telefono";
    private static final String COL_DIR = "direccion";
    private static final String COL_TIPO = "tipo";
    
    private int id;
    private String nombreUsuario;
    private String password;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private Date fechaNacimiento;
    private String telefono;
    private String dir;
    private int tipo;

    public Persona(int id, String nombreUsuario, String password, String nombre, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String telefono, String dir, int tipo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.dir = dir;
        this.tipo = tipo;
    }
    
    public Persona(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.nombreUsuario = rs.getString(COL_NOMBRE_USUARIO);
            this.password = rs.getString(COL_PASSWORD);
            this.nombre = rs.getString(COL_NOMBRE);
            this.apellidoP = rs.getString(COL_APELLIDO_P);
            this.apellidoM = rs.getString(COL_APELLIDO_M);
            this.email = rs.getString(COL_EMAIL);
            this.fechaNacimiento = rs.getDate(COL_FECHA_NACIMIENTO);
            this.telefono = rs.getString(COL_TELEFONO);
            this.dir = rs.getString(COL_DIR);
            this.tipo = rs.getInt(COL_TIPO);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
