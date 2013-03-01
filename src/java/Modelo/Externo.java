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
public class Externo extends Usuario {
    private String universidad;

    public Externo(String universidad, int tipoUsuario, String carrera, String nombreUsuario, String password, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String tel, String dir, int tipo) {
        super(tipoUsuario, carrera, nombreUsuario, password, apellidoP, apellidoM, email, fechaNacimiento, tel, dir, tipo);
        this.universidad = universidad;
    }

    public Externo() {
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    
}
