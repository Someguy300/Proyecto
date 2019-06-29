
package proyectojuego;

/**
 * Clase 
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Objeto {
    
    private int[] pocAditiva= {1, 2, 5, 10, 20};
    private double[] pocMultiplicativa = {1.10, 1.20, 1.25, 1.5, 2};
    
    private Objeto[] bolso = new Objeto[10];

    
    
    
    
    public double generarPocima(){
        int tipo = (int) (Math.random()*10); 
        
        int aleatorio = (int)(Math.random()*4);
        
        if(tipo<5){
            return pocAditiva[aleatorio];
        } else {
            return pocMultiplicativa[aleatorio];
        }
    }
    
    
    
    
//    public Objeto[] bolsoInicial(Objeto[] bolso){
//        for (int i = 0; i < 3; i++) {
//            bolso[i]=generarPocima();
//        }
//        return bolso;
//    }
    
    
    
    
    
    
    
//    private pico;
//    private cuerda; //Este objeto es bonus: debe mostrar salida del laberinto

//    public int getPocAditiva() {
//        return pocAditiva[(int) (Math.random() * 4)];
//    }
//
//    public double getPocMultiplicativa() {
//        return pocMultiplicativa[(int) (Math.random() * 4)];
//    }




}
