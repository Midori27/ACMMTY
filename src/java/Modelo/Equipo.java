/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juanjo
 */
public class Equipo {
    public static final String NOMBRE_TABLA = "Equipo";
    public static final String COL_ID = "id";
    public static final String COL_ID_EVENTO = "idEvento";
    public static final String COL_ID_USUARIOS = "idUsuario";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_ESTADO = "estado";
    public static final String COL_PUNTAJE = "puntaje";
    public static final String COL_CLAVE = "clave";
    public static final String COL_MAX_INTEGRANTES = "maxIntegrantes";
    public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s,%s,%s,%s)",COL_ID_EVENTO,COL_ID_USUARIOS,COL_NOMBRE,COL_ESTADO,COL_PUNTAJE,COL_CLAVE,COL_MAX_INTEGRANTES);
    
    private int id;
    private int idEvento;
    private ArrayList<Integer> idUsuarios;
    private String nombre;
    private String estado;
    private int puntaje;
    private String clave;
    private int maxIntegrantes;

    public Equipo(int id, int idEvento, ArrayList<Integer> idUsuarios, String nombre, String estado, int puntaje, String clave, int maxIntegrantes) {
        this.id = id;
        this.idEvento = idEvento;
        this.idUsuarios = idUsuarios;
        this.nombre = nombre;
        this.estado = estado;
        this.puntaje = puntaje;
        this.clave = clave;
        this.maxIntegrantes = maxIntegrantes;
    }
    public Equipo(){
        id=-1;
        idEvento=-1;
        idUsuarios= new ArrayList<Integer>();
        nombre="";
        estado="";
        puntaje=0;
        clave="";
        maxIntegrantes=0;
    }

    public Equipo(int idEvento, ArrayList<Integer> idUsuarios, String nombre, String estado, int puntaje, String clave, int maxIntegrantes) {
        this.idEvento = idEvento;
        this.idUsuarios = idUsuarios;
        this.nombre = nombre;
        this.estado = estado;
        this.puntaje = puntaje;
        this.clave = clave;
        this.maxIntegrantes = maxIntegrantes;
    }
    
      public Equipo(ResultSet rs){
        try{
            id = rs.getInt(COL_ID);
            idEvento = rs.getInt(COL_ID_EVENTO);
            nombre = rs.getString(COL_NOMBRE);
            estado = rs.getString(COL_ESTADO);
            puntaje = rs.getInt(COL_PUNTAJE);
            clave = rs.getString(COL_CLAVE);
            maxIntegrantes = rs.getInt(COL_MAX_INTEGRANTES);
            idUsuarios = new ArrayList<Integer>();
            do{
                idUsuarios.add(rs.getInt(COL_ID_USUARIOS));
            }while(rs.next());
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getMaxIntegrantes() {
        return maxIntegrantes;
    }

    public void setMaxIntegrantes(int maxIntegrantes) {
        this.maxIntegrantes = maxIntegrantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public ArrayList<Integer> getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(ArrayList<Integer> idUsuarios) {
        this.idUsuarios = idUsuarios;
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
    
    public String getClave(){
        return clave;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public boolean estaCompleto(){
        return idUsuarios.size() >= maxIntegrantes;
    }
    
    public boolean agregaMiembro(Integer idUsuario){
        if(idUsuarios.size()<maxIntegrantes){
            idUsuarios.add(idUsuario);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean quitaMiembro(Integer idUsuario){
        return idUsuarios.remove(idUsuario);
    }
      
}
