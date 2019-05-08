/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

/**
 *
 * @author Victor
 */
public class Lanzaguisantes extends Planta {
    private String alcance;

    public Lanzaguisantes(String alcance, int coste, int resistencia, int daño, int frecuencia) {
        super(coste, resistencia, daño, frecuencia);
        this.alcance = alcance;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    
    
    
}
