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
    char p = '▓';
    char ent = 'E';
    char sal = 'S';
    
    char [][]lab1 = new char[10][10];
    
    public char [][] setupLaberinto(char [][] vec){
        for (int i = 0; i < lab1.length; i++) {
            for (int j = 0; j < lab1[i].length; j++) {
                if (i==0 || i==9){
                    lab1[i][j]= p;
                } else if(j==0 || j==9){
                    lab1[i][j] = p;
                } else {
                    lab1[i][j] = '░';
                }
                
                
            }  
        }
        return vec;
    }
    
    
    public void impresionLab(char [][] vec){
        for (int i=0; i < vec.length; i++) { //Impresion del laberinto
        System.out.print("|");
        for (int j=0; j < vec[i].length; j++) {
          System.out.print (vec[i][j]);
          if (j!=vec[i].length-1){
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
