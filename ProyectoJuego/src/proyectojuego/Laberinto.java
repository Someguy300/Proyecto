
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
    
    private char monstruoNormal = 'ß';
    private char monstruoMago = 'Ω';
    private char monstruoGuerrero = 'α';
    
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
            filaEntrada = vec.length-1;
            columnaEntrada = vec.length-2;
            vec[filaEntrada][columnaEntrada] = ent;
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
                ponerhuecoVer(vec, ultColu, primFil, ultFila);
            } else {
                ultFila = ponerParedHor(vec, primCol, ultColu, primFil, ultFila);
                ponerhuecoHor(vec, ultFila, primCol, ultColu);
            }
            Laberinto(vec, primCol, ultColu-1, primFil, ultFila-1, cont+1);
            Laberinto(vec, ultColu+1, ultCol, ultFila+1, ultFil, cont+1);
        }
        
        
    }
    
   
    
    public int ponerParedVer(char [][] vec, int primCol, int ultCol, int primFil, int ultFil){
        int aux = ultCol;
        ultCol = 1+primCol +(int) ((Math.random() * (ultCol-2)));
            boolean algoLados=false;
            for (int k = 0; k < vec.length-1; k++) {
                if (vec[k][ultCol-1]== ent || vec[k][ultCol-1]== sal 
                        || vec[k][ultCol+1]== ent || vec[k][ultCol+1]== sal
                        || vec[k][ultCol-1]== p || vec[k][ultCol+1]== p
                        || vec[k][ultCol-1]== nada || vec[k][ultCol+1]== nada
                        || vec[0][ultCol]== ent || vec[vec.length-1][ultCol]== sal
                        || vec[0][ultCol]== p || vec[vec.length-1][ultCol]== p
                        || vec[0][ultCol]== nada || vec[vec.length-1][ultCol]== nada){
                    algoLados=true;
                }
            }
        if (algoLados==true);{
        int cont = 0;
            do {            
            ultCol = primCol +(int) ((Math.random() * (aux-1)));
            cont = cont+1;
        } while (cont<4);
        }
        
        
        for (int k = primFil; k < ultFil+1; k++) {
            vec[k][ultCol]=p;
        }
        
        return ultCol; 
    }
    
    
    public void ponerhuecoVer (char[][]vec, int ultCol, int primFil, int ultFil){
        int n = 1+(int) (Math.random() * ((ultFil-primFil)-1));
        vec[n][ultCol] = s;
        
    }
    
    public int ponerParedHor(char [][] vec, int primCol, int ultCol, int primFil, int ultFil){
        int aux = ultFil;
        ultFil =  1 + primFil + (int) ((Math.random() * (ultFil-2)));
        boolean algoLados=false;
            for (int k = 0; k < vec.length-1; k++) {
                if (vec[ultFil-1][k]== ent || vec[ultFil+1][k]== sal 
                        || vec[ultFil+1][k]== ent || vec[ultFil-1][k]== sal
                        || vec[ultFil-1][k]== p || vec[ultFil+1][k]== p
                        || vec[ultFil][0]== p 
                        || vec[ultFil][0]== ent || vec[ultFil][0]== sal
                        || vec[ultFil][0]== p || vec[ultFil][0]== p){
                    algoLados=true;
                }
            }
        if (algoLados==true){
            ultFil =  1 + primFil + (int) ((Math.random() * (ultFil-2)));
            
        } 
        
        for (int k = primCol; k < ultCol; k++) {
            vec[ultFil][k]=p;
        }
        return ultFil;
        
    }
    
    public void ponerhuecoHor (char[][]vec, int ultFil, int primCol, int ultCol){
        int n = 1+(int) (Math.random() * ((ultCol-primCol)-2));
        vec[ultFil][n] = s;   
    }
    
    
    public void colocarMonstruoNormal(char [][] vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if (vec[i][j]==s){
                    double random = Math.random();
                    if (random<=0.075){
                        vec[i][j]= monstruoNormal;
                    }
                } 
            } 
        }
    }
    
    public void colocarMonstruoMago(char [][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if ((vec[i][j]==s && vec[i-1][j]==s && vec[i][j+1]==s && vec[i+1][j]==p && vec[i][j-1]==p)
                        || (vec[i][j]==s && vec[i-1][j]==s && vec[i][j+1]==p && vec[i+1][j]==p && vec[i][j-1]==s)
                        || (vec[i][j]==s && vec[i-1][j]==p && vec[i][j+1]==s && vec[i+1][j]==s && vec[i][j-1]==p)
                        || (vec[i][j]==s && vec[i-1][j]==p && vec[i][j+1]==p && vec[i+1][j]==s && vec[i][j-1]==s)){
                    double random = Math.random();
                    if (random<=0.05){
                        vec[i][j]= monstruoMago;
                    }
                } 
            } 
        }
    }
    
    public void colocarMonstruoGuerrero(char [][]vec){
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if ((vec[i][j]==s && vec[i-1][j]==s && vec[i][j+1]==s && vec[i+1][j]==s && vec[i][j-1]==s
                        && vec[i-1][j-1]==p && vec[i-1][j+1]==p && vec[i+1][j+1]==p && vec[i+1][j-1]==p)){
                    double random = Math.random();
                    if (random<=0.5){
                        vec[i][j]= monstruoGuerrero;
                    }
                } else if ((vec[i][j]==s && vec[i-1][j]==s && vec[i+1][j]==s && vec[i][j-1]==s && vec[i][j-1]==p)
                        || (vec[i][j]==s && vec[i-1][j]==p && vec[i+1][j]==s && vec[i][j-1]==s && vec[i][j-1]==s)
                        || (vec[i][j]==s && vec[i-1][j]==s && vec[i+1][j]==s && vec[i][j-1]==p && vec[i][j-1]==s)
                        || (vec[i][j]==s && vec[i-1][j]==p && vec[i+1][j]==p && vec[i][j-1]==s && vec[i][j-1]==s)){
                    double random = Math.random();
                    if (random<=0.5){
                        vec[i][j]= monstruoGuerrero;
                    }
                } 
            } 
        }
    }
    
    
    
    
    
    
    public void laberintoCompleto(char[][] tamaño){ //Mentira que es el laberinto completo pero mientras, uso esto para ver que imprimo
        setupParedesLaberinto(lab);
        entradaYSalida(lab);
        ultColu = lab.length-2;
        ultFila = lab.length-2;
        Laberinto(lab, 1, lab.length-1, 1, lab.length-1, 1);
        colocarMonstruoNormal(lab);
  //      colocarMonstruoMago(lab);
  //      colocarMonstruoGuerrero(lab);
        impresionLab(lab);
        
    }
    
   
    
    
    

    public char getP() {
        return p;
    }

    public void setP(char p) {
        this.p = p;
    }

    public char getS() {
        return s;
    }

    public void setS(char s) {
        this.s = s;
    }

    public char getNada() {
        return nada;
    }

    public void setNada(char nada) {
        this.nada = nada;
    }

    public char getEnt() {
        return ent;
    }

    public void setEnt(char ent) {
        this.ent = ent;
    }

    public char getSal() {
        return sal;
    }

    public void setSal(char sal) {
        this.sal = sal;
    }

    public char[][] getLab() {
        return lab;
    }

    public void setLab(char[][] lab) {
        this.lab = lab;
    }
    
    
    
    
    
    
    
    
}
