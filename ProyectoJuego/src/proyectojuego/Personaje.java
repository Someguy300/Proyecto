
package proyectojuego;

/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Personaje {
    
    protected double vida, fuerza;
    
    /**
     * Constructor del Personaje
     *
     * @param vida
     * @param fuerza
     */
    public Personaje(double vida, double fuerza){
        this.vida= vida;
        this.fuerza=fuerza;
    }
    
    /**
     * Constructor del Personaje
     * 
     * @param fuerza 
     */
    public Personaje(double fuerza){
        this.fuerza=fuerza;
    }
}
