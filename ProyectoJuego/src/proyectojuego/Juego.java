
package proyectojuego;

import java.util.Scanner;

/**
 * Clase que permitira el control de todo el juego
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version 
 */
public class Juego {
  
    private double nivelLab=1;
    private long tiempo;
    private int linJugador;
    private int colJugador;
    private int lineaSalida;
    private int columnaSalida;
    private char Jugador;
    private char Monstruo;
    private Objeto[] bolso = new Objeto[10];
    Laberinto l = new Laberinto();
    Scanner sc = new Scanner(System.in);
    boolean continuar;
//    Monstruo m = new Monstruo(nivelLab);
    private Jugador j = new Jugador(5, 10, bolso);
    
    
    /**
     * Metodo que inicia el juego
     *
     * @version
     */
    public void iniciar(){
        int segundosI = (int) System.currentTimeMillis();
        
        System.out.println("--------------¡¡¡ BIENVENIDO AL LABERINTO SIN ESCAPE !!!!--------------");
        
        
        System.out.println("\nTe encuentras inmerso en un laberinto lleno de ¡MONSTRUOS! en el cual deberás adentrarte,\n"
                + " utilizar tu destreza y correr con suerte para lograr avanzar en esta aventura.");
        
        System.out.println("\nTienes como objetivo recorrer todo el camino y vencer a los monstruos que se te puedan aparecer\n"
                + "ya que cuentas con una fuerza inicial, pero si es el caso que te gane un monstruo perderás una\n"
                + "vida y unas otras cosas mas (Cuidado!).\n"
                + "Los dioses te han otorgado un bolso Totto que puede guardar 10 objetos, ni mas ni menos,\n"
                + "tambien te han dado esteriodes para que tengas 10 de fuerza y 5 setas de Ma*** de 1up");
        
        
        System.out.println("\n¡¡ Veamos cuánto tiempo eres capáz de sobrevivir !!\n");
        int selecPersonaje;
        do {
            System.out.println("\nEscoge tu jugador:"
                    + "\n(1) para --> J"
                    + "\n(2) para --> X"
                    + "\n(3) para --> $");
            selecPersonaje = sc.nextInt();
            switch (selecPersonaje) {
                case 1:
                    setJugador('J');
                    break;
                case 2:
                    setJugador('X');
                    break;
                case 3:
                    setJugador('$');
                    break;
                default:
                    System.out.println("Escogiste una opción erronea, por favor elige de nuevo.");
            }
        } while (selecPersonaje != 1 && selecPersonaje != 2 && selecPersonaje != 3);
        
        System.out.println("\nPara moverte a traves del Laberinto utilizarás estas teclas:\n"
                + "\t\t(W) para subir"
                + "\n(A) para izquierda              (D) para derecha\n"
                + "\t\t(S) para bajar\n"
                + "(I) Para ver tu inventario");

        do { //Nuestro recorrido de niveles de Laberintos
            
            
            System.out.println("Nivel " + (int)nivelLab);
            l.laberintoCompleto(l.tamañoLab((int) nivelLab));
            j.bolsoInicial(bolso);

            colocarEnEntrada(l.getLab());
            buscaSalida(l.getLab());
            System.out.println("----------------------");
            l.impresionLab(l.getLab());

            do {
                System.out.println("----------------------");
                System.out.println("Que deseas hacer?"
                        + "\nMoverte(0)"
                        + "\nVer tu bolsito Totto (1)");
                int seleccion = sc.nextInt();
                if (seleccion<0 || seleccion>1){
                    do {  
                        System.out.println("0 o 1, vuelve a intentar");
                        seleccion = sc.nextInt();
                    } while (seleccion<0 || seleccion>1);
                }
                switch (seleccion){
                    case 0:
                        moverJugador(l.getLab(), linJugador, colJugador);
                        break;
                    case 1:
                        j.usarObjeto();
                }
               
                System.out.println("-------------------------");
                l.impresionLab(l.getLab());
                
            } while (verificarSalida(l.getLab()) == false && j.getVida()>0);

            if (j.getVida()>0){
                nivelLab= nivelLab+1;
                continuar=true;
            } else {
                continuar=false;
            }
        } while (continuar);

        System.out.println("\nEL JUEGO HA TERMINADO\n");
        
        
        
        int segundosF = (int) System.currentTimeMillis();
        tiempo = (int) ((segundosF - segundosI)/1000.0d);
        System.out.println("Las Estadisticas del juego son : \n"
                + ">> Numeros de laberintos completados: " + nivelLab + "\n"
                + ">> Tiempo jugado: " + tiempo + " s\n"
                + ">> Tiempo promedio en cada laberinto: " + tiempo/nivelLab+ "\n"
                + ">> Monstruos derrotados: " + "\n"
                + ">> Objetos conseguidos: " + "\n"
                + ">> Objetos usados: " + "\n");
    }
    
