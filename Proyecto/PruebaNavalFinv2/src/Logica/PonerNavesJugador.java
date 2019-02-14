
package Logica;

import javax.swing.JOptionPane;

public class PonerNavesJugador {
    static int filaMovimientoJugador=0, columnaMovimientoJugador=0, numeroNave=1;
    static boolean posicionValida=false, barcoNoColocado=false, barcosHColocado=false, barcosVColocado=false, barcoColocado=false;
    static String mensaje="", titulo="";
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    
    public static void ponerTodasLasNavesJugador(){
        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un numero entre 1 y 15, tanto para filas y columnas", "Colocación de barcos", JOptionPane.INFORMATION_MESSAGE);
        for(int i=0; i<10; i++){
            ponerBarco();
            resetearFilaColumnaPosicion();
        }
        barcoColocado=true;
        numeroNave=1;
        for(int i=0; i<5; i++){
            ponerBarcosH();
            resetearFilaColumnaPosicion();
        }
        barcosHColocado=true;
        numeroNave=1;
       for(int i=0; i<5; i++){
            ponerBarcosV();
            resetearFilaColumnaPosicion();
        }
        barcosVColocado=true;
        numeroNave=1;
        if (barcosHColocado==true && barcosVColocado==true && barcoColocado==true){
            navesColocadosCorrectamente();
        }
    }
    
    public static boolean validarFilaColumnaIngresadas(String pMensaje, String pTitulo, int pNumeroNave){
        String auxValidacionFilaInterna="", auxValidacionColumnaInterna="";
        do {
            do {
                do {
                    auxValidacionFilaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la fila de inicio para "+pMensaje+" #"+pNumeroNave,"Colocar "+pTitulo,JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionFilaInterna==null) || (auxValidacionFilaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de fila, esta es necesaria para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionFilaInterna==null || auxValidacionFilaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionFilaInterna)==true){
                    filaMovimientoJugador=Integer.parseInt(auxValidacionFilaInterna.trim());
                    if (filaMovimientoJugador<1 || filaMovimientoJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (filaMovimientoJugador<1 || filaMovimientoJugador>15);
            filaMovimientoJugador-=1;
            
            do {
                do {
                    auxValidacionColumnaInterna=(JOptionPane.showInputDialog(null,idj.getNombreUsuario()+", por favor digite la columna de inicio para "+pMensaje+" #"+pNumeroNave,"Colocar "+pTitulo,JOptionPane.QUESTION_MESSAGE));
                    if ((auxValidacionColumnaInterna==null) || (auxValidacionColumnaInterna.equals(""))) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no digitó el número de columna, esta es necesaria para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } while (auxValidacionColumnaInterna==null || auxValidacionColumnaInterna.equals(""));
                if(mu.validarSiEsNumero(auxValidacionColumnaInterna)==true){
                    columnaMovimientoJugador=Integer.parseInt(auxValidacionColumnaInterna.trim());
                    if (columnaMovimientoJugador<1 || columnaMovimientoJugador>15) {
                        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", debe digitar un número entre 1 y 15 para colocar "+pMensaje, "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (columnaMovimientoJugador<1 || columnaMovimientoJugador>15);
            columnaMovimientoJugador-=1;
            
            if(idj.TableroJugador[filaMovimientoJugador][columnaMovimientoJugador].equals(" ")){
                posicionValida=true;
            }else{
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", actualmente se encuentra una nave en la posición ingresada, verifique con otra fila y columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
                posicionValida=false;
            }
        } while (posicionValida==false);
        return posicionValida;
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaMovimientoJugador=0;
        columnaMovimientoJugador=0;
        posicionValida=false;
        barcoNoColocado=false;
    }
    
    public static void ponerBarco(){
        mensaje="el barco";
        titulo="Barco";
        if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
            idj.TableroJugador[filaMovimientoJugador][columnaMovimientoJugador]="1";
        }
        numeroNave++;
    }
    
    public static void ponerBarcosH(){
        mensaje="el barco horizontal";
        titulo=" Barco Horizontal";
        do {
            if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
                int i=filaMovimientoJugador;
                int j=columnaMovimientoJugador;
                if (((j+1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j+1].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i][j+1]="2";
                    barcoNoColocado=true;
                }else if(((i+1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i+1][j].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i+1][j]="2";
                    barcoNoColocado=true;
                }else if((j-1)>=0 && ((j-1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j-1].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i][j-1]="2";
                    barcoNoColocado=true;
                }else if((i-1)>=0 && ((i-1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i-1][j].equals(" "))){
                    idj.TableroJugador[i][j]="2";
                    idj.TableroJugador[i-1][j]="2";
                    barcoNoColocado=true;
                }
            }
            if (barcoNoColocado==false) {
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no se pudo colocar la nave, por favor intente con otra fila o columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (barcoNoColocado==false);
        numeroNave++;
    }
    
    
    public static void ponerBarcosV(){
        mensaje="el barco vertical";
        titulo=" Barco vertical";
        do {
            if (validarFilaColumnaIngresadas(mensaje, titulo, numeroNave)==true) {
                int i=filaMovimientoJugador;
                int j=columnaMovimientoJugador;
                if (((j+1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j+1].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i+1][j]="3";
                    barcoNoColocado=true;
                }else if(((i+1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i+1][j].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i][j+1]="3";
                    barcoNoColocado=true;
                }else if((j-1)>=0 && ((j-1)<=(idj.TableroJugador[0].length-1)) && (idj.TableroJugador[i][j-1].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i-1][j]="3";
                    barcoNoColocado=true;
                }else if((i-1)>=0 && ((i-1)<=(idj.TableroJugador.length-1)) && (idj.TableroJugador[i-1][j].equals(" "))){
                    idj.TableroJugador[i][j]="3";
                    idj.TableroJugador[i][j-1]="3";
                    barcoNoColocado=true;
                }
            }
            if (barcoNoColocado==false) {
                JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", no se pudo colocar la nave, por favor intente con otra fila o columna", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (barcoNoColocado==false);
        numeroNave++;
    }

    public static void navesColocadosCorrectamente(){
        JOptionPane.showMessageDialog(null, idj.getNombreUsuario()+", sus naves han sido colocadas en el tablero y las podrá reconocer de la siguiente forma:\n\n" + 
                                             "   a) barcos, se representan con un numero \"1\"\n" + 
                                             "   b) barcos horizontales, se representan con dos numeros \"2\"\n" + 
                                             "   c) barcos verticales, se representan con tres numeros \"3\"\n","Naves colocadas", JOptionPane.INFORMATION_MESSAGE);
    }

}