/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Evento;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase se encarga de manejar las consultas a la base de datos y la
 * creación de modelos cuyos datos residen en la misma.
 * @author juanjo
 */
public class ControladorQuery {
    private ControladorPoolBd pool = null;
    
    /**
     * Constructor vació, únicamente inicializa el controlador del
     * pool de conexiones.
     * @see Controlador.ControladorPoolBd
     */
    public ControladorQuery(){
        pool = new ControladorPoolBd();
    }
    
    /**
     * Crea un objeto Usuario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Usuario Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.Usuario
     */ 
    public Usuario getUsuarioBd(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectUsuario = null;
        ResultSet rs = null;
        Usuario u = null;
        String query = "SELECT * FROM "+Usuario.NOMBRE_TABLA+" WHERE "+Usuario.COL_ID+" = ?";
        
        try{
            selectUsuario = conexion.prepareStatement(query);
            selectUsuario.setInt(1,id);
            rs = selectUsuario.executeQuery();
            
            if(rs.next()){
                u = new Usuario(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectUsuario.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return u;
    }
    
    /**
     * Toma un objeto Usuario u e inserta sus campos en un registro de la base de datos.
     * @param u El objeto Usuario cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaUsuarioBD(Usuario u){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaUsuario = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Usuario.NOMBRE_TABLA+" "+Usuario.CAMPOS_TABLA+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            insertaUsuario = conexion.prepareStatement(query);
            insertaUsuario.setString(1, u.getNombreUsuario());
            insertaUsuario.setString(2, u.getPassword());
            insertaUsuario.setString(3, u.getNombre());
            insertaUsuario.setString(4, u.getApellidoP());
            insertaUsuario.setString(5, u.getApellidoM());
            insertaUsuario.setString(6, u.getEmail());
            insertaUsuario.setDate(7, java.sql.Date.valueOf("1990-11-27"));
            insertaUsuario.setString(8, u.getTelefono());
            insertaUsuario.setString(9, u.getCiudad());
            insertaUsuario.setString(10, u.getEstado());
            insertaUsuario.setInt(11, u.getTipo());
            insertaUsuario.setString(12, u.getCarrera());
            insertaUsuario.setString(13, u.getMatricula());
            insertaUsuario.setString(14, u.getCampus());
            insertaUsuario.setString(15, u.getUniversidad());
            insertaUsuario.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaUsuario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
     /**
     * Actualiza el campo del registro en la tabla de usuarios que tiene el id provisto.
     * @param id Un entero positivo que representa el id del registro en la base de datos.
     * @param campo Un String que representa el campo que se desea actualizar.
     * @param valor Un String que representa el nuevo valor del campo a actualizar.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaUsuarioBD(int id, String campo, String valor){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaUsuario = null;
        boolean resultado = true;
        String query = "UPDATE "+Usuario.NOMBRE_TABLA+" SET "+campo+"=? WHERE "+Usuario.COL_ID+"=?";
        
        try{
            actualizaUsuario = conexion.prepareStatement(query);
            actualizaUsuario.setString(1, valor);
            actualizaUsuario.setInt(2, id);
            actualizaUsuario.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                actualizaUsuario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    /**
     * Toma como parametros dos Strings que representn el nombre de usuario y el password y 
     * realiza una consulta a la base de datos que determina si existe un registro en la tabla
     * de usuarios que concuerde con los dos parámetros.
     * @param nombreUsuario El String que representa el nombre del usuario.
     * @param password El String que representa el password del usuario.
     * @return Integer El valor del id del usuario ó null si no existe.
     */
    public Integer existeUsuario(String nombreUsuario, String password){
        Connection conexion = pool.getConexion();
        PreparedStatement existeUsuario = null;
        ResultSet rs = null;
        Integer id = null;
        String query = "SELECT * FROM "+Usuario.NOMBRE_TABLA+" WHERE "+Usuario.COL_NOMBRE_USUARIO+" = ? AND "+Usuario.COL_PASSWORD+" = ?";
        
        try{
            existeUsuario = conexion.prepareStatement(query);
            existeUsuario.setString(1,nombreUsuario);
            existeUsuario.setString(2,password);
            rs = existeUsuario.executeQuery();
            
            if(rs.next()){
                id = rs.getInt(Usuario.COL_ID);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                existeUsuario.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return id;
    }
    
       /**
     * Toma un objeto Evento e inserta sus campos en un registro de la base de datos.
     * @param e El objeto Evento cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaEventoBD(Evento ev){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaEvento = null;
        ResultSet rs = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Evento.NOMBRE_TABLA+" "+Evento.CAMPOS_TABLA+" VALUES (?,?,?,?,?)";
        
        try{
            insertaEvento = conexion.prepareStatement(query);
            insertaEvento.setString(1, ev.getNombre());
            insertaEvento.setDate(2, java.sql.Date.valueOf("1990-11-27"));
            insertaEvento.setString(3,ev.getLugar());
            insertaEvento.setString(4,ev.getDescripcion());
            insertaEvento.setInt(5,ev.getMaxIntegrantesEquipo());
            insertaEvento.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaEvento.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Crea un objeto Usuario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Usuario Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.Usuario
     */ 
    public Evento getEventoBd(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectEvento = null;
        ResultSet rs = null;
        Evento ev = null;
        String query = "SELECT * FROM "+Evento.NOMBRE_TABLA+" WHERE "+Evento.COL_ID+" = ?";
        
        try{
            selectEvento = conexion.prepareStatement(query);
            selectEvento.setInt(1,id);
            rs = selectEvento.executeQuery();
            
            if(rs.next()){
                ev = new Evento(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectEvento.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return ev;
    }
    
     /**
     * Toma el id de un evento registrado en la base de datos y lo borra.
     * @param id entero positivo que representa el id del evento cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraEventoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraEvento = null;
        boolean resultado = true;
        String query = "DELETE FROM "+Evento.NOMBRE_TABLA+" WHERE "+Evento.COL_ID+"=?";
        
        try{
            borraEvento = conexion.prepareStatement(query);
            borraEvento.setInt(1,id);
            borraEvento.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraEvento.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
}
