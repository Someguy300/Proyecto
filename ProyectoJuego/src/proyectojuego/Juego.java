/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;

/**
 *
 * @author Jesus Barrios
 */
public class Juego {
    char p = 'P';
    char ent = 'E';
    char sal = 'S';
    
    char [][]lab1 = new char[10][10];
    
    public char [][] setupLaberinto(char [][] vec){
        for (char[] vec1 : vec) {
            //Setup del laberinto
            for (int j = 0; j < vec1.length; j++) {
                vec1[j] = p;
            }  
        }
        return vec;
    }
    
    
    public void impresionLab(char [][] vec){
        for (char[] vec1 : vec) {
            //Impresion del laberinto
            System.out.print("|");
            for (int j = 0; j < vec1.length; j++) {
                System.out.print(vec1[j]);
                if (j != vec1.length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
    }
    
    public void laberintoCompleto(){
        setupLaberinto(lab1);
        impresionLab(lab1);
    }
    
}
