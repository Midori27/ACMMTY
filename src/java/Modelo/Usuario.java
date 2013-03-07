/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author juanjo
 */
public class Usuario {
    public static final String NOMBRE_TABLA = "Usuario";
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE_USUARIO = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APELLIDO_P = "apellidoP";
    public static final String COL_APELLIDO_M = "apellidoM";
    public static final String COL_EMAIL = "email";
    public static final String COL_FECHA_NACIMIENTO = "fechaNacimiento";
    public static final String COL_TELEFONO = "telefono";
    public static final String COL_CIUDAD = "ciudad";
    public static final String COL_ESTADO = "estado";
    public static final String COL_TIPO = "tipo";
    public static final String COL_CARRERA = "carrera";
    public static final String COL_MATRICULA = "matricula";
    public static final String COL_CAMPUS = "campus";
    public static final String COL_UNIVERSIDAD = "universidad";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
            COL_NOMBRE_USUARIO, COL_PASSWORD, COL_NOMBRE, COL_APELLIDO_P, COL_APELLIDO_M, COL_EMAIL, COL_FECHA_NACIMIENTO,
            COL_TELEFONO, COL_CIUDAD, COL_ESTADO, COL_TIPO, COL_CARRERA, COL_MATRICULA, COL_CAMPUS, COL_UNIVERSIDAD); 
    
    private int id;
    private String nombreUsuario;
    private String password;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private Date fechaNacimiento;
    private String telefono;
    private String ciudad;
    private String estado;
    private int tipo;
    private String carrera;
    private String matricula;
    private String campus;
    private String universidad;

    public Usuario(int id, String nombreUsuario, String password, String nombre, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String telefono, String ciudad, String estado, int tipo, String carrera, String matricula, String campus, String universidad) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.estado = estado;
        this.tipo = tipo;
        this.carrera = carrera;
        this.matricula = matricula;
        this.campus = campus;
        this.universidad = universidad;
    }
    
    public Usuario(String nombreUsuario, String password, String nombre, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String telefono, String ciudad, String estado, int tipo, String carrera, String matricula, String campus, String universidad) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.estado = estado;
        this.tipo = tipo;
        this.carrera = carrera;
        this.matricula = matricula;
        this.campus = campus;
        this.universidad = universidad;
    }
    
    public Usuario(ResultSet rs){
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
            this.ciudad = rs.getString(COL_CIUDAD);
            this.estado = rs.getString(COL_ESTADO);
            this.tipo = rs.getInt(COL_TIPO);
            this.carrera = rs.getString(COL_CARRERA);
            this.matricula = rs.getString(COL_MATRICULA);
            this.campus = rs.getString(COL_CAMPUS);
            this.universidad = rs.getString(COL_UNIVERSIDAD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Usuario() {
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
        return nombre;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    
}
