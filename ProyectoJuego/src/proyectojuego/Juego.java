
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
    int monstruosDerrotados=0;
    
    Jugador j = new Jugador(5, 10, bolso);
    
    
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
        
        System.out.println("\nLeyenda: "
                + "\n> Los Monstruos son (Evitalos a toda costa):"
                + "\n\t>> Normal: ß"
                + "\n\t>> Guerrero: α"
                + "\n\t>> Mago: Ω"
                + "\n> Entrada es: E"
                + "\n> Salida es: S");
        
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
                    Jugador ='J';
                    break;
                case 2:
                    Jugador = 'X';
                    break;
                case 3:
                    Jugador ='$';
                    break;
                default:
                    System.out.println("Escogiste una opción erronea, por favor elige de nuevo.");
            }
        } while (selecPersonaje != 1 && selecPersonaje != 2 && selecPersonaje != 3);
        j.bolsoInicial(bolso);
        
        System.out.println("\nPara moverte a traves del Laberinto utilizarás estas teclas:\n"
                + "\t\t(W) para subir"
                + "\n(A) para izquierda              (D) para derecha\n"
                + "\t\t(S) para bajar\n"
                + "(I) Para ver tu inventario\n");
        
        do { //Nuestro recorrido de niveles de Laberintos
            
            System.out.println("Nivel " + (int)nivelLab);
            l.laberintoCompleto(l.tamañoLab((int) nivelLab));
            colocarEnEntrada(l.getLab());
            buscaSalida(l.getLab());
            System.out.println("----------------------");
            l.impresionLab(l.getLab());
            j.imprimirInfo();
            System.out.print("Nivel: " + (int)nivelLab);

            do {
                moverJugador(l.getLab(), linJugador, colJugador);
                System.out.println("\n-------------------------");
                l.impresionLab(l.getLab());
                j.imprimirInfo();
                System.out.print("Nivel: " + (int)nivelLab);
                
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
                + ">> Monstruos derrotados: " + monstruosDerrotados +"\n"
                + ">> Objetos conseguidos: " + j.getObjetosConseguidos() +"\n"
                + ">> Objetos usados: " + j.getObjetosUsados()+"\n");
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
    
    /**
     * Metodo que verifica si el jugador se encuentra en la posición de la salida
     * 
     * @param lab
     * @return si esta en la salida o no
     */
    public boolean verificarSalida(char [][]vec){
        if (vec[linJugador][colJugador]==vec[lineaSalida][columnaSalida]){
            return true;
        } else {
            return false;}
    }
    
    /**
     * Metodo que me permite mover al jugador
     * 
     * @param vec
     * @param lineaJug
     * @param columJug 
     */
    public void moverJugador(char [][]vec, int lineaJug, int columJug){
        System.out.println("\nQue quieres hacer?\n"
                + "(w)Moverte hacia arriba\t(s)Moverte hacia abajo\t(d)Moverte a la derecha\t(a)Moverte a la izquierda"
                + "\n(i)Abrir tu inventario");
        String fuego = sc.next();
        switch(fuego){
            case "w":
                if (vec[lineaJug - 1][columJug] == l.getP()) {
                    System.out.println("Hay una pared a donde te quieres mover");
                    boolean usaPico = verificaPico();
                    if (usaPico==true){
                        System.out.println("Quieres romper la pared?(s/n)");
                        String opcionPico = sc.next();
                        switch (opcionPico){
                            case"s":
                                int posPico = buscaPico();
                                vec[lineaJug-1][columJug]=l.getS();
                                bolso[posPico]=null;
                                break;
                            case"n":
                                System.out.println("No paso nada");
                                break;
                        }
                    }
                    moverJugador(vec, lineaJug, columJug);
                } else if (vec[lineaJug - 1][columJug] == l.getMonstruoGuerrero()
                        || vec[lineaJug - 1][columJug] == l.getMonstruoMago()
                        || vec[lineaJug - 1][columJug] == l.getMonstruoNormal()) {
                    System.out.println("\n-----------------------------"
                            + "\nHay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug-1, columJug);
                    if (pelea==true){
                    vec[lineaJug-1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador - 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        vec[linJugador][colJugador]=l.getS();
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                        vec[linJugador][colJugador]=Jugador;
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
                    System.out.println("Hay una pared a donde te quieres mover");
                    boolean usaPico = verificaPico();
                    if (usaPico==true){
                        System.out.println("Quieres romper la pared?(s/n)");
                        String opcionPico = sc.next();
                        switch (opcionPico){
                            case"s":
                                int posPico = buscaPico();
                                vec[lineaJug + 1][columJug]=l.getS();
                                bolso[posPico]=null;
                                break;
                            case"n":
                                System.out.println("No paso nada");
                                break;
                        }
                    }
                    } else if (vec[lineaJug+1][columJug]==l.getMonstruoGuerrero() 
                        || vec[lineaJug+1][columJug]==l.getMonstruoMago() 
                        || vec[lineaJug+1][columJug]==l.getMonstruoNormal()){
                   System.out.println("\n-----------------------------"
                            + "\nHay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug+1, columJug);
                    if (pelea==true){
                    vec[lineaJug+1][columJug] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    linJugador = linJugador + 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        vec[linJugador][colJugador]=l.getS();
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                        vec[linJugador][colJugador]=Jugador;
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
                    System.out.println("Hay una pared a donde te quieres mover");
                    boolean usaPico = verificaPico();
                    if (usaPico==true){
                        System.out.println("Quieres romper la pared?(s/n)");
                        String opcionPico = sc.next();
                        switch (opcionPico){
                            case"s":
                                int posPico = buscaPico();
                                vec[lineaJug][columJug+1]=l.getS();
                                bolso[posPico]=null;
                                break;
                            case"n":
                                System.out.println("No paso nada");
                                break;
                        }
                    }
                } else if (vec[lineaJug][columJug + 1] == l.getMonstruoGuerrero()
                        || vec[lineaJug][columJug + 1] == l.getMonstruoMago()
                        || vec[lineaJug][columJug + 1] == l.getMonstruoNormal()) {
                    System.out.println("\n-----------------------------"
                            + "\nHay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug, columJug+1);
                    if (pelea==true){
                    vec[lineaJug][columJug + 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador + 1;
                    } else if (pelea==false){
                        j.setVida(j.getVida()-1);
                        vec[linJugador][colJugador]=l.getS();
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                        vec[linJugador][colJugador]=Jugador;
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
                    System.out.println("Hay una pared a donde te quieres mover");
                    boolean usaPico = verificaPico();
                    if (usaPico==true){
                        System.out.println("Quieres romper la pared?(s/n)");
                        String opcionPico = sc.next();
                        switch (opcionPico){
                            case"s":
                                int posPico = buscaPico();
                                vec[lineaJug][columJug-1]=l.getS();
                                bolso[posPico]=null;
                                break;
                            case"n":
                                System.out.println("No paso nada");
                                break;
                        }
                    }
                } else if (vec[lineaJug][columJug - 1] == l.getMonstruoGuerrero()
                        || vec[lineaJug][columJug - 1] == l.getMonstruoMago()
                        || vec[lineaJug][columJug - 1] == l.getMonstruoNormal()) {
                    System.out.println("\n-----------------------------"
                            + "\nHay un monstruo");
                    boolean pelea = Pelea(vec, lineaJug, columJug-1);
                    if (pelea== true){
                    vec[lineaJug][columJug - 1] = Jugador;
                    vec[lineaJug][columJug] = l.getS();
                    colJugador = colJugador - 1;
                    } else if (pelea==false) {
                        j.setVida(j.getVida()-1);
                        vec[linJugador][colJugador]=l.getS();
                        colJugador=l.getColumnaEntrada();
                        linJugador=l.getFilaEntrada();
                        vec[linJugador][colJugador]=Jugador;
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
            case "i":
                j.usarObjeto();
                break;
            default:
                System.out.println("Seleccion erronea");
                moverJugador(vec, lineaJug, columJug);
        }
    }
    
    
    public boolean verificaPico(){
        for (int i = 0; i < bolso.length; i++) {
            if(bolso[i]!=null){
                if (bolso[i].isEsPico()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int buscaPico(){
        for (int i = 0; i < bolso.length; i++) {
            if(bolso[i].isEsPico()){
                return i;
            }
        }
        return 0;
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
        } else if (vec[lineaJug][columJug] == l.getMonstruoGuerrero()) {
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
        } else if (vec[lineaJug][columJug] == l.getMonstruoMago()) {
            double debuff = Math.random();
            if (debuff<= 0.25){
                System.out.println("Te pegaron un hechizo y te mandaron al regreso del laberinto");
                j.setVida(j.getVida()+1);
                j.setFuerza(j.getFuerza()-j.getBonusFuerza());
                j.setBonusFuerza(0);
                return false;
            } else {
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

    
    
     
    
}
    