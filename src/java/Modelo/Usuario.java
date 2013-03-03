/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author juanjo
 */
public class Usuario extends Persona{
    
    private int tipoUsuario;
    private String carrera;

    public Usuario(int tipoUsuario, String carrera, int id, String nombreUsuario, String password, String nombre, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String tel, String dir, int tipo) {
        super(id, nombreUsuario, password, nombre, apellidoP, apellidoM, email, fechaNacimiento, tel, dir, tipo);
        this.tipoUsuario = tipoUsuario;
        this.carrera = carrera;
    }

    public Usuario() {
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
}
