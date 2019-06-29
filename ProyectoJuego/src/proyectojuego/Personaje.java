
package proyectojuego;

/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Personaje {
    
    protected int vida, fuerza;
    
    /**
     * Constructor del Personaje
     *
     * @param vida
     * @param fuerza
     */
    public Personaje(int vida, int fuerza){
        this.vida= vida;
        this.fuerza=fuerza;
    }
    
    /**
     * Constructor del Personaje
     * 
     * @param fuerza 
     */
    public Personaje(int fuerza){
        this.fuerza=fuerza;
    }
}
