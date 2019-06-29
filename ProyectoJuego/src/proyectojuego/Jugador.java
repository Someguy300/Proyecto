package proyectojuego;

/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Jugador extends Personaje{
    
    
    /**
     * Constructor del Jugador
     * 
     * @param vida
     * @param fuerza
     * @param bolso 
     */
    public Jugador(int vida, int fuerza, Objeto[] bolso) {
        super(vida, fuerza);
        this.vida = 5;
        this.fuerza = 10;
        this.bolso=bolso;
    }
    
    private Objeto[] bolso = new Objeto[10];
    
    public Objeto[] bolsoInicial(Objeto[] bolso, int i){
        if (bolso[i] == null){
        bolso[1] = new Objeto();
        } else {
            
        }
//        for (int i = 0; i < 3; i++) {
//            
//            bolso[i]= ;
//        }
    }
//    
}
