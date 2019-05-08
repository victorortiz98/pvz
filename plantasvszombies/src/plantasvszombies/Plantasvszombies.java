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
public class Plantasvszombies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Tablero t = new Tablero(3, 3, "ALTA", 10, 20);
        Juego j = new Juego(t);

        t.rellenarTablero();
        Girasol g = new Girasol(20, 1, 0, 2);
        Lanzaguisantes lg = new Lanzaguisantes("Recto y hacia delante", 50, 3, 1, 1);
        ZombiComun z = new ZombiComun(3, 3, 3, 3);

        t.getTablero().set(1, lg);
        t.getTablero().set(0, g);
        System.out.println(t.getNumeroSoles());
        t.imprimirTablero();
        j.pasaTurno();
        System.out.println(t.getNumeroSoles());
        t.imprimirTablero();
        j.pasaTurno();
        System.out.println(t.getNumeroSoles());
        t.imprimirTablero();
        j.pasaTurno();
        System.out.println(t.getNumeroSoles());
        t.imprimirTablero();
        System.out.println(t.getNumeroSoles());
        j.pasaTurno();
        t.imprimirTablero();
        System.out.println(t.getNumeroSoles());
        j.pasaTurno();
        t.imprimirTablero();
        
        


}
}
