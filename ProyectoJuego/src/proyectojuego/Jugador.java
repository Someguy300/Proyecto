package proyectojuego;

/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Jugador extends Personaje{
    
    Objeto pocion;
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
    Objeto obj = new Objeto();
    
    public void bolsoInicial(Objeto [] bolso){
        for (int i = 0; i < bolso.length; i++) {
            if (i>2){
            bolso[i]=pocion = new Objeto();
            }
            
        }
    }
    
    public void mostrarBolso(Objeto [] bolso){
        for (int i = 0; i < bolso.length; i++) {
            if (bolso[i]==obj.getPocion()){
                obj.datosPociones();
            }
            
        }
    }
    

    public Objeto[] getBolso() {
        return bolso;
    }

  

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
    
    
    
}
