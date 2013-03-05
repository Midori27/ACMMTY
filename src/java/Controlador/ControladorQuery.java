/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
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
        ResultSet rs = null;
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
}
