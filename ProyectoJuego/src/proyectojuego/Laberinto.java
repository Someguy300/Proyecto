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
public class Laberinto {
    //Determinantes paredes del laberinto
   
    private char p = '▓';
    private char ent = 'E';
    private char sal = 'S';
    private char s ='░';
    private char nada = '▒';
    private int nivelLab=1;
    private int tamaño;
    private char[][] lab;
    private int filaEntrada;
    private int columnaEntrada; 
    private int filaSalida; 
    private int columnaSalida; 
    
    
    
    
     public char[][] tamañoLab(int nivelLab) {
        if (nivelLab > 0 && nivelLab < 11) {
            lab = new char[10][10];
            tamaño= lab.length;
            return lab;
        } else if (nivelLab > 10 && nivelLab < 21) {
            lab = new char[20][20];
            tamaño= lab.length;
            return lab;
        } else if (nivelLab > 20 && nivelLab < 31) {
            lab = new char[30][30];
            tamaño= lab.length;
            return lab;
        } else {
            lab = new char[30][30];
            tamaño= lab.length;
            return lab;
        }
    }
    
    public void setupParedesLaberinto(char [][] vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                if ((i==0 || i==(vec.length-1)) || (j==0 || j==(vec[i].length-1))){ //Determina paredes exteriores
                    vec[i][j]= p;
                } else {
                    vec[i][j] = s;   
                }   
            }  
        }
        
    }
    
    public void entradaYSalida(char[][] vec) {
        filaEntrada = (int) ((Math.random() * vec.length)); //Determina la posicion de la Entrada
        
        if (filaEntrada == 0 || filaEntrada == (vec.length - 1)) {
            columnaEntrada = (int) (1 + (Math.random() * (vec.length - 2)));
        } else if (filaEntrada > 0 && filaEntrada < vec.length-1) {
            columnaEntrada = (int) (Math.random() * vec.length-1);
            if (columnaEntrada > (vec.length) / 2) {
                columnaEntrada = (vec.length) - 1;
            } else {
                columnaEntrada = 0;
            }
        }
        
        filaSalida = (int) ((Math.random()*(vec.length))); //Determina la posicion de la salida
        if (filaSalida == 0 || filaSalida == (vec.length-1)){
            columnaSalida = 1+(int) (Math.random()*(vec.length-2));
        } else if (filaSalida>0 && filaSalida <vec.length-1){
            columnaSalida = (int) (Math.random()*vec.length);
            if (columnaSalida > vec.length/2){
                columnaSalida = vec.length-1;
            } else {
                columnaSalida = 0;
            }
        }
        
        vec[filaEntrada] [columnaEntrada] = ent;
        vec[filaSalida] [columnaSalida] = sal;
        
        
        
    }
        
        
    
    
    
    
    public char [][] paredesIzq(char[][] vec, int i, int j,int aux){
        if (largoParedesH(vec)>1 && largoParedesV(vec)>1){
            if (esImpar(aux)==true){
                j = (int) (1+Math.random() * (largoParedesV(vec)-1));
                if (vec[9][j]==sal || vec[0][j]==sal || vec[0][j]==ent || vec[0][j]==ent){
                    do {                        
                        j = (int) (1+Math.random() * (largoParedesV(vec)-1));
                    } while (vec[9][j]==s || vec[0][j]==s || vec[0][j]==ent || vec[0][j]==ent);
                }
                for (int k = 0;  k <= largoParedesV(vec); k++) {
                    vec [k][j] = p;
                }
                i = (int) (1 + Math.random() * (largoParedesV(vec)-1));

                vec [i][j] = nada;
                aux = aux+1;
                return paredesIzq(vec, j, i,aux);
            } else {
                j = (int) (1+Math.random() * (largoParedesH(vec)-1));
//                if (vec[9][j]==sal || vec[0][j]==sal || vec[0][j]==ent || vec[0][j]==ent){
//                    do {                        
//                        j = (int) (2+Math.random() * (largoParedesV(vec)-2));
//                    } while (vec[9][j]==s || vec[0][j]==s || vec[0][j]==ent || vec[0][j]==ent);
//                }
                for (int k = 1;  k <= largoParedesH(vec); k++) {
                    vec [j][k] = p;
                }
                i = (int) (1+ Math.random() *(largoParedesH(vec)-1));

                vec [j][i] = nada;
                aux = aux+1;
                return paredesIzq(vec, j, i,aux);
            }
        }
        return null;
    }
    
    
    public int largoParedesV(char [][]vec){
        for (int i = 1; i < vec.length; i++) {
            for (int j = 1; j < vec.length; j++) {
                if (vec[i][j]==s){
                    for (int k = 1; k < vec.length; k++) {
                        if (vec[k][j]==p){
                            return k-1;
                        } 
                        
                    }
                }
                
            }
            
        }
        return 0;
    }
    
    public int largoParedesH(char[][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==s){
                    for (int k = 1; k < vec.length; k++) {
                        if (vec[j][k]==p){
                            return k-1;
                        }
                        
                    }
                }
                
            }
            
        }
        return 0;
    }

    
    
    
    
    public boolean verificaEntradaySalidaH (char [][]vec, int n){
        if (vec[0][n] == ent || vec[0][n] == sal || vec[(vec.length-1)][n] == ent || vec[(vec.length-1)][n] == sal){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean verificaEntradaySalidaV (char [][]vec, int n){
        for (int k = 0; k < vec.length-1; k++) {
            if (vec[k][n-1]== ent || vec[k][n-1]== sal){
                return true;
            }
            
        }
        return false;
    }
        
//    public boolean failsafeEntrada (char[][]vec){
//        for (int i = 0; i < vec.length; i++) {
//            for (int j = 0; j < vec.length; j++) {
//                if (vec[i][j]==ent){
//                    return false;
//                } 
//            }
//        }
//        return true;
//    }
//    
//    public boolean failsafeSalida (char[][]vec){
//        for (int i = 0; i < vec.length; i++) {
//            for (int j = 0; j < vec.length; j++) {
//                if (vec[i][j]==sal){
//                    return false;
//                } 
//            }
//        }
//        return true;
//    }
//    
//    public void seguridad(char [][]vec){
//        if (failsafeEntrada(vec) && vec[5][0]==p ){
//            vec[5][0] = ent;
//        } else if (failsafeEntrada(vec) && vec[5][0] == sal){
//            vec[7][0] = ent;
//        }
//        if (failsafeSalida(vec) && vec[5][0]==p){
//            vec[7][(vec.length-1)] = sal;
//        } else if (failsafeEntrada(vec) && vec[5][0] == ent){
//            vec[9][(vec.length-1)] = sal;
//        }
//    }
   
    public void impresionLab(char [][] vec){
        for (int i=0; i < vec.length; i++) { //Impresion del laberinto
        System.out.print("|");
        for (int j=0; j < vec[i].length; j++) {
          System.out.print (vec[i][j]);
          if (j!=vec[i].length-1){
              System.out.print(" ");
          }
        }
        System.out.println("|");
        }
    }
    
    
    public boolean esImpar(int n) {
    if (n%2==0) return false;
    else return true;
    }
    
    
    
    char [][]lab1 = new char [10][10];
    public void laberintoCompleto(){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        tamañoLab(nivelLab);
        setupParedesLaberinto(lab1);
        entradaYSalida(lab1);
        System.out.println(largoParedesH(lab1));
        paredesIzq(lab1, 0,0,1);
        impresionLab(lab1);
        
    }

    
    
    
    
    
    
    
}
