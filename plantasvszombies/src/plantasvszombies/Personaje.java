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
public class Personaje {
    private int resistencia;
    private int daño;
    private int frecuencia;

    public Personaje(int resistencia, int daño, int frecuencia) {
        this.resistencia = resistencia;
        this.daño = daño;
        this.frecuencia = frecuencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
   
    public void restaFrecuencia() {
        this.frecuencia = this.frecuencia-1;
    }
    public void restarVida(){
        this.resistencia = this.resistencia-1;
}    
}

