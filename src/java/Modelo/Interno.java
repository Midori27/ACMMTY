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
public class Interno extends Usuario{
    private String matricula;
    private String campus;

    public Interno(String matricula, String carrera, int tipoUsuario, String campus, int id, String nombreUsuario, String password, String nombre, String apellidoP, String apellidoM, String email, Date fechaNacimiento, String tel, String dir, int tipo) {
        super(tipoUsuario, carrera, id, nombreUsuario, password, nombre, apellidoP, apellidoM, email, fechaNacimiento, tel, dir, tipo);
        this.matricula = matricula;
        this.campus = campus;
    }

    public Interno() {
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
    
    
}
