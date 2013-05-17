/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Helper.Fecha;
import Modelo.Comentario;
import Modelo.Equipo;
import Modelo.Evento;
import Modelo.MiembroMesa;
import Modelo.Noticia;
import Modelo.Periodo;
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
public class Query {
    private PoolBd pool = null;
    
    /**
     * Constructor vació, únicamente inicializa el controlador del
     * pool de conexiones.
     * @see Controlador.ControladorPoolBd
     */
    public Query(){
        pool = PoolBd.getInstancia();
    }
    
    /**
     * Crea un objeto Usuario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Usuario Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.Usuario
     */ 
    public Usuario getUsuarioBD(int id){
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
     * Crea un objeto Usuario con los datos extraidos del registro de la base
     * de datos con el nombre de usuario y password provistos como parámetros.
     * @param nombreUsuario  Un String que representa el nombreUsuario del registro que se desea obtener de la base de datos.
     * @param password Un String que representa el password del registro que se deasea obtener de la base de datos.
     * @return Usuario Un objeto usuario inicializado con los datos de la base.
     * @see Modelo.Usuario
     */ 
    public Usuario getUsuarioBD(String email, String password){
        Connection conexion = pool.getConexion();
        PreparedStatement selectUsuario = null;
        ResultSet rs = null;
        Usuario u = null;
        String query = "SELECT * FROM "+Usuario.NOMBRE_TABLA+" WHERE "+Usuario.COL_EMAIL+" = ? AND "
                +Usuario.COL_PASSWORD+" = ?";
        
        try{
            selectUsuario = conexion.prepareStatement(query);
            selectUsuario.setString(1,email);
            selectUsuario.setString(2,password);
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
        String query = "INSERT INTO "+Usuario.NOMBRE_TABLA+" "+Usuario.CAMPOS_TABLA+" VALUES (?,?,?,?,?,?,?)";
        
        try{
            insertaUsuario = conexion.prepareStatement(query);
            insertaUsuario.setString(1, u.getNombreUsuario());
            insertaUsuario.setString(2, u.getPassword());
            insertaUsuario.setString(3, u.getNombre());
            insertaUsuario.setString(4, u.getApellidoP());
            insertaUsuario.setString(5, u.getApellidoM());
            insertaUsuario.setString(6, u.getEmail());
            insertaUsuario.setInt(7, u.getTipo());
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
     * Actualiza el campo del registro en la tabla de usuarios que pertence al usuario provisto.
     * @param u Un objeto Usuario con todos los datos a actualizar en la base de datos.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaUsuarioBD(Usuario u){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaUsuario = null;
        boolean resultado = true;
        String query = "UPDATE "+Usuario.NOMBRE_TABLA+" SET "+Usuario.COL_PASSWORD+"=?,"
                +Usuario.COL_NOMBRE+"=?,"+Usuario.COL_APELLIDO_P+"=?,"+Usuario.COL_APELLIDO_M+"=?,"
                +Usuario.COL_EMAIL+"=?,"+Usuario.COL_TIPO+"=? WHERE "+Usuario.COL_ID+"=?";
        
        try{
            actualizaUsuario = conexion.prepareStatement(query);
            actualizaUsuario.setString(1, u.getPassword());
            actualizaUsuario.setString(2, u.getNombre());
            actualizaUsuario.setString(3, u.getApellidoP());
            actualizaUsuario.setString(4, u.getApellidoM());
            actualizaUsuario.setString(5, u.getEmail());
            actualizaUsuario.setInt(6, u.getTipo());
            actualizaUsuario.setInt(7, u.getId());
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
     * Actualiza el password del registro en la tabla de usuarios que tiene el id provisto.
     * @param id Entero id del usuario cuyo password se va a actualizar.
     * @param password String El nuevo password del usuario.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaPasswordUsuarioBD(int id, String password){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaPasswordUsuario = null;
        boolean resultado = true;
        String query = "UPDATE "+Usuario.NOMBRE_TABLA+" SET "+Usuario.COL_PASSWORD+"=?"
                +"WHERE "+Usuario.COL_ID+"=?";
        
        try{
            actualizaPasswordUsuario = conexion.prepareStatement(query);
            actualizaPasswordUsuario.setString(1, password);
            actualizaPasswordUsuario.setInt(2, id);
            actualizaPasswordUsuario.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                actualizaPasswordUsuario.close();
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
        String query = "INSERT INTO "+Evento.NOMBRE_TABLA+" "+Evento.CAMPOS_TABLA+" VALUES (?,?,?,?,?,?)";
        java.sql.Date fecha = Fecha.aFechaSql(ev.getFecha());
        try{
            insertaEvento = conexion.prepareStatement(query);
            insertaEvento.setString(1, ev.getImagen());
            insertaEvento.setString(2, ev.getNombre());
            insertaEvento.setDate(3,fecha);
            insertaEvento.setString(4,ev.getLugar());
            insertaEvento.setString(5,ev.getDescripcion());
            insertaEvento.setInt(6,ev.getMaxIntegrantesEquipo());
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
     * Actualiza el campo del registro en la tabla de eventos que tiene el id provisto.
     * @param e Un objeto Evento con todos los datos a actualizar en la base de datos.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaEventoBD(Evento ev){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaEvento = null;
        boolean resultado = true;
        String query = "UPDATE "+Evento.NOMBRE_TABLA+" SET "+Evento.COL_IMAGEN+"=?, "+Evento.COL_NOMBRE+"=?, "+Evento.COL_FECHA+"=?"
                +", "+Evento.COL_LUGAR+"=?, "+Evento.COL_DESCRIPCION+"=?, "
                +Evento.COL_MAX_INTEGRANTES_POR_EQUIPO+"=? WHERE "+Evento.COL_ID+"=?";
        java.sql.Date fecha = Fecha.aFechaSql(ev.getFecha());
       
        try{
            actualizaEvento = conexion.prepareStatement(query);
            actualizaEvento.setString(1, ev.getImagen());
            actualizaEvento.setString(2, ev.getNombre());
            actualizaEvento.setDate(3, fecha);
            actualizaEvento.setString(4, ev.getLugar());
            actualizaEvento.setString(5, ev.getDescripcion());
            actualizaEvento.setInt(6, ev.getMaxIntegrantesEquipo());
            actualizaEvento.setInt(7, ev.getId());
            actualizaEvento.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                actualizaEvento.close();
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
    public Evento getEventoBD(int id){
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
    public Evento[] getEventosBD(){
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
    
     /**
     * Actualiza el valor booleano de la columna de reclamo de un objeto RecuperacionCuenta a verdadore
     * @param id Entero id del objeto RecuperacionCuenta cuya columna se va a actualizar.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean reclamaRecuperacionCuentaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement reclamaRecuperacionCuenta = null;
        boolean resultado = true;
        String query = "UPDATE "+RecuperacionCuenta.NOMBRE_TABLA+" SET "+RecuperacionCuenta.COL_RECLAMO+"=?"
                +" WHERE "+RecuperacionCuenta.COL_ID+"=?";
        
        try{
            reclamaRecuperacionCuenta = conexion.prepareStatement(query);
            reclamaRecuperacionCuenta.setBoolean(1, true);
            reclamaRecuperacionCuenta.setInt(2, id);
            reclamaRecuperacionCuenta.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                reclamaRecuperacionCuenta.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Crea un objeto Notica con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Usuario Un objeto Noticia inicializado con los datos de la base.
     * @see Modelo.Noticia
     */ 
    public Noticia getNoticiaBd(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectNoticia = null;
        ResultSet rs = null;
        Noticia n = null;
        String query = "SELECT * FROM "+Noticia.NOMBRE_TABLA+" WHERE "+Noticia.COL_ID+" = ?";
        
        try{
            selectNoticia = conexion.prepareStatement(query);
            selectNoticia.setInt(1,id);
            rs = selectNoticia.executeQuery();
            
            if(rs.next()){
                n = new Noticia(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectNoticia.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return n;
    }
    
     /**
     * Toma un objeto Noticia e inserta sus campos en un registro de la base de datos.
     * @param n El objeto Noticia cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaNoticiaBD(Noticia n){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaNoticia = null;
        ResultSet rs = null;
        boolean resultado = true;
        Timestamp tsFecha = new Timestamp(n.getFecha().getTime());
        String query = "INSERT INTO "+Noticia.NOMBRE_TABLA+" "+Noticia.CAMPOS_TABLA+" VALUES (?,?,?,?)";
        
        try{
            insertaNoticia = conexion.prepareStatement(query);
            insertaNoticia.setString(1, n.getImagen());
            insertaNoticia.setString(2, n.getTitulo());
            insertaNoticia.setString(3,n.getDescripcion());
            insertaNoticia.setTimestamp(4, tsFecha);
            insertaNoticia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaNoticia.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
      /**
     * Actualiza el campo del registro en la tabla de noticias que tiene el id provisto.
     * @param n Un objeto Noticia con todos los datos a actualizar en la base de datos.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaNoticiaBD(Noticia n){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaNoticia = null;
        boolean resultado = true;
        String query = "UPDATE "+Noticia.NOMBRE_TABLA+" SET "+Noticia.COL_IMAGEN+"=?, "+Noticia.COL_TITULO+"=?"
                +", "+Noticia.COL_DESCRIPCION+"=? WHERE "+Noticia.COL_ID+"=?";
        
        try{
            actualizaNoticia = conexion.prepareStatement(query);
            actualizaNoticia.setString(1, n.getImagen());
            actualizaNoticia.setString(2, n.getTitulo());
            actualizaNoticia.setString(3, n.getDescripcion());
            actualizaNoticia.setInt(4, n.getId());
            actualizaNoticia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                actualizaNoticia.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Toma el id de una noticia registrada en la base de datos y la borra.
     * @param id entero positivo que representa el id de la noticia cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraNoticiaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraNoticia = null;
        boolean resultado = true;
        String query = "DELETE FROM "+Noticia.NOMBRE_TABLA+" WHERE "+Noticia.COL_ID+"=?";
        
        try{
            borraNoticia = conexion.prepareStatement(query);
            borraNoticia.setInt(1,id);
           borraNoticia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraNoticia.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    /**
     * Obtiene todas las noticias guardadas en la base de datos y las regresa en un arreglo de objetos Noticia.
     * de datos con el id provisto como parámetro.
     * @return Noticia[] Un arreglo que contiene los objetos noticia que se encuentran en la base.
     * @see Modelo.Noticia
     */ 
    public Noticia[] getNoticiasBD(){
        Connection conexion = pool.getConexion();
        PreparedStatement selectNoticias = null;
        ResultSet rs = null;
        Noticia noticias[] = null;
        String query = "SELECT * FROM "+Noticia.NOMBRE_TABLA;
        int numRegistros;
        int i = 0;
        try{
            selectNoticias = conexion.prepareStatement(query);
            rs = selectNoticias.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                noticias = new Noticia[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    noticias[i] = new Noticia(rs);
                    i++;
                }
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectNoticias.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return noticias;
    }
    
      /**
     * Toma un objeto MiembroMesa e inserta sus campos en un registro de la base de datos.
     * @param m El objeto MiembroMesa cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaMiembroMesaBD(MiembroMesa m){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaMiembroMesa = null;
        ResultSet rs = null;
        boolean resultado = true;
        String query = "INSERT INTO "+MiembroMesa.NOMBRE_TABLA+" "+MiembroMesa.CAMPOS_TABLA+" VALUES (?,?,?,?)";
        
        try{
            insertaMiembroMesa = conexion.prepareStatement(query);
            insertaMiembroMesa.setInt(1, m.getIdPeriodo());
            insertaMiembroMesa.setString(2, m.getFoto());
            insertaMiembroMesa.setString(3, m.getNombre());
            insertaMiembroMesa.setString(4, m.getPosicion());
            insertaMiembroMesa.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaMiembroMesa.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
      /**
     * Actualiza el campo del registro en la tabla de MesaDirectiva que tiene el id provisto.
     * @param m Un objeto MiembroMesa con todos los datos a actualizar en la base de datos.
     * @return true si se pudo actualizar el registro, false en caso contrario
     */
    public boolean actualizaMiembroMesaBD(MiembroMesa m){
        Connection conexion = pool.getConexion();
        PreparedStatement actualizaMiembroMesa = null;
        boolean resultado = true;
        String query = "UPDATE "+MiembroMesa.NOMBRE_TABLA+" SET "+MiembroMesa.COL_PERIODO+"=?, "+MiembroMesa.COL_FOTO+"=?"
                +", "+MiembroMesa.COL_NOMBRE+"=?, "+MiembroMesa.COL_POSICION+"=? WHERE "+MiembroMesa.COL_ID+"=?";
        
        try{
            actualizaMiembroMesa = conexion.prepareStatement(query);
            actualizaMiembroMesa.setInt(1, m.getIdPeriodo());
            actualizaMiembroMesa.setString(2, m.getFoto());
            actualizaMiembroMesa.setString(3, m.getNombre());
            actualizaMiembroMesa.setString(4, m.getPosicion());
            actualizaMiembroMesa.setInt(5, m.getId());
            actualizaMiembroMesa.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                actualizaMiembroMesa.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Toma el id de un MiembroMesa registrado en la base de datos y lo borra.
     * @param id entero positivo que representa el id del MiembroMesa cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraMiembroMesaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraMiembroMesa = null;
        boolean resultado = true;
        String query = "DELETE FROM "+MiembroMesa.NOMBRE_TABLA+" WHERE "+MiembroMesa.COL_ID+"=?";
        
        try{
            borraMiembroMesa = conexion.prepareStatement(query);
            borraMiembroMesa.setInt(1,id);
            int registrosAfectados = borraMiembroMesa.executeUpdate();
            if(registrosAfectados==0) resultado=false;
            
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraMiembroMesa.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    /**
     * Obtiene el objeto MiembroMesa con el id provisto de la base de datos. 
     * @param id El id entero del registro a instanciar.
     * @return MiembroMesa El objeto MiembroMesa instanciado con los datos de la base de datos.
     * @see Modelo.MiembroMesa
     */ 
    public MiembroMesa getMiembroMesaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectMiembroMesa = null;
        ResultSet rs = null;
        MiembroMesa miembro = null;
        String query = "SELECT * FROM "+MiembroMesa.NOMBRE_TABLA+" WHERE "+MiembroMesa.COL_ID+"=?";
        try{
            selectMiembroMesa = conexion.prepareStatement(query);
            selectMiembroMesa.setInt(1, id);
            rs = selectMiembroMesa.executeQuery();
            if(rs.next()){
                miembro = new MiembroMesa(rs);
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectMiembroMesa.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return miembro;
    }
    
     /**
     * Obtiene todos los MiembroMesa guardados en la base de datos y los regresa en un arreglo de objetos MiembroMesa.
     * @return MiembroMEsa[] Un arreglo que contiene los objetos MiembroMesa que se encuentran en la base.
     * @see Modelo.MiembroMesa
     */ 
    public MiembroMesa[] getMiembrosMesaBD(){
        Connection conexion = pool.getConexion();
        PreparedStatement selectMiembrosMesa = null;
        ResultSet rs = null;
        MiembroMesa miembros[] = null;
        String query = "SELECT * FROM "+MiembroMesa.NOMBRE_TABLA;
        int numRegistros;
        int i = 0;
        try{
            selectMiembrosMesa = conexion.prepareStatement(query);
            rs = selectMiembrosMesa.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                miembros = new MiembroMesa[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    miembros[i] = new MiembroMesa(rs);
                    i++;
                }
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectMiembrosMesa.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return miembros;
    }
    
         /**
     * Crea un objeto Equipo con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Equipo Un objeto equipo inicializado con los datos de la base.
     * @see Modelo.Equipo
     */ 
    public Equipo getEquipoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectEquipo = null;
        ResultSet rs = null;
        Equipo eq = null;
        String query = "SELECT * FROM "+Equipo.NOMBRE_TABLA+" WHERE "+Equipo.COL_ID+" = ?";
        
        try{
            selectEquipo = conexion.prepareStatement(query);
            selectEquipo.setInt(1,id);
            rs = selectEquipo.executeQuery();
            
            if(rs.next()){
                eq = new Equipo(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectEquipo.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return eq;
    }
    
     /**
     * Toma un objeto Equipo e inserta sus campos en un registro de la base de datos.
     * @param eq El objeto Equipo cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaEquipoBD(Equipo eq){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaEquipo = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Equipo.NOMBRE_TABLA+" "+Equipo.CAMPOS_TABLA+" VALUES (?,?,?,?,?,?,?)";

        try{
            insertaEquipo = conexion.prepareStatement(query);
            insertaEquipo.setInt(1, eq.getIdEvento());
            insertaEquipo.setInt(2,eq.getIdUsuarios().get(0));
            insertaEquipo.setString(3,eq.getNombre());
            insertaEquipo.setString(4,eq.getEstado());
            insertaEquipo.setInt(5,eq.getPuntaje());
            insertaEquipo.setString(6,eq.getClave());
            insertaEquipo.setInt(7,eq.getMaxIntegrantes());
            insertaEquipo.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaEquipo.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
       /**
     * Crea un objeto Comentario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Comentario Un objeto Comentario inicializado con los datos de la base.
     * @see Modelo.Comentario
     */ 
    public Comentario getComentarioNoticiaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectComentario = null;
        ResultSet rs = null;
        Comentario c = null;
        String query = "SELECT * FROM "+Comentario.NOMBRE_TABLA_NOTICIA+" WHERE "+Comentario.COL_ID+" = ?";
        
        try{
            selectComentario = conexion.prepareStatement(query);
            selectComentario.setInt(1,id);
            rs = selectComentario.executeQuery();
            
            if(rs.next()){
                c = new Comentario(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectComentario.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return c;
    }
    
           /**
     * Crea un arreglo de objetos Comentario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id de los registros que se desean obtener de la base de datos.
     * @return Comentario[] Un arreglo de objetos Comentario inicializado con los datos de la base.
     * @see Modelo.Comentario
     */ 
    public Comentario[] getComentariosNoticiaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectComentarios = null;
        ResultSet rs = null;
        Comentario[] comentarios = null;
        String query = "SELECT * FROM "+Comentario.NOMBRE_TABLA_NOTICIA+" WHERE "+Comentario.COL_ID_NOTICIA+" = ?";
        int numRegistros;
        int i = 0;
        try{
            selectComentarios = conexion.prepareStatement(query);
            selectComentarios.setInt(1,id);
            rs = selectComentarios.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                comentarios = new Comentario[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    comentarios[i] = new Comentario(rs);
                    i++;
                }
            }
           
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectComentarios.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return comentarios;
    }
    
     /**
     * Toma un objeto Comentario e inserta sus campos en un registro de la base de datos.
     * @param c El objeto Comentario cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaComentarioNoticiaBD(Comentario c){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaComentario = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Comentario.NOMBRE_TABLA_NOTICIA+" "+Comentario.CAMPOS_TABLA_NOTICIA+" VALUES (?,?,?,?,?)";
        String fechaDateTime = Fecha.parseFechaDateTime(c.getFecha());
        
        java.sql.Date fecha = new java.sql.Date(c.getFecha().getTime());
        
        try{
            insertaComentario = conexion.prepareStatement(query);
            insertaComentario.setString(1, c.getDescripcion());
            insertaComentario.setDate(2, fecha);
            insertaComentario.setInt(3,c.getIdPadre());
            insertaComentario.setInt(4,c.getIdUsuario());
            insertaComentario.setString(5,c.getNombreUsuario());
            insertaComentario.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaComentario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    /**
     * Toma el id de un ComentarioEvento registrado en la base de datos y lo borra.
     * @param id entero positivo que representa el id del comentario cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraComentarioNoticiaBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraComentario = null;
        boolean resultado = true;
        String query = "DELETE FROM "+Comentario.NOMBRE_TABLA_NOTICIA+" WHERE "+Comentario.COL_ID+"=?";
        
        try{
            borraComentario = conexion.prepareStatement(query);
            borraComentario.setInt(1,id);
            int registrosAfectados = borraComentario.executeUpdate();
            if(registrosAfectados==0) resultado=false;
            
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraComentario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
      /**
     * Crea un objeto Comentario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id del registro que se desea obtener de la base de datos.
     * @return Comentario Un objeto Comentario inicializado con los datos de la base.
     * @see Modelo.Comentario
     */ 
    public Comentario getComentarioEventoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectComentario = null;
        ResultSet rs = null;
        Comentario c = null;
        String query = "SELECT * FROM "+Comentario.NOMBRE_TABLA_EVENTO+" WHERE "+Comentario.COL_ID+" = ?";
        
        try{
            selectComentario = conexion.prepareStatement(query);
            selectComentario.setInt(1,id);
            rs = selectComentario.executeQuery();
            
            if(rs.next()){
                c = new Comentario(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectComentario.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return c;
    }
    
        /**
     * Crea un arreglo de objetos Comentario con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id  Un entero que representa el id de los registros que se desean obtener de la base de datos.
     * @return Comentario[] Un arreglo de objetos Comentario inicializado con los datos de la base.
     * @see Modelo.Comentario
     */ 
    public Comentario[] getComentariosEventoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectComentarios = null;
        ResultSet rs = null;
        Comentario[] comentarios = null;
        String query = "SELECT * FROM "+Comentario.NOMBRE_TABLA_EVENTO+" WHERE "+Comentario.COL_ID_EVENTO+" = ?";
        int numRegistros;
        int i = 0;
        try{
            selectComentarios = conexion.prepareStatement(query);
            selectComentarios.setInt(1,id);
            rs = selectComentarios.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                comentarios = new Comentario[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    comentarios[i] = new Comentario(rs);
                    i++;
                }
            }
           
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectComentarios.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return comentarios;
    }
    
     /**
     * Toma un objeto Comentario e inserta sus campos en un registro de la base de datos.
     * @param c El objeto Comentario cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     */
    public boolean insertaComentarioEventoBD(Comentario c){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaComentario = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Comentario.NOMBRE_TABLA_EVENTO+" "+Comentario.CAMPOS_TABLA_EVENTO+" VALUES (?,?,?,?,?)";
        
        java.sql.Date fecha = new java.sql.Date(c.getFecha().getTime());
        
        try{
            insertaComentario = conexion.prepareStatement(query);
            insertaComentario.setString(1, c.getDescripcion());
            insertaComentario.setDate(2, fecha);
            insertaComentario.setInt(3,c.getIdPadre());
            insertaComentario.setInt(4,c.getIdUsuario());
            insertaComentario.setString(5,c.getNombreUsuario());
            insertaComentario.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaComentario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Toma el id de un ComentarioEvento registrado en la base de datos y lo borra.
     * @param id entero positivo que representa el id del comentario cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraComentarioEventoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraComentario = null;
        boolean resultado = true;
        String query = "DELETE FROM "+Comentario.NOMBRE_TABLA_EVENTO+" WHERE "+Comentario.COL_ID+"=?";
        
        try{
            borraComentario = conexion.prepareStatement(query);
            borraComentario.setInt(1,id);
            int registrosAfectados = borraComentario.executeUpdate();
            if(registrosAfectados==0) resultado=false;
            
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraComentario.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    /**
     * Toma un objeto Periodo p e inserta sus campos en un registro de la base de datos.
     * @param p El objeto Periodo cuyos datos se desean registrar en la base de datos.
     * @return true si se pudo insertar el registro, false en caso contrario
     * @see Modelo.Periodo
     */
    public boolean insertaPeriodoBD(Periodo p){
        Connection conexion = pool.getConexion();
        PreparedStatement insertaPeriodo = null;
        boolean resultado = true;
        String query = "INSERT INTO "+Periodo.NOMBRE_TABLA+" "+Periodo.CAMPOS_TABLA+" VALUES (?,?,?,?)";
        
        try{
            insertaPeriodo = conexion.prepareStatement(query);
            insertaPeriodo.setString(1, p.getmInicio());
            insertaPeriodo.setInt(2, p.getaInicio());
            insertaPeriodo.setString(3, p.getmFin());
            insertaPeriodo.setInt(4, p.getaFin());
            insertaPeriodo.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                insertaPeriodo.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Toma el id de un Periodo registrado en la base de datos y lo borra.
     * @param id entero positivo que representa el id del Periodo cuyos datos se desean borrar de la base de datos.
     * @return true si se pudo borrar el registro, false en caso contrario
     */
    public boolean borraPeriodoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement borraPeriodo = null;
        boolean resultado = true;
        String query = "DELETE FROM "+Periodo.NOMBRE_TABLA+" WHERE "+Periodo.COL_ID+"=?";
        
        try{
            borraPeriodo = conexion.prepareStatement(query);
            borraPeriodo.setInt(1,id);
            int registrosAfectados = borraPeriodo.executeUpdate();
            if(registrosAfectados==0) resultado=false;
            
        } catch (SQLException e){
            e.printStackTrace();
            resultado = false;
        } finally {
            pool.cierraConexion(conexion);
            try{
                borraPeriodo.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
    
        /**
     * Crea un arreglo de objetos MiembroMesa con los datos extraidos del registro de la base
     * de datos con el id de Periodo provisto como parámetro.
     * @param id  Un entero que representa el id del Periodo cuyos miembros se desean obtener.
     * @return MiembroMesa[] Un arreglo de objetos Comentario inicializado con los datos de la base.
     * @see Modelo.MiembroMesa
     */ 
    public MiembroMesa[] getMiembrosPeriodoBD(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectMiembrosPeriodo = null;
        ResultSet rs = null;
        MiembroMesa[] miembros = null;
        String query = "SELECT * FROM "+MiembroMesa.NOMBRE_TABLA+" WHERE "+ MiembroMesa.COL_PERIODO+" = ?";
        int numRegistros;
        int i = 0;
        try{
            selectMiembrosPeriodo = conexion.prepareStatement(query);
            selectMiembrosPeriodo.setInt(1,id);
            rs = selectMiembrosPeriodo.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                miembros = new MiembroMesa[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    miembros[i] = new MiembroMesa(rs);
                    i++;
                }
            }
           
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectMiembrosPeriodo.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return miembros;
    }
    
         /**
     * Obtiene todos los periodos guardados en la base de datos y los regresa en un arreglo de objetos Periodo.
     * de datos con el id provisto como parámetro.
     * @return Periodo[] Un arreglo que contiene los objetos periodo que se encuentran en la base.
     * @see Modelo.Periodo
     */ 
    public Periodo[] getPeriodosBD(){
        Connection conexion = pool.getConexion();
        PreparedStatement selectPeriodos = null;
        ResultSet rs = null;
        Periodo[] periodos = null;
        String query = "SELECT * FROM "+Periodo.NOMBRE_TABLA;
        int numRegistros;
        int i = 0;
        try{
            selectPeriodos = conexion.prepareStatement(query);
            rs = selectPeriodos.executeQuery();
            if(rs.first()){
                rs.last();
                numRegistros = rs.getRow();
                periodos = new Periodo[numRegistros];
                rs.beforeFirst();
                
                while(rs.next()){
                    periodos[i] = new Periodo(rs);
                    i++;
                }
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectPeriodos.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return periodos;
    }
}
