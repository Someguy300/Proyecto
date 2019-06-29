
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
    /**
     * Metodo que inicia el juego
     *
     * @version
     */
    public void iniciar(){
//        Objeto o = new Objeto();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("---------¡¡¡ BIENVENIDO AL LABERINTO SIN ESCAPE !!!!---------");
        
        Laberinto l = new Laberinto();
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

                    break;
                case 2:

                    break;
                case 3:

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
        
        boolean continuar;
        do{ //Nuestro recorrido de niveles de Laberintos
            nivelLab++;
            System.out.println("Nivel " + nivelLab);
            l.laberintoCompleto(l.tamañoLab(nivelLab));
//            if(posJugador llega a pos de la salida){
//                continuar=false;
//            }
                continuar=false;
            

        } while(continuar);
        
        
    }

    public int getNivelLab() {
        return nivelLab;
    }
    
    

    
    
}
