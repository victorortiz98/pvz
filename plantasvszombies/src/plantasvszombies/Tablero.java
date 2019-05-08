/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Tablero {

    private int numeroFilas;
    private int numeroColumnas;
    private String dificultad;
    private int turno;
    private ArrayList<Personaje> tablero;
    private int numeroSoles;

    public Tablero(int numeroFilas, int numeroColumnas, String dificultad, int turno,  int numeroSoles) {
        this.numeroFilas = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        this.dificultad = dificultad;
        this.turno = turno;
        this.tablero = new ArrayList<>();
        this.numeroSoles = numeroSoles;
    }

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public ArrayList<Personaje> getTablero() {
        return tablero;
    }

    public void setTablero(ArrayList<Personaje> tablero) {
        this.tablero = tablero;
    }

    public int getNumeroSoles() {
        return numeroSoles;
    }

    public void setNumeroSoles(int numeroSoles) {
        this.numeroSoles = numeroSoles;
    }

    public void imprimirTablero() {
        String lineasuperior = ("------------");
        String linealateral = ("|          |");
        System.out.print(this.turno);
        for (int i = 0; i < this.numeroFilas; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                System.out.print(lineasuperior);
            }
            System.out.println("");
            for (int j = 0; j < this.numeroColumnas; j++) {
                if (tablero.get(i * this.numeroColumnas + j) == null) {
                    System.out.print(linealateral);
                }
                else if (tablero.get(j)!= null && tablero.get(i * this.numeroColumnas + j).getClass().getSimpleName().equals("ZombiComun")) {
                    System.out.print("|   Z" + "(" + tablero.get(i * this.numeroColumnas + j).getResistencia() + ")   |");
                }
                else if (tablero.get(j)!= null &&tablero.get(i * this.numeroColumnas + j).getClass().getSimpleName().equals("Lanzaguisantes")) {
                    System.out.print("|   L" + "(" + tablero.get(i * this.numeroColumnas + j).getResistencia() + ")   |");
                }
                else if (tablero.get(j)!= null &&tablero.get(i * this.numeroColumnas + j).getClass().getSimpleName().equals("Girasol")) {
                    System.out.print("|   G" + "(" + tablero.get(i * this.numeroColumnas + j).getResistencia() + ")   |");
                }
                
            }
            System.out.println("");
            for (int j = 0; j < this.numeroColumnas; j++) {
                System.out.print(linealateral);
            }
            System.out.println("");
        }
    }
public void aumentarSoles(){
    this.numeroSoles=this.numeroSoles+10;
}
public void pasarTurno() {
    this.turno = this.turno+1;
}

    public void rellenarTablero() {
        for (int i = 0; i < (this.numeroColumnas * this.numeroFilas); i++) {
            tablero.add(null);
        }
    }

}
