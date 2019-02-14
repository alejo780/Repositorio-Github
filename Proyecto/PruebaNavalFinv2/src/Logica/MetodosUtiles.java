
package Logica;

import javax.swing.JOptionPane;

public class MetodosUtiles {
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();   
    static int turnoRandom;
    
    public static boolean validarSiEsNumero(String pTexto){
        try {
            Integer.parseInt(pTexto);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    
    public static void mostrarMensajeBienvenida(){
        JOptionPane.showMessageDialog(null,"        Universidad Tecnológica de Pereira\n" + 
                                           "                   Ingeniería de Sistemas\n" + 
                                           "                         Programación IV\n\n" + 
                                           "                  Juego de Batalla Naval\n\n" + 
                                           "                            Elaborado por:\n" + 
                                           "                  Alejandro Martinez Corrales\n",
                                           "Proyecto Final", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void generarTurnoRandom(){
        turnoRandom=(int)(Math.random()*2);
    }
    
    public static void mensajeInicioDeJuego(){
        generarTurnoRandom();
        JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+" en este momento inician los ataques\n                       Mucha suerte","Inicio del juego",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void mensajeFinDeJuego(){
        JOptionPane.showMessageDialog(null,idj.getNombreUsuario()+", gracias por jugar Batalla Naval","Fin del juego",JOptionPane.INFORMATION_MESSAGE);
    }

    public static int getTurnoRandom() {
        return turnoRandom;
    }
    
}
