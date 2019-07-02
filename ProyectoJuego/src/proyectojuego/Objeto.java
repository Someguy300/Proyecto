
package proyectojuego;

/**
 * Clase 
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Objeto {
    private String tipo;
    private double bono;
    protected Objeto  pico;
    protected Objeto  cuerda;
    protected Objeto pocion;
    private int contador=0;
    
    double [] auxPocAditiva = {1,2,5,10,20};
    double [] auxPocMult = {1.10 ,1.20 ,1.25 ,1.5 ,2};
    
    public Objeto (){
        tipo = determinaTipo();
        bono = determinaBono(tipo);
    }
    
   

    
    public void datosPociones(){
        System.out.println("Pocion " + tipo + " Bonificacion " + bono);
    }
    
    
    
    
    public String determinaTipo(){
        int aux = (int) (Math.random()*10);
        if (aux<5){
            return "Aditiva";
        } else {
            return "Multiplicativa";
        }
    }
    
    public double determinaBono(String tipo){
        if (tipo.equals("Aditiva")){
            int aux = (int) (Math.random()*(auxPocAditiva.length-1));
            return auxPocAditiva[aux];
        }else{
            int aux = (int) (Math.random()*(auxPocMult.length-1));
            return auxPocMult[aux];
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

    public Objeto getPocion() {
        return pocion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    



}
