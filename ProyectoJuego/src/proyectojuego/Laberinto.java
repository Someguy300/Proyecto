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
    private char nada = ' ';
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
            if (columnaEntrada >= (vec.length) / 2) {
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
            if (columnaSalida >= vec.length/2){
                columnaSalida = vec.length-1;
            } else {
                columnaSalida = 0;
            }
        }
        
        vec[filaEntrada] [columnaEntrada] = ent;
        vec[filaSalida] [columnaSalida] = sal;
        
        
        
    }
        
        
    
    
    
    
    public void dividirLab(char[][] vec, int acumSec,int acumMain, int i, int j, int k, int aux){
        if (k==0 || k==1 || k==2){
            System.out.println("");
        } else {
            if (acumMain == 0){
                if (acumSec == 0){
                    j = (int) (((Math.random()) * (vec.length - 2)) + 1);
                    for (i=1; i < vec.length-1; i++) {
                        vec[i][j] = p;
                    }
                    i= (int) (((Math.random()) * (vec.length - 2)) + 1);
                    vec[i][j]=s;

                    System.out.println(vec.length);
                    System.out.println(j);
                    System.out.println(vec.length-j);

                    impresionLab(vec);
                    System.out.println("");
                    dividirLab (vec, 1,1, i, j,k, aux);
                }
            } else if (acumMain == 1) {
                k = j; 
                System.out.println(k);
                j = (int) (((Math.random()) * (k - 2)) + 1);
                for (i = 1; i < k; i++) {
                    vec [j][i] = p;

                }
                i= (int) (((Math.random()) * (k-1)) + 1);
                vec[j][i]=s;

                impresionLab(vec);
                System.out.println("");
                dividirLab (vec, 1,2, i, j,k, aux);

            } else if (acumMain == 2){
                k = j; 
                System.out.println(k);
                j = 1+ (int) (((Math.random()) * (k)));
                for (i = 1; i < k; i++) {
                    vec [i][j] = p;

                }
                i= 1+(int) (((Math.random()) * (k)));
                vec[i][j]=s;
                //dividirLab (vec, 1,1, i, j,k, aux);  
            }
        }
        
        
   
     
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
    
    char [][]lab1 = new char [10][10];
    
    
    public void laberintoCompleto(){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        tamañoLab(nivelLab);
        setupParedesLaberinto(lab1);
        entradaYSalida(lab1);
        dividirLab(lab1,0,0, 0,0,3,0);
        //paredesLaberinto(lab1, b, a);
        impresionLab(lab1);
        
    }

    
    
    
    
    
    
    
}
