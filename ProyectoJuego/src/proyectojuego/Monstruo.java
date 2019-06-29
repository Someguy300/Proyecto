
package proyectojuego;

/**
 * Clase que desarrolla los Monstruos del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Monstruo extends Personaje{
    
    
    public int limSup(int nivelLab){
        int limSup=nivelLab*nivelLab;
        return limSup;
    }
    
    public int limInf(int nivelLab){
        int limInf=(nivelLab*nivelLab)/2;
        return limInf;
    }
//    int limSup = nivelLab*nivelLab;
//    int limInf= (nivelLab*nivelLab)/2;
    
    private Juego j = new Juego();
    
    /**
     * Constructor del Monstruo
     * 
     * @param fuerza 
     */
    public Monstruo(int fuerza){
        super(fuerza);
        this.fuerza= (int)((limSup(j.getNivelLab())-limInf(j.getNivelLab()))*Math.random());          
        
    }
}
