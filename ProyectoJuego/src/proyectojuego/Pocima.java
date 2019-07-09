/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;

/**
 *
 * @author Estudiantes
 */
public class Pocima extends Objeto{

    private boolean esAditiva;
    private double valor;
    private double [] auxAditivo = {1,2,5,10,20};
    private double [] auxMult = {1.10,1.20,1.25,1.5,2};
    
    public Pocima() {
        super(false);
        int random = (int) (Math.random()*1);
        if (random==1){
            this.esAditiva=true;
            int seleccionaValor = (int) (Math.random()*4);
            switch (seleccionaValor){
                case 0:
                    this.valor=auxAditivo[0];
                    break;
                case 1:
                    this.valor=auxAditivo[1];
                    break;
                case 2:
                    this.valor=auxAditivo[2];
                    break;
                case 3:
                    this.valor=auxAditivo[3];
                    break;
                case 4:
                    this.valor=auxAditivo[4];
                    break;
            }
        } else {
            this.esAditiva=false;
            int seleccionaValor = (int) (Math.random()*4);
            switch (seleccionaValor){
                case 0:
                    this.valor=auxMult[0];
                    break;
                case 1:
                    this.valor=auxMult[1];
                    break;
                case 2:
                    this.valor=auxMult[2];
                    break;
                case 3:
                    this.valor=auxMult[3];
                    break;
                case 4:
                    this.valor=auxMult[4];
                    break;
            }
        }
    }
    
    public void datosPocima(){
        if(esAditiva){
            System.out.println("Pocion +"+valor);
        } else {
            System.out.println("Pocion x"+valor);
        }
    }
    
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEsAditiva() {
        return esAditiva;
    }
    
    
    
    
}