    /**
     * Método que coloca al jugador en la entrada
     * 
     * @param vec 
     */
    public void colocarEnEntrada(char [][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==l.getEnt()){
                    setLinJugador(i);
                    setColJugador(j);
                    vec[i][j]= Jugador;
                    break;
                }
            }
        }
    }
    
    
    public boolean verificarSalida(char [][]vec){
        if (vec[linJugador][colJugador]==vec[lineaSalida][columnaSalida]){
            return true;
        } else {
            return false;}
    }
    
    public void moverJugador(char [][]vec, int lineaJug, int columJug){
        System.out.println("En que direccion quieres moverte?\n"
                + "(w)para subir\t(s)para bajar\t(d)para ir a la derecha\t(a)para ir a la izquierda");
        String fuego = sc.next();
        switch(fuego){
            case "w":
                if (vec[lineaJug - 1][columJug] == l.getP()) {
                    System.out.println("Hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else if (vec[lineaJug - 1][columJug] == l.getMonstruoGuerrero()
                        || vec[lineaJug - 1][columJug] == l.getMonstruoMago()
                        || vec[lineaJug - 1][columJug] == l.getMonstruoNormal()) {
                    System.out.println("-----------------------------\n"
                            + "Hay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug-1, columJug);
                    if (pelea==true){
                    vec[lineaJug-1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador - 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                    }
                } else if(vec[lineaJug - 1][columJug] == l.getObjeto()){
                    j.guardarObjetoRoam();
                    vec[lineaJug - 1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador - 1;
                } else {
                    vec[lineaJug - 1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador - 1;
                }
                break;
                
            case "s":
                if (vec[lineaJug+1][columJug]==l.getP()){
                    System.out.println("Hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                    } else if (vec[lineaJug+1][columJug]==l.getMonstruoGuerrero() 
                        || vec[lineaJug+1][columJug]==l.getMonstruoMago() 
                        || vec[lineaJug+1][columJug]==l.getMonstruoNormal()){
                    System.out.println("Hay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug+1, columJug);
                    if (pelea==true){
                    vec[lineaJug+1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador + 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                    }
                } else if(vec[lineaJug + 1][columJug] == l.getObjeto()){
                    j.guardarObjetoRoam();
                    vec[lineaJug + 1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador + 1;
                }else{
                vec[lineaJug+1][columJug]=Jugador;
                vec[lineaJug][columJug]=l.getS();
                linJugador = linJugador+1;
                }
                break;
                
            case "d":
                if (vec[lineaJug][columJug + 1] == l.getP()) {
                    System.out.println("Hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else if (vec[lineaJug][columJug + 1] == l.getMonstruoGuerrero()
                        || vec[lineaJug][columJug + 1] == l.getMonstruoMago()
                        || vec[lineaJug][columJug + 1] == l.getMonstruoNormal()) {
                    System.out.println("Hay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug, columJug+1);
                    if (pelea==true){
                    vec[lineaJug][columJug + 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador + 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                    }
                } else if(vec[lineaJug][columJug+1] == l.getObjeto()){
                    j.guardarObjetoRoam();
                    vec[lineaJug][columJug+1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador + 1;
                } else {
                    vec[lineaJug][columJug + 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador + 1;
                }
                break;
                
            case "a":
                if (vec[lineaJug][columJug - 1] == l.getP()) {
                    System.out.println("Hay una pared a donde te quieres mover, intenta de nuevo");
                    moverJugador(vec, lineaJug, columJug);
                } else if (vec[lineaJug][columJug - 1] == l.getMonstruoGuerrero()
                        || vec[lineaJug][columJug - 1] == l.getMonstruoMago()
                        || vec[lineaJug][columJug - 1] == l.getMonstruoNormal()) {
                    System.out.println("Hay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug, columJug-1);
                    if (pelea== true){
                    vec[lineaJug][columJug - 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador - 1;
                    } else if (pelea==false) {
                        j.setVida(j.getVida()-1);
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                    }
                } else if(vec[lineaJug][columJug-1] == l.getObjeto()){
                    j.guardarObjetoRoam();
                    vec[lineaJug][columJug-1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador - 1;
                } else {
                    vec[lineaJug][columJug - 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador - 1;
                }
                break;
        }
    }
    
    /**
     * Método que me da la posición de la salida
     * 
     * @param vec 
     */
    public void buscaSalida(char [][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==l.getSal()){
                    lineaSalida = i;
                    columnaSalida = j;
                    break;
                }  
            }
        }
    }
    
    public boolean Pelea(char[][] vec, int lineaJug, int columJug) {
        Monstruo mon = new Monstruo(determinaFuerza(limInf(), limSup()));
        if (vec[lineaJug][columJug] == l.getMonstruoNormal()) {
            System.out.println("Fuerza del monstruo: "+mon.getFuerza());
            System.out.println("Tu fuerza: "+j.getFuerza());
            if (j.getFuerza() > mon.getFuerza()) {
                j.setFuerza(j.getFuerza() + 1);
                System.out.println("Ganaste la pelea");
                j.guardarObjetoPelea();
                System.out.println("Nueva fuerza " + j.getFuerza());
                return true;
            } else {
                int chance = 1+(int) (Math.random()*9);
                if (chance <=2){
                    System.out.println("Ganaste la pelea");
                    j.guardarObjetoPelea();
                    j.setFuerza(j.getFuerza() + 2);
                    return true;
                } else {
                    j.setVida(j.getVida()-1);
                    System.out.println("Perdiste la pelea\n"
                            + "Te vas a la entrada de este nivel");
                    return false;
                }
                
            }
        }    
        if (vec[lineaJug][columJug] == l.getMonstruoGuerrero()) {
                mon.setFuerza(mon.getFuerza() + (mon.getFuerza() / 2));
                System.out.println("Fuerza del monstruo: "+mon.getFuerza());
                System.out.println("Tu fuerza: "+j.getFuerza());
                if (j.getFuerza() > mon.getFuerza()) {
                j.setFuerza(j.getFuerza() + 1);
                System.out.println("Ganaste la pelea");
                j.guardarObjetoPelea();
                System.out.println("Nueva fuerza " + j.getFuerza());
                return true;
            } else {
                int chance = 1+(int) (Math.random()*9);
                if (chance <=2){
                    System.out.println("Ganaste la pelea");
                    j.guardarObjetoPelea();
                    j.setFuerza(j.getFuerza() + 2);
                    System.out.println("Nueva fuerza " + j.getFuerza());
                    return true;
                } else {
                    j.setVida(j.getVida()-1);
                    System.out.println("Perdiste la pelea\n"
                            + "Te vas a la entrada de este nivel");
                    return false;
                }
                
            }
        }
        if (vec[linJugador][colJugador] == l.getMonstruoMago()) {
            double debuff = Math.random();
            if (debuff<= 0.25){
                System.out.println("Te pegaron un hechizo y te mandaron al regreso del laberinto");
                j.setVida(j.getVida()+1);
                return false;
            }
            System.out.println("Fuerza del monstruo: "+mon.getFuerza());
            System.out.println("Tu fuerza: "+j.getFuerza());
            if (j.getFuerza() > mon.getFuerza()) {
                j.setFuerza(j.getFuerza() + 1);
                System.out.println("Ganaste la pelea");
                j.guardarObjetoPelea();
                System.out.println("Nueva fuerza " + j.getFuerza());
                return true;
            } else {
                int chance = 1+(int) (Math.random()*9);
                if (chance <=2){
                    System.out.println("Ganaste la pelea");
                    j.guardarObjetoPelea();
                    j.setFuerza(j.getFuerza() + 2);
                    System.out.println("Nueva fuerza " + j.getFuerza());
                    return true;
                } else {
                    j.setVida(j.getVida()-1);
                    System.out.println("Perdiste la pelea\n"
                            + "Te vas a la entrada de este nivel");
                    return false;
                }
                
            }
        }
        return true;
    }
    
    public double limSup(){
        return nivelLab*nivelLab;
    }
    
    public double limInf(){
        return (nivelLab*nivelLab)/2;
    }
    
    public double determinaFuerza(double limInf, double limSup){
        return limInf + (Math.random()*(limSup-limInf));
    }
    
    
    
    
    
public int getLinJugador() {
        return linJugador;
    }

    public void setLinJugador(int linJugador) {
        this.linJugador = linJugador;
    }

    public int getColJugador() {
        return colJugador;
    }

    public void setColJugador(int colJugador) {
        this.colJugador = colJugador;
    }
    
    public double getNivelLab() {
        return nivelLab;
    }

    public char getJugador() {
        return Jugador;
    }

    public void setJugador(char Jugador) {
        this.Jugador = Jugador;
    }
    
}
    