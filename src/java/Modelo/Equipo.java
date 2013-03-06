/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juanjo
 */
public class Equipo {
    private int id;
    private Evento evento;
    private Usuario[] usuario;
    private String nombre;
    private String estado;
    private int puntaje;

    public Equipo(int id, Evento evento, Usuario[] usuario, String nombre, String estado, int puntaje) {
        this.id = id;
        this.evento = evento;
        this.usuario = usuario;
        this.nombre = nombre;
        this.estado = estado;
        this.puntaje = puntaje;
    }

    public Equipo(Evento evento, Usuario[] usuario, String nombre, String estado, int puntaje) {
        this.evento = evento;
        this.usuario = usuario;
        this.nombre = nombre;
        this.estado = estado;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario[] usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
    
}
