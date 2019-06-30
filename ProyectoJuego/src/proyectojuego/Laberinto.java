
package proyectojuego;

/**
 * Clase donde se desarrolla el Laberinto
 *
 * @author Jesus Barrios
 * @author Ricardo Serrano
 * @version
 */
public class Laberinto {
    private char p = '▓';
    private char s ='░';
    private char nada = '▒';
    private char ent = 'E';
    private char sal = 'S';
    private int tamaño;
    private char[][] lab;
    private int filaEntrada;
    private int columnaEntrada;
    private int filaSalida;
    private int columnaSalida;

    /**
     * Este método es para determinar el tamaño del Laberinto
     *
     * @param nivelLab
     * @return lab[tamaño][tamaño]
     */
    public char[][] tamañoLab(int nivelLab) {
        if (nivelLab > 0 && nivelLab < 11) {
            lab = new char[10][10];
            tamaño = lab.length;
            return lab;
        } else if (nivelLab > 10 && nivelLab < 21) {
            lab = new char[20][20];
            tamaño = lab.length;
            return lab;
        } else if (nivelLab > 20 && nivelLab < 31) {
            lab = new char[30][30];
            tamaño = lab.length;
            return lab;
        } else {
            lab = new char[30][30];
            tamaño = lab.length;
            return lab;
        }
    }

