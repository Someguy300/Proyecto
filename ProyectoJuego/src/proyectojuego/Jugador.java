
package proyectojuego;

/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Jugador extends Personaje{
    
    private Objeto[] bolso = new Objeto[10];
    Pocima pocion;
    
    /**
     * Constructor del Jugador
     * 
     * @param vida
     * @param fuerza
     * @param bolso 
     */
    public Jugador(int vida, int fuerza, Objeto[] bolso) {
        super(vida, fuerza);
        this.vida = vida;
        this.fuerza = fuerza;
        this.bolso=bolso;
    }
    
    public void bolsoInicial(Objeto [] bolso){
        for (int i = 0; i < bolso.length; i++) {
            if (i<3){
            bolso[i]=pocion = new Pocima();
            }
        }
    }
    
    public void mostrarBolso(Objeto[] bolso) {
        System.out.println("Dentro del bolso tienes: ");
        for (int i = 0; i < bolso.length; i++) {
            if (bolso[i] != null) {
                Pocima p = ((Pocima) bolso[i]);
                if (bolso[i].isEsPico()) {
                    System.out.println("Un pico");
                } else {
                    if (p.isEsAditiva()) {
                        System.out.println("Soy una pocima aditiva, mi valor es: " + p.getValor());
                    } else {
                        System.out.println("Soy una pocima multiplicativa, mi valor es: " + p.getValor());
                    }
                }
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
