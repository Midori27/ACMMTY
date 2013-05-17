package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan Jose Leñero
 */
public class Periodo {
    public static final String NOMBRE_TABLA = "Periodo";
    public static final String COL_ID = "id";
    public static final String COL_M_INICIO = "mInicio";
    public static final String COL_A_INICIO = "aInicio";
    public static final String COL_M_FIN = "mFin";
    public static final String COL_A_FIN = "aFin";
    
     public static final String CAMPOS_TABLA = String.format("(%s,%s,%s,%s)",COL_M_INICIO, COL_A_INICIO, COL_M_FIN, COL_A_FIN);
    
    private int id;
    private int aInicio;
    private int aFin;
    private String mInicio;
    private String mFin;

    public Periodo() {
        id=aInicio=aFin=-1;
        mInicio=mFin="";
    }

    public Periodo(int aInicio, int aFin, String mInicio, String mFin) {
        this.aInicio = aInicio;
        this.aFin = aFin;
        this.mInicio = mInicio;
        this.mFin = mFin;
    }
    
    public Periodo(int id, int aInicio, int aFin, String mInicio, String mFin) {
        this.id = id;
        this.aInicio = aInicio;
        this.aFin = aFin;
        this.mInicio = mInicio;
        this.mFin = mFin;
    }
    
      public Periodo(ResultSet rs){
        try{
            this.id = rs.getInt(COL_ID);
            this.mInicio = rs.getString(COL_M_INICIO);
            this.aInicio = rs.getInt(COL_A_INICIO);
            this.mFin = rs.getString(COL_M_FIN);
            this.aFin = rs.getInt(COL_A_FIN);
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getaInicio() {
        return aInicio;
    }

    public void setaInicio(int aInicio) {
        this.aInicio = aInicio;
    }

    public int getaFin() {
        return aFin;
    }

    public void setaFin(int aFin) {
        this.aFin = aFin;
    }

    public String getmInicio() {
        return mInicio;
    }

    public void setmInicio(String mInicio) {
        this.mInicio = mInicio;
    }

    public String getmFin() {
        return mFin;
    }

    public void setmFin(String mFin) {
        this.mFin = mFin;
    }
    
    public String toString(){
        return mInicio + " " + aInicio + " - " + mFin + " " + aFin;
    }
    
    
}
