
package proyectojuego;

import java.util.Scanner;
/**
 * Clase que desarrolla el Jugador (personaje principal) del juego
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Jugador extends Personaje{
    Scanner sc = new Scanner(System.in);
    private Objeto[] bolso = new Objeto[10];
    Pocima pocion;
    Pico pico;
    private double bonusFuerza=0;
    
    /**
     * Constructor del Jugador
     * 
     * @param vida
     * @param fuerza
     * @param bolso 
     */
    public Jugador(double vida, double fuerza, Objeto[] bolso) {
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
                        System.out.println("["+i+"]" +" Soy una pocima aditiva, mi valor es: " + p.getValor());
                    } else {
                        System.out.println("["+i+"]" +" Soy una pocima multiplicativa, mi valor es: " + p.getValor());
                    }
                }
            }
        }
    }
    
    public void usarObjeto(){
        mostrarBolso(bolso);
        System.out.println("Escoge el numero del objeto que quieres usar, o escribe 10 para regresar");
        int seleccion = sc.nextInt();
        if (seleccion<0 || seleccion>10){
            System.out.println("ERROR, escriba un numero del 0 al 9 para usar una pocion o 10 para regresar");
            do {                
                seleccion = sc.nextInt();
            } while (seleccion<0 || seleccion>10);
        }
        if (seleccion>=0 && seleccion<=9){
            if (bolso[seleccion]==null){
                System.out.println("Ahi no tienes nada guardado");
                usarObjeto();
            } else if (bolso[seleccion]!=null){
                Pocima p = ((Pocima) bolso[seleccion]);
                if (bolso[seleccion].isEsPico()){
                    System.out.println("Falta implementar");
                } else {
                    if (p.isEsAditiva()) {
                        System.out.println("Usaste la pocion y tu fuerza aumenta de manera aditiva por +"+p.getValor());
                        bonusFuerza = bonusFuerza+p.getValor();
                        fuerza = fuerza + p.getValor();
                        System.out.println("Tu nuevo stat de fuerza es " + fuerza);
                        bolso[seleccion]=null;
                    } else {
                        System.out.println("Usaste la pocion y tu fuerza aumenta de manera multiplicativa por x"+p.getValor());
                        if (bonusFuerza==0){
                            bonusFuerza = 1*p.getValor();
                        }else {
                            bonusFuerza = bonusFuerza*p.getValor();
                        }
                        fuerza = fuerza * p.getValor();
                        System.out.println("Tu nuevo stat de fuerza es " + fuerza);
                        bolso[seleccion]=null;
                    }
                }
            }
        } else if (seleccion==10){
            System.out.println("No paso nada");
        }
    }
    
    public void guardarObjetoPelea(){
        double random = Math.random();
        if(random<=0.01){
            System.out.println("El monstruo solto una pocima");
            pocion = new Pocima();
            if (pocion.isEsAditiva()){
                System.out.println("Solto una pocion aditiva de +" +pocion.getValor());
            } else {
                System.out.println("Solto una pocion multiplicativa de x" +pocion.getValor());
            }
            if (bolsoLleno()==true){
                System.out.println("Tu bolso esta lleno\n"
                        + "Quieres descartar la pocion(0)"
                        + "O cambiarla por algun otro objeto de tu bolso(1)");
                int seleccion = sc.nextInt();
                if (seleccion<0 || seleccion>1){
                    do {                        
                        System.out.println("Vuelve a elegir, 0 o 1");
                        seleccion = sc.nextInt();
                    } while (seleccion<0 && seleccion>1);
                }
                switch (seleccion){
                    case 0:
                        System.out.println("Descartaste la pocion");
                        break;
                    case 1:
                        System.out.println("Escoge el objeto que vas a descartar");
                        mostrarBolso(bolso);
                        System.out.println("Ingresa el numero del objeto que vas a descartar");
                        int opcionDescarte = sc.nextInt();
                        if (seleccion<0 || seleccion>9){
                            do {                        
                                System.out.println("Vuelve a elegir");
                                seleccion = sc.nextInt();
                            } while (seleccion<0 && seleccion>9);
                        }
                        bolso[opcionDescarte]=pocion;
                        break;
                }
            } else if (bolsoLleno()==false){
                for (int i = 0; i < bolso.length; i++) {
                    if(bolso[i]==null){
                        bolso[i]=pocion;
                        break;
                    }
                    
                }
            }
        } else {
            System.out.println("El monstruo no solto nada");
        }
    }
    
    public void guardarObjetoRoam(){
        double random = Math.random();
        if (random <= 0.8){
            pocion = new Pocima();
            if (pocion.isEsAditiva()){
                System.out.println("Conseguiste una pocion aditiva de +" +pocion.getValor());
            } else {
                System.out.println("Conseguiste una pocion multiplicativa de x" +pocion.getValor());
            }
            
            if (bolsoLleno()==true){
                System.out.println("Tu bolso esta lleno\n"
                        + "Quieres descartar la pocion(0)"
                        + "O cambiarla por algun otro objeto de tu bolso(1)");
                int seleccion = sc.nextInt();
                if (seleccion<0 || seleccion>1){
                    do {                        
                        System.out.println("Vuelve a elegir, 0 o 1");
                        seleccion = sc.nextInt();
                    } while (seleccion<0 && seleccion>1);
                }
                switch (seleccion){
                    case 0:
                        System.out.println("Descartaste la pocion");
                        break;
                    case 1:
                        System.out.println("Escoge el objeto que vas a descartar");
                        mostrarBolso(bolso);
                        System.out.println("Ingresa el numero del objeto que vas a descartar");
                        int opcionDescarte = sc.nextInt();
                        if (seleccion<0 || seleccion>9){
                            do {                        
                                System.out.println("Vuelve a elegir");
                                seleccion = sc.nextInt();
                            } while (seleccion<0 && seleccion>9);
                        }
                        bolso[opcionDescarte]=pocion;
                        break;
                }
            } else if (bolsoLleno()==false){
                for (int i = 0; i < bolso.length; i++) {
                    if(bolso[i]==null){
                        bolso[i]=pocion;
                        break;
                    }
                    
                }
            }
        } else {
            System.out.println("Conseguiste un pico");
            pico = new Pico();
            if (bolsoLleno()==true){
                System.out.println("Tu bolso esta lleno\n"
                        + "Quieres descartar el pico(0)"
                        + "O cambiarla por algun otro objeto de tu bolso(1)");
                int seleccion = sc.nextInt();
                if (seleccion<0 || seleccion>1){
                    do {                        
                        System.out.println("Vuelve a elegir, 0 o 1");
                        seleccion = sc.nextInt();
                    } while (seleccion<0 && seleccion>1);
                }
                switch (seleccion){
                    case 0:
                        System.out.println("Descartaste el pico");
                        break;
                    case 1:
                        System.out.println("Escoge el objeto que vas a descartar");
                        mostrarBolso(bolso);
                        System.out.println("Ingresa el numero del objeto que vas a descartar");
                        int opcionDescarte = sc.nextInt();
                        if (seleccion<0 || seleccion>9){
                            do {                        
                                System.out.println("Vuelve a elegir");
                                seleccion = sc.nextInt();
                            } while (seleccion<0 && seleccion>9);
                        }
                        bolso[opcionDescarte]=pico;
                        break;
                }
            } else if (bolsoLleno()==false){
                for (int i = 0; i < bolso.length; i++) {
                    if(bolso[i]==null){
                        bolso[i]=pico;
                        break;
                    }
                    
                }
            }
        }
    }
    
    public boolean bolsoLleno(){
        for (int i = 0; i < bolso.length; i++) {
            if (bolso[i]==null){
                return false;
            }
        }
        return false;
    }
    

    public Objeto[] getBolso() {
        return bolso;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getBonusFuerza() {
        return bonusFuerza;
    }

    public void setBonusFuerza(double bonusFuerza) {
        this.bonusFuerza = bonusFuerza;
    }
    
    
}
