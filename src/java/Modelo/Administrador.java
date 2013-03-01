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
public class Administrador extends Persona {
    private int nivel;

    public Administrador(int nivel, String nombreUsuario, String password, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String tel, String dir, int tipo) {
        super(nombreUsuario, password, apellidoP, apellidoM, email, fechaNacimiento, tel, dir, tipo);
        this.nivel = nivel;
    }

    public Administrador() {
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
