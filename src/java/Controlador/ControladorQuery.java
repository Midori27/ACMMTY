/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
     * Crea un objeto Persona con los datos extraidos del registro de la base
     * de datos con el id provisto como parámetro.
     * @param id El id del registro que se desea obtener de la base de datos.
     * @return Persona Un objeto persona inicializado con los datos de la base.
     * @see Modelo.Persona
     */
    public Persona getPersonaBd(int id){
        Connection conexion = pool.getConexion();
        PreparedStatement selectPersona = null;
        ResultSet rs = null;
        Persona p = null;
        String query = "SELECT * FROM Persona WHERE Id = ?";
        
        try{
            selectPersona = conexion.prepareStatement(query);
            selectPersona.setInt(1,id);
            rs = selectPersona.executeQuery();
            
            if(rs.next()){
                p = new Persona(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pool.cierraConexion(conexion);
            try{
                selectPersona.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return p;
    }
}