    /**
     * Este método establece las paredes del Laberinto
     *
     * @param vec
     */
    public void setupParedesLaberinto(char[][] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                if ((i == 0 || i == (vec.length - 1)) || (j == 0 || j == (lab[i].length - 1))) { //Determina paredes exteriores
                    vec[i][j] = p;
                } else {
                    vec[i][j] = '░';   //Placeholder del interior
                }
            }
        }
    }

    /**
     * Este metodo establece la entrada y salida del Laberinto
     *
     * @param vec
     */
    public void entradaYSalida(char[][] vec) {
        filaEntrada = (int) ((Math.random() * vec.length)); //Determina la posicion de la Entrada
        if (filaEntrada == 0 || filaEntrada == (vec.length - 1)) {
            columnaEntrada = (int) (1 + (Math.random() * (vec.length - 2)));
        } else if (filaEntrada > 0 && filaEntrada < 9) {
            columnaEntrada = (int) (Math.random() * vec.length);
            if (columnaEntrada >= vec.length / 2) {
                columnaEntrada = vec.length - 1;
            } else {
                columnaEntrada = 0;
            }
        }
        filaSalida = (int) ((Math.random() * vec.length)); //Determina la posicion de la salida
        if (filaSalida == 0 || filaSalida == (vec.length - 1)) {
            columnaSalida = 1 + (int) (Math.random() * (vec.length - 2));
        } else if (filaSalida > 0 && filaSalida < 9) {
            columnaSalida = (int) (Math.random() * vec.length);
            if (columnaSalida >= vec.length / 2) {
                columnaSalida = vec.length - 1;
            } else {
                columnaSalida = 0;
            }
        }
        vec[filaEntrada][columnaEntrada] = ent;
        vec[filaSalida][columnaSalida] = sal;
        if (vec[filaEntrada][columnaEntrada] == vec[filaSalida][columnaSalida]) {
            vec[filaSalida + 1][columnaSalida] = sal;
        }
    }

    /**
     * Este metodo imprimirá el Laberinto
     * 
     * @param vec
     */
    public void impresionLab(char[][] vec) {
        for (int i = 0; i < vec.length; i++) { //Impresion del laberinto
            System.out.print("|");
            for (int j = 0; j < vec[i].length; j++) {
                System.out.print(vec[i][j]);
                if (j != vec[i].length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
    }
    //HASTA AQUI ESTA FINO

  
    /**
     * Este método imprimira el Laberinto Completo
     */
//    public void laberintoCompleto() {
//        tamañoLab(nivelLab);
//        setupParedesLaberinto(lab);
//        entradaYSalida(lab);
//        dividirLab(lab, i, j);
//        impresionLab(lab);
//    }

    
    
    
    public boolean esImpar(int n) {
    if (n%2==0) return false;
    else return true;
    }
    
    
    
    
    public int largoParedesV(char [][]vec){
        for (int i = 1; i < vec.length; i++) {
            for (int j = 1; j < vec.length; j++) {
                if (vec[i][j]==s){
                    for (int k = 1; k < vec.length; k++) {
                        if (vec[k][j]==p){
                            return k-1;
                        } 
                        
                    }
                }
                
            }
            
        }
        return 0;
    }
    
    public int largoParedesH(char[][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==s){
                    for (int k = 1; k < vec.length; k++) {
                        if (vec[j][k]==p){
                            return k-1;
                        }
                        
                    }
                }
                
            }  
        }
        return 0;
    }
    
    public boolean verificaEntradaySalidaH (char [][]vec, int n){
        if (vec[0][n] == ent || vec[0][n] == sal || vec[(vec.length-1)][n] == ent || vec[(vec.length-1)][n] == sal){
            return true;
        } else{
            return false;
        } 
    }
    
    public boolean verificaEntradaySalidaV (char [][]vec, int n){
        for (int k = 0; k < vec.length-1; k++) {
            if (vec[k][n-1]== ent || vec[k][n-1]== sal){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaParedesVert(char [][]vec, int n){
        for (int k = 1; k < vec.length-1; k++) {
            if (vec[k][n-1]== p){
                return true;
            } else if (vec[k][n+1]==p){
                return true;
            }
        }
        return false;
    }
    
    
    int ultColu;
    int ultFila;
    int aux1;
    int aux2;
    public void Laberinto(char [][]vec, int primCol, int ultCol, int primFil, int ultFil, int cont){
        if (ultFila>3 && ultColu>3){
            if (esImpar(cont)){
                ultColu =ponerParedVer(vec, primCol, ultColu, primFil, ultFila);
                aux1 = ultColu;
            } else {
                ultFila = ponerParedHor(vec, primCol, ultColu, primFil, ultFila);
                aux2 = ultFila;
            }
            Laberinto(vec, primCol, ultColu-1, primFil, ultFila-1, cont+1);
            Laberinto(vec, aux1+2, ultCol, aux2+1, ultFil, cont+1);
        }
        
        
    }
    
   
    
    public int ponerParedVer(char [][] vec, int primCol, int ultCol, int primFil, int ultFil){
        int aux = ultCol;
        ultCol = 1+ primCol +(int) ((Math.random() * (ultCol-1)));
            for (int k = primFil; k <= ultFil; k++) {
                if (vec[k][ultCol-1]==p || vec[k][ultCol+1]==p){            
                    ultCol = primCol+(int) ((Math.random() * (aux-1)));
                }  
            }
        for (int k = primFil; k <= ultFil; k++) {
            vec[k][ultCol]=p;
        }
        
        return ultCol; 
    }
    
    public int ponerParedHor(char [][] vec, int primCol, int ultCol, int primFil, int ultFil){
        int aux = ultFil;
        ultFil =  1 + primCol+ (int) ((Math.random() * (ultFil-1)));
            for (int k = primCol; k <= ultCol; k++) {
                if (vec[ultFil-1][k]==p || vec[ultFil+1][k]==p){            
                    ultFil = primFil+(int) ((Math.random() * (aux)));
                }  
            }
        
        for (int k = primCol; k <= ultCol; k++) {
            vec[ultFil][k]=p;
        }
        return ultFil;
    }
    
    public void laberintoCompleto(char[][] tamaño){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        setupParedesLaberinto(lab);
        entradaYSalida(lab);
        ultColu = lab.length-2;
        ultFila = lab.length-2;
        Laberinto(lab, 1, lab.length-2, 1, lab.length-2, 1);
        impresionLab(lab);
        
    }
}
