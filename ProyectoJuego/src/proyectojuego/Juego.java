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
    //Determinantes paredes del laberinto
    char p = '▓';
    char ent = 'E';
    char sal = 'S';
    int filaEntrada;
    int columnaEntrada; 
    int filaSalida; 
    int columnaSalida; 
    
    
    char [][]lab1 = new char[10][10];
    
    public char [][] setupParedesLaberinto(char [][] vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                if ((i==0 || i==(vec.length-1)) || (j==0 || j==(vec[i].length-1))){ //Determina paredes exteriores
                    vec[i][j]= p;
                } else {
                    vec[i][j] = '░';   //Placeholder del interior
                }   
            }  
        } 
        
        filaEntrada = (int) ((Math.random()*vec.length)); //Determina la posicion de la Entrada
        if (filaEntrada == 0 || filaEntrada == (vec.length-1)){
            columnaEntrada = 1+(int) (Math.random()*(vec.length-2));   
        }else if (filaEntrada>0 && filaEntrada<9){
            columnaEntrada = (int) (Math.random()*vec.length);
            if (columnaEntrada >= vec.length/2){
                columnaEntrada = vec.length-1;
            } else {
                columnaEntrada = 0;
            }  
        }
        
        filaSalida = (int) ((Math.random()*vec.length)); //Determina la posicion de la salida
        if (filaSalida == 0 || filaSalida == (vec.length-1)){
            columnaSalida = 1+(int) (Math.random()*(vec.length-2));
        } else if (filaSalida>0 && filaSalida <9){
            columnaSalida = (int) (Math.random()*vec.length);
            if (columnaSalida >= vec.length/2){
                columnaSalida = vec.length-1;
            } else {
                columnaSalida = 0;
            }  
        }
        
        vec[filaEntrada] [columnaEntrada] = ent;
        vec[filaSalida] [columnaSalida] = sal;
        
        
        return vec;
    }
    
    
    char puerta = '#';
    int auxFilas;
    int auxColumnas;
    int i;
    int j;
//    public char pasillosLaberinto (char[][] vec, int filas, int columnas){ //Determina los pasillos del laberinto
//        auxFilas = (int) (Math.random()*(filas-2));
//        auxColumnas = (int) (Math.random()*(columnas-2));
//        
//        
//        return vec;
//    }
    
    
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
    
    public void laberintoCompleto(){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        setupParedesLaberinto(lab1);
        impresionLab(lab1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
