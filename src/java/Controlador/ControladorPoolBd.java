/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta clase se encarga de crear un pool de conexiones a la base de datos.
 * @author Juan Jose Leñero
 */
public class ControladorPoolBd {
    // constantes de configuracion
    private static final String URL_JDBC = "jdbc:mysql://localhost:3306/PortalACM";
    private static final String PW_BD = "";
    private static final String USUARIO_BD = "root";
    private static final int CONEXIONES_MAX_POR_PARTICION = 5;
    private static final int CONEXIONES_MIN_POR_PARTICION = 10;
    private static final int PARTICIONES = 1;
    
    private BoneCP connectionPool = null;
    private Connection connection = null;
    private static ControladorPoolBd instancia;
    
    /**
     * Constructor vacio, configura el pool de conexiones.
     */
    public ControladorPoolBd(){
        //Carga el driver de jdbc para la conexion.
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
        //Configura dbpool de BoneCP
        try{
            //Setup del pool
            BoneCPConfig config = new BoneCPConfig();
            //URL JDBC a la base de datos MySQL
            config.setJdbcUrl(URL_JDBC);
            //Usuario MySQL
            config.setUsername(USUARIO_BD);
            //Password MySQL
            config.setPassword(PW_BD);
            //Otros parámetros de configuración
            config.setMinConnectionsPerPartition(CONEXIONES_MIN_POR_PARTICION);
            config.setMaxConnectionsPerPartition(CONEXIONES_MAX_POR_PARTICION);
            config.setPartitionCount(PARTICIONES);
            //Crea el pool con la configuracion dada
            connectionPool = new BoneCP(config);
            //Obtiene una conexion
            connection = connectionPool.getConnection();
            //Prueba la conexion
            if(connection != null){
                System.out.println("Conexion exitosa!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ControladorPoolBd getInstancia(){
        if (instancia == null){
            instancia = new ControladorPoolBd();
        }
        return instancia;
    }
    
 
    /**
     * Obtiene una conexion del pool.
     * @return Connection - Una conexión del pool de conexiones.
     * @see BoneCP
     */
    public Connection getConexion(){
        Connection conexion = null;
        try{
            conexion = connectionPool.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return  conexion;
    }
    
    /**
     * Se encarga de cerrar la conexión que recibe como parametro.
     * @param conexion La conexión a cerrar.
     */
    public void cierraConexion(Connection conexion){
        if(conexion != null){
            try{
                conexion.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
}