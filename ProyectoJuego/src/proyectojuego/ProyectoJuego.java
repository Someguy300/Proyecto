/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;

/**
 *
 * @author Jesus Barrios y Ricardo Serrano
 */
public class ProyectoJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Juego j = new Juego(); //Juego seria nuestra clase control
        Laberinto l = new Laberinto();
        //j.iniciar;
        l.laberintoCompleto();
    }
    
}
