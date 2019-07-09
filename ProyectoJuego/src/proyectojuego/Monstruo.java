
package proyectojuego;

/**
 * Clase que desarrolla los Monstruos del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Monstruo extends Personaje{
    
    
    
//    int limSup = nivelLab*nivelLab;
//    int limInf= (nivelLab*nivelLab)/2;
    
   
    
    /**
     * Constructor del Monstruo
     * 
     * @param fuerza 
     */
    public Monstruo(double fuerza){
        super(fuerza);
        this.fuerza= fuerza;          
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }
    
    
    
}
