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
                if ((i==0 || i==9) || (j==0 || j==9)){ //Determina paredes exteriores
                    vec[i][j]= p;
                } else {
                    vec[i][j] = '░';   //Placeholder del interior
                }   
            }  
        } 
        
        filaEntrada = (int) ((Math.random()*10)); //Determina la posicion de la Entrada
        if (filaEntrada == 0 || filaEntrada == 9){
            columnaEntrada = 1+(int) (Math.random()*8);   
        }else if (filaEntrada>0 && filaEntrada<9){
            columnaEntrada = (int) (Math.random()*10);
            if (columnaEntrada >= 5){
                columnaEntrada = 9;
            } else {
                columnaEntrada = 0;
            }  
        }
        
        filaSalida = (int) ((Math.random()*10)); //Determina la posicion de la salida
        if (filaSalida == 0 || filaSalida == 9){
            columnaSalida = 1+(int) (Math.random()*8);
        } else if (filaSalida>0 && filaSalida <9){
            columnaSalida = (int) (Math.random()*10);
            if (columnaSalida >= 5){
                columnaSalida = 9;
            } else {
                columnaSalida = 0;
            }  
        }
        
        vec[filaEntrada] [columnaEntrada] = ent;
        vec[filaSalida] [columnaSalida] = sal;
        
        
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
    
    public void laberintoCompleto(){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        setupParedesLaberinto(lab1);
        impresionLab(lab1);
    }
    
    
    
    
    
    
    
    //Setters y Getters

    public int getColumnaEntrada() {
        return columnaEntrada;
    }

    public void setColumnaEntrada(int columnaEntrada) {
        this.columnaEntrada = columnaEntrada;
    }

    public int getColumnaSalida() {
        return columnaSalida;
    }

    public void setColumnaSalida(int columnaSalida) {
        this.columnaSalida = columnaSalida;
    }
    
    
    
    
    
}
