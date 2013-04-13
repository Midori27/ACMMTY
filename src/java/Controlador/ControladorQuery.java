/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Evento;
import Modelo.RecuperacionCuenta;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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
        pool = ControladorPoolBd.getInstancia();
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
     * Toma como parametros dos Strings que representn el nombre de usuario y el password y 
     * realiza una consulta a la base de datos que determina si existe un registro en la tabla
     * de usuarios que concuerde con los dos parámetros.
     * @param nombreUsuario El String que representa el nombre del usuario.
     * @param password El String que representa el password del usuario.
     * @return Integer El valor del id del usuario ó null si no existe.
     */
    public Integer existeUsuarioConEmail(String email){
        Connection conexion = pool.getConexion();
        PreparedStatement existeUsuarioConEmail = null;
        ResultSet rs = null;
        Integer id = null;
        String query = "SELECT "+Usuario.COL_ID+" FROM "+Usuario.NOMBRE_TABLA+" WHERE "+Usuario.COL_EMAIL+" = ?";
        
        try{
            existeUsuarioConEmail = conexion.prepareStatement(query);
            existeUsuarioConEmail.setString(1,email);
            rs = existeUsuarioConEmail.executeQuery();
            
            if(rs.next()){
                id = rs.getInt(Usuario.COL_ID);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                existeUsuarioConEmail.close();
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
     * Obtiene todos los eventos guardados en la base de datos y los regresa en un arreglo de objetos Evento.
     * de datos con el id provisto como parámetro.
     * @return Evento[] Un arreglo que contiene los objetos evento que se encuentran en la base.
     * @see Modelo.Evento
     */ 
    public Evento[] getEventosBd(){
        Connection conexion = pool.getConexion();
        PreparedStatement selectEventos = null;
        ResultSet rs = null;
        Evento eventos[] = null;
        String query = "SELECT * FROM "+Evento.NOMBRE_TABLA;
        int numRegistros;
        int i = 0;
        try{
            selectEventos = conexion.prepareStatement(query);
            rs = selectEventos.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                eventos = new Evento[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    eventos[i] = new Evento(rs);
                    i++;
                }
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectEventos.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return eventos;
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
    
      /**
     * Toma un objeto RecuperacionCuenta e inserta sus campos en un registro de la base de datos.
     * @param rc El objeto RecuperacionCuenta cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaRecuperacionCuentaBD(RecuperacionCuenta rc){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaRecuperacionCuenta = null;
        ResultSet rs = null;
        boolean resultado = true;
        Timestamp tsExpedicion = new Timestamp(rc.getFechaExpedicion().getTime());
        Timestamp tsExpiracion = new Timestamp(rc.getFechaExpiracion().getTime());
        String query = "INSERT INTO "+RecuperacionCuenta.NOMBRE_TABLA+" "+RecuperacionCuenta.CAMPOS_TABLA+" VALUES (?,?,?,?,?)";
        
        try{
            insertaRecuperacionCuenta = conexion.prepareStatement(query);
            insertaRecuperacionCuenta.setInt(1, rc.getIdUsuario());
            insertaRecuperacionCuenta.setTimestamp(2, tsExpedicion);
            insertaRecuperacionCuenta.setTimestamp(3, tsExpiracion);
            insertaRecuperacionCuenta.setString(4, rc.getUuid().toString());
            insertaRecuperacionCuenta.setBoolean(5, false);
            insertaRecuperacionCuenta.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaRecuperacionCuenta.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
     /**
     * Crea un objeto RecuperacionCuenta con los datos extraidos del registro de la base
     * de datos con el UUID provisto como parámetro.
     * @param uuid  Un entero que representa el identificador unico universal generado para recuperar la cuenta.
     * @return RecuperacionCuenta Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.RecuperacionCuenta
     */ 
    public RecuperacionCuenta getRecuperacionCuentaBD(UUID uuid){
        Connection conexion = pool.getConexion();
        PreparedStatement selectRecuperacionCuenta = null;
        ResultSet rs = null;
        RecuperacionCuenta rc = null;
        String query = "SELECT * FROM "+RecuperacionCuenta.NOMBRE_TABLA+" WHERE "+RecuperacionCuenta.COL_UUID+" = ?";
        
        try{
            selectRecuperacionCuenta = conexion.prepareStatement(query);
            selectRecuperacionCuenta.setString(1,uuid.toString());
            rs = selectRecuperacionCuenta.executeQuery();
            
            if(rs.next()){
                rc = new RecuperacionCuenta(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectRecuperacionCuenta.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return rc;
    }
    
     /**
     * Crea un objeto RecuperacionCuenta con los datos extraidos del registro de la base
     * de datos con el UUID provisto como parámetro.
     * @param uuid  Un entero que representa el identificador unico universal generado para recuperar la cuenta.
     * @return RecuperacionCuenta Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.RecuperacionCuenta
     */ 
    public boolean ExisteRecuperacionCuentaActivoBD(int idUsuario){
        Connection conexion = pool.getConexion();
        PreparedStatement existeRecuperacionCuentaActivo = null;
        ResultSet rs = null;
        boolean existe = false;
        String query = "SELECT * FROM "+RecuperacionCuenta.NOMBRE_TABLA+" WHERE "+RecuperacionCuenta.COL_IDUSUARIO+" = ? AND "
                +RecuperacionCuenta.COL_RECLAMO+" = ? AND "+RecuperacionCuenta.COL_FECHA_EXPIRACION+" > ?";
        Timestamp ts = new Timestamp(new Date().getTime());
        try{
            existeRecuperacionCuentaActivo = conexion.prepareStatement(query);
            existeRecuperacionCuentaActivo.setInt(1,idUsuario);
            existeRecuperacionCuentaActivo.setBoolean(2, false);
            existeRecuperacionCuentaActivo.setTimestamp(3, ts);
            rs = existeRecuperacionCuentaActivo.executeQuery();
            
            if(rs.next()){
                existe = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                existeRecuperacionCuentaActivo.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return existe;
    }
}
