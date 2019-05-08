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
public class Planta extends Personaje {
    private int coste;

    public Planta(int coste, int resistencia, int daño, int frecuencia) {
        super(resistencia, daño, frecuencia);
        this.coste = coste;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }
    
}
