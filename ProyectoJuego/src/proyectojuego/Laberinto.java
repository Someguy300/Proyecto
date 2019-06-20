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
        }else if (filaEntrada>0 && filaEntrada<vec.length-1){
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
        
        
        return vec;
    }
    
    
    char puerta = '#';
    int a;
    int b;
    int i;
    int j;
    boolean horizontal=false;
    char [][] aux;
    public char[][] paredesLaberinto (char[][] vec){ //Determina los pasillos del laberinto
        if (vec.length>2){
            //System.out.println(a);
            if (horizontal ==false){
                    b = (int) (Math.random()*(vec.length));
                if (b == 0 || b== vec.length-1){
                    do {                
                        b = (int) (Math.random()*(vec.length));
                    } while (b == 0 || b== vec.length-1);
                }
                //System.out.println(b);
                a = (int) (Math.random()*(vec[b].length));
                if (a == 0 || a== vec[b].length-1){
                    do {                
                        a = (int) (Math.random()*(vec[b].length));
                    } while (a == 0 || a== vec[b].length-1);
                }
                if (vec [0][b]==ent || vec [0][b]==sal){   //Crea la puerta si hay entrada s salida en la parte de arriba
                    vec[1][b] = puerta;
                    for (i = 2; i < vec.length; i++) {
                        vec[i][b]=p;

                    }

                } else if ((vec [(vec[b].length-1)][b]== ent) || (vec [(vec[b].length-1)][b]==sal)){ //Crea la puerta si hay entrada s salida en la parte de abajo
                    vec [vec[b].length-2][b] = puerta;
                    for (i = 1; i < vec[b].length-2; i++) {
                        vec[i][b]=p;
                    }

                } else if (b==1 && hayEntradaOSalidaLateral(vec)){
                    for (i = 0; i < vec[b].length; i++) {
                        vec [i][b] = p;
                        if (vec[i][0]==ent || vec[i][0]==sal){
                            vec[i][b] = puerta;
                        }
                    }

                } else if (b==vec[b].length-2 && hayEntradaOSalidaLateral(vec)){
                    for (i = 0; i < vec[b].length; i++) {
                        vec [i][b] = p;
                        if (vec[i][vec[b].length-1]==ent || vec[i][vec[b].length-1]==sal){
                            vec[i][b] = puerta;
                        }
                    }

                } else {
                    for (i = 0; i < vec[b].length; i++) {
                        vec[i][b] = p;
                    }
                    vec [a][b] = puerta;
                }

            } else if (horizontal ==true){
                a = (int) (Math.random()*(vec.length));
                if (a == 0 || a== vec.length-1){
                    do {                
                        a = (int) (Math.random()*(vec.length));
                    } while (a == 0 || a== vec.length-1);
                }
            //System.out.println(b);
                b = (int) (Math.random()*(vec[a].length));
                if (b == 0 || b== vec[a].length-1){
                    do {                
                        b = (int) (Math.random()*(vec[a].length));
                    } while (b == 0 || b== vec[a].length-1);
                }
                    if (vec [b][0]==ent || vec [b][0]==sal){   //Crea la puerta si hay entrada s salida en la parte de arriba
                    vec[b][1] = puerta;
                    for (i = 2; i < vec.length; i++) {
                        vec[b][i]=p;

                   }

                } else if ((vec [b][(vec[a].length-1)]== ent) || (vec [b][(vec[a].length-1)]==sal)){ //Crea la puerta si hay entrada s salida en la parte de abajo
                    vec [b][vec[a].length-2] = puerta;
                    for (i = 1; i < vec[a].length-2; i++) {
                        vec[b][i]=p;
                    }

                } else if (b==1 && hayEntradaOSalidaLateral(vec)){
                    for (i = 0; i < vec[a].length; i++) {
                        vec [b][i] = p;
                        if (vec[0][i]==ent || vec[0][i]==sal){
                            vec[b][i] = puerta;
                        }
                    }

                } else if (b==vec.length-2 && hayEntradaOSalidaLateral(vec)){
                    for (i = 0; i < vec[a].length; i++) {
                        vec [b][i] = p;
                        if (vec[vec[a].length-1][i]==ent || vec[vec[a].length-1][i]==sal){
                            vec[b][i] = puerta;
                        }
                    }

                } else {
                    for (i = 0; i < vec[a].length; i++) {
                        vec[b][i] = p;
                    }
                    vec [b][a] = puerta;
                }
            }

            if (horizontal==false){
                horizontal = true;
            } else if (horizontal ==true) {
                horizontal = false;
            }
            
//            aux = new char[vec.length-a][vec.length-b];
//            paredesLaberinto(aux);
            
                
        }
        
        
        return vec;
    }
    
    public boolean hayEntradaOSalidaLateral(char[][] vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][0]==ent || vec[i][vec.length-1]==sal){
                    return true;
                } else if (vec[i][0]==sal || vec[i][vec.length-1]==ent){
                    return true;
                }
                
            }
            
        }
        return false;
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
        paredesLaberinto(lab1);
        impresionLab(lab1);
        
    }
    
}
