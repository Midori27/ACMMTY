/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Helper;

import Modelo.MiembroMesa;
import Modelo.Periodo;

/**
 *
 * @author Juan Jose Leñero
 */
public class ParPeriodoMiembros {
    private Periodo p;
    private MiembroMesa[] miembros;

    public ParPeriodoMiembros() {
    }

    public ParPeriodoMiembros(Periodo p, MiembroMesa[] miembros) {
        this.p = p;
        this.miembros = miembros;
    }

    public Periodo getP() {
        return p;
    }

    public void setP(Periodo p) {
        this.p = p;
    }

    public MiembroMesa[] getMiembros() {
        return miembros;
    }

    public void setMiembros(MiembroMesa[] miembros) {
        this.miembros = miembros;
    }
    
    
}
