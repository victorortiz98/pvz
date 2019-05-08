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
public class Zombi extends Personaje {
    private int velocidad;

    public Zombi(int velocidad, int resistencia, int daño, int frecuencia) {
        super(resistencia, daño, frecuencia);
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
}
