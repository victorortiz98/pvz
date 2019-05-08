/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class Juego {

    private Tablero tablero;

    public Juego(Tablero tablero) {
        this.tablero = tablero;

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void plantarGirasol(int fila, int columna) {
        int posCalculada = fila * tablero.getNumeroColumnas() + columna;
        if (tablero.getNumeroSoles() >= 20) {
            if (tablero.getTablero().get(posCalculada) == null) {
                Girasol g1 = new Girasol(20, 1, 0, 2);
                tablero.getTablero().set(posCalculada, g1);
            } else {
                System.out.println("No se ha podido plantar el girasol,la posicion seleccionada ya está ocupada");
            }
        } else {
            System.out.println("No hay suficientes soles");
        }

    }

    public void plantarLanzador(int fila, int columna) {
        int posCalculada = fila * tablero.getNumeroColumnas() + columna;
        if (tablero.getNumeroSoles() >= 50) {
            if (tablero.getTablero().get(posCalculada) == null) {
                Lanzaguisantes lg1 = new Lanzaguisantes("Línea recta", 50, 3, 1, 1); //Alcance lo hemos puesto como String por si en la siguiente práctica la mecanica del alcance del ataque cambia.
                tablero.getTablero().set(posCalculada, lg1);
            } else {
                System.out.println("No se ha podido plantar el lanza guisantes,la posicion seleccionada ya está ocupada");
            }
        } else {
            System.out.println("No hay suficientes soles");
        }
    }

    public void colocarZombi(int fila, int columna) {
        int posCalculada = fila * tablero.getNumeroColumnas() + columna;
        if (tablero.getTablero().get(posCalculada) == null) {
            ZombiComun zc1 = new ZombiComun(1, 5, 1, 1);
            tablero.getTablero().set(posCalculada, zc1);
        }
    }

    public void generarSoles() {
        for (int i = 0; i < (tablero.getNumeroFilas() * tablero.getNumeroColumnas()); i++) {
            if (tablero.getTablero().get(i) != null) {
                if (tablero.getTablero().get(i).getClass().getSimpleName().equals("Girasol")) {

                    if (tablero.getTablero().get(i).getFrecuencia() == 1) {
                        tablero.aumentarSoles();
                        tablero.getTablero().get(i).setFrecuencia(2);
                    } else {
                        tablero.getTablero().get(i).restaFrecuencia();
                    }
                }
            }
        }
    }

    public void ataqueLanzaguisantes() {

        for (int i = 0; i < (tablero.getNumeroFilas() * tablero.getNumeroColumnas()); i++) {
            if (tablero.getTablero().get(i) != null && tablero.getTablero().get(i).getClass().getSimpleName().equals("Lanzaguisantes")) { //hay que preguntar siempre primero si es null porque nos recorre el array entero
                int filaAtaque = i / tablero.getNumeroColumnas(); //calculamos la fila en la que tiene que atacar el lanzaguisantes
                int posAtaque = (filaAtaque + 1) * tablero.getNumeroColumnas(); //calculamos el rango de ataque del lanzaguisantes
                for (int k = i; k < posAtaque; k++) {
                    if (tablero.getTablero().get(k) != null && tablero.getTablero().get(k).getClass().getSimpleName().equals("ZombiComun")) { //igual que arriba
                        tablero.getTablero().get(k).restarVida();
                        if (tablero.getTablero().get(k).getResistencia() == 0) {
                            tablero.getTablero().set(k, null); //para eliminar el zombi ponemos su posicion a null
                            break;
                        }
                    }
                }
            }

        }
    }

    public void ataqueZombicomun() {
        for (int i = 0; i < (tablero.getNumeroFilas() * tablero.getNumeroColumnas()); i++) {
            if (tablero.getTablero().get(i) != null && tablero.getTablero().get(i).getClass().getSimpleName().equals("ZombiComun")) {
                if (tablero.getTablero().get(i - 1) != null && !tablero.getTablero().get(i - 1).getClass().getSimpleName().equals("ZombieComun")) {
                    tablero.getTablero().get(i - 1).restarVida();
                    if (tablero.getTablero().get(i - 1).getResistencia() == 0) {
                        tablero.getTablero().set(i - 1, null);
                        break;
                    }

                }
            }
        }
    }

    public void avanzaZombicomun() {

        for (int i = 0; i < tablero.getNumeroColumnas() * tablero.getNumeroFilas(); i++) {
            if (tablero.getTablero().get(i) != null && tablero.getTablero().get(i).getClass().getSimpleName().equals("ZombiComun")) {
                if (tablero.getTablero().get(i - 1) == null) {
                    if (tablero.getTablero().get(i).getFrecuencia() == 1) {
                        tablero.getTablero().set(i - 1, tablero.getTablero().get(i));
                        tablero.getTablero().set(i, null);
                        tablero.getTablero().get(i - 1).setFrecuencia(2);
                    } else {
                        tablero.getTablero().get(i).restaFrecuencia();
                    }

                }

            }
        }
    }

    public void generarAleatorio() {

        ArrayList<Integer> posVacias = new ArrayList<Integer>();

        for (int i = 0; i < (tablero.getNumeroFilas()); i++) {
            int posCalculada = i * tablero.getNumeroColumnas() + (tablero.getNumeroColumnas() - 1);
            if (tablero.getTablero().get(posCalculada) == null) {
                posVacias.add(posCalculada);

            }
        }
       
        Random r = new Random();
        int Low = 0;
        int High = 100;
        int Result = r.nextInt(High - Low) + Low;

        if ("BAJA".equals(tablero.getDificultad().toUpperCase())) { //Lo comparamos con mayusculas porque hemos puesto toUpper
            if (Result < 25 && tablero.getTurno()>= 10) { //Dificultad fácil. Si el numero aleatorio generado es menor de 25(25% probabilidad) generamos un zombi.
                Collections.shuffle(posVacias);
                if (!posVacias.isEmpty()) {
                   ZombiComun z= new ZombiComun(2, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), z);

                }

            }
        } else if ("MEDIA".equals(tablero.getDificultad().toUpperCase())) {
            if (Result < 50 && tablero.getTurno()>= 7) { //Dificultad media.
                Collections.shuffle(posVacias);
                if (!posVacias.isEmpty()) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);

                }
            }
        } else if ("ALTA".equals(tablero.getDificultad().toUpperCase())) {
            if (Result < 83 && tablero.getTurno()>= 5) { //Dificultad alta.
                Collections.shuffle(posVacias);
                if (posVacias.size() >= 2) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc1 = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);
                    tablero.getTablero().set((posVacias.get(1)), zc1);

                }
                else  if (posVacias.size() >= 1) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);
                }
            }
        } else if ("IMPOSIBLE".equals(tablero.getDificultad().toUpperCase())) {
            if (Result < 95 && tablero.getTurno()>= 5) { //Dificultad imposible.
                Collections.shuffle(posVacias);
                if (posVacias.size() >= 4) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc1 = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc2 = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc3 = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);
                    tablero.getTablero().set((posVacias.get(1)), zc);
                    tablero.getTablero().set((posVacias.get(2)), zc);
                    tablero.getTablero().set((posVacias.get(3)), zc);


                }
                else if (posVacias.size() >= 3) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc1 = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc2 = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);
                    tablero.getTablero().set((posVacias.get(1)), zc);
                    tablero.getTablero().set((posVacias.get(2)), zc);
                }
                else if (posVacias.size() >= 2) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    ZombiComun zc1 = new ZombiComun(1, 5, 1, 2);

                    tablero.getTablero().set((posVacias.get(0)), zc);
                    tablero.getTablero().set((posVacias.get(1)), zc);

                }
                else if (posVacias.size() >= 1) {
                    ZombiComun zc = new ZombiComun(1, 5, 1, 2);
                    tablero.getTablero().set((posVacias.get(0)), zc);

                }
            }
        }

    }
    public void pasaTurno() {
        tablero.aumentarSoles();
        ataqueLanzaguisantes();
        ataqueZombicomun();
        avanzaZombicomun();
        generarAleatorio();
        tablero.pasarTurno();
    }
    public void ganador() {
        
    }


}
