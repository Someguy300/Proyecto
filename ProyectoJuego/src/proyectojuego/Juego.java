
package proyectojuego;

import java.util.Scanner;

/**
 * Clase que permitira el control de todo el juego
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version 
 */
public class Juego {
  
    private int nivelLab=0;
    private int linJugador;
    private int colJugador;
    private char Jugador;
    private char Monstruo;
    Laberinto l = new Laberinto();
    Scanner sc = new Scanner(System.in);
    boolean continuar=false;

    
    
    /**
     * Metodo que inicia el juego
     *
     * @version
     */
    public void iniciar(){
//        Objeto o = new Objeto();
        
        
        System.out.println("---------¡¡¡ BIENVENIDO AL LABERINTO SIN ESCAPE !!!!---------");
        
        
//        Jugador j = new Jugador(5, 10, bolso);
        
        
        System.out.println("\nVeamos si eres capaz de sobrevivir a los laberintos llenos de sorpresas\n");
        int opcion;
        do {
            System.out.println("\nEscoge tu jugador:"
                    + "\n(1) para --> J"
                    + "\n(2) para --> X"
                    + "\n(3) para --> $");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    setJugador('J');
                    break;
                case 2:
                    setJugador('X');
                    break;
                case 3:
                    setJugador('$');
                    break;
                default:
                    System.out.println("Escogiste una opción erronea, por favor elige de nuevo.");
            }
        } while (opcion != 1 && opcion != 2 && opcion != 3);
        
        System.out.println("\nPara moverte a traves del Laberinto utilizarás estas teclas:"
                + "\n(W) para subir"
                + "\n(A) para izquierda"
                + "\n(S) para bajar"
                + "\n(D) para derecha\n");
        
        
        do{ //Nuestro recorrido de niveles de Laberintos
            nivelLab++;
            System.out.println("Nivel " + nivelLab);
            l.laberintoCompleto(l.tamañoLab(nivelLab));
            colocaEntrada(l.getLab());
            System.out.println("----------------------");
            l.impresionLab(l.getLab());
            
            do {                
                moverJugador(l.getLab(), linJugador, colJugador);
                l.impresionLab(l.getLab());
            } while (continuar==true);

                

        } while(continuar==true);
        
        
    }
    
    public void moverJugador(char [][]vec, int lineaJug, int columJug){
        String fuego = sc.next();
        switch(fuego){
            case "w":
                if (vec[lineaJug-1][columJug]==l.getP()){
                    System.out.println("hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else {
                if (verificaSalida(vec, lineaJug-1, columJug)==true){
                    continuar = false;
                } else {
                vec[lineaJug-1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador-1;
                }
                }
                break;
                
            case "s":
                if (vec[lineaJug+1][columJug]==l.getP()){
                    System.out.println("hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else{
                if (verificaSalida(vec, lineaJug+1, columJug)==true) {
                    continuar = false;
                } else {
                vec[lineaJug-1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador-1;
                }
                vec[lineaJug+1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador+1;
                }
                break;
                
            case "d":
                if (vec[lineaJug][columJug+1]==l.getP()){
                    System.out.println("hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else{
                if (verificaSalida(vec, lineaJug, (columJug+1))==true){
                    continuar = false;
                } else {
                vec[lineaJug-1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador-1;
                }
                vec[lineaJug][columJug+1]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                colJugador = colJugador+1;
                }
                break;
                
            case "a":
                if (vec[lineaJug][columJug-1]==l.getP()){
                    System.out.println("hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else{
                if (verificaSalida(vec, lineaJug, columJug-1)==true) {
                    continuar = false;
                } else {
                vec[lineaJug-1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador-1;
                }
                vec[lineaJug][columJug-1]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                colJugador = colJugador-1;
                }
                break;
        }
    }
    
    
    
    public void colocaEntrada(char [][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==l.getEnt()){
                    setLinJugador(i);
                    setColJugador(j);
                    vec[i][j]= Jugador;
                    break;
                }  
            }
        }
        
    }
    
    public boolean verificaSalida(char [][]vec, int linJug, int colJug){
        if (vec[linJug][colJug]==l.getS()){
            return true;
        }
        else return false;
    }
    
    
    
    public boolean isContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }
    

    public int getLinJugador() {
        return linJugador;
    }

    public void setLinJugador(int linJugador) {
        this.linJugador = linJugador;
    }

    public int getColJugador() {
        return colJugador;
    }

    public void setColJugador(int colJugador) {
        this.colJugador = colJugador;
    }
    
    public int getNivelLab() {
        return nivelLab;
    }

    public char getJugador() {
        return Jugador;
    }

    public void setJugador(char Jugador) {
        this.Jugador = Jugador;
    }

    public char getMonstruo() {
        return Monstruo;
    }

    public void setMonstruo(char Monstruo) {
        this.Monstruo = Monstruo;
    }
    
    
    
    

    
    
}
