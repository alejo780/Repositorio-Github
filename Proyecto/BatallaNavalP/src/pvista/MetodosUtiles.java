package pvista;

import javax.swing.JOptionPane;


public class MetodosUtiles {
    
    public static void Acercade(){
        JOptionPane.showMessageDialog(null,"        Universidad Tecnológica de Pereira\n" + 
                                           "                   Ingeniería de Sistemas\n" + 
                                           "                         Programación IV\n\n" + 
                                           "                  Juego de Batalla Naval\n\n" + 
                                           "                            Elaborado por:\n" + 
                                           "                  Alejandro Martinez Corrales\n",
                                           "    Proyecto 2", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void Instrucciones(){
        String instrucciones;
        instrucciones = "  Guerra Naval es un juego que se desarrolla sobre dos tableros de tamaño 15 por 15.\n" + 
                        "  El objetivo del juego es hundir todas las naves del enemigo, en este caso el enemigo será la computadora.\n\n" + 
                        "  Instrucciones de juego\n\n" + 
                        "- El usuario deberá jugar con 4 tipos de naves en su tablero, los cuales son los siguientes:\n" + 
                        "     a) barco simple, ocupa una posición, son 4 en el campo juego.\n" + 
                        "     b) barcos dobles, ocupan 2 posiciones, son 3 en campo el juego.\n" + 
                        "     c) barcos triples, ocupan 3 posiciones, son 2 en el campo de juego.\n" + 
                        "     d) barcos cuadruples, ocupan 4 posiciones, son 1 en el campo de juego.\n" + 
                        "- Los tableros de juego, tanto del jugador como de la computadora son mostrados en la ventana de juego.\n" + 
                        "- Las naves se colocan aleatoriamente tanto horizontalmente como verticalmente.\n" + 
                        "- La computadora colocará sus naves mediante forma aleatoria tambien.\n" + 
                        "- Una vez que el usuario y la computadora tengan las naves colocados en el campo de batalla, se podran iniciar los ataques\n" + 
                        "  Los ataques se podran hacer en el tablero de la derecha y dando doble clic y la computadora hará los ataques al usuario en la izquierdas.\n" +
                        "  Un ataque no acertado se pintara la casilla con color azul representando el mar.\n" + 
                        "  un ataque acertado se pinta la casilla con color rojo representando el disparo acertado a un barco, simulando una explosion.\n" + 
                        "  la computadora podrá disparar en el campo de batalla del usuario y luego el usuario tendrá su turno. Tendrán su turno de a un tiro cada uno,\n" +
                        "  sin importar que hallan acertado o no.\n " +
                        "  se mostrará en la parte de abajo los disparos restantes que serán 30 en total.";
        
            JOptionPane.showMessageDialog(null, instrucciones, "Instrucciones de juego",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Cuantosbarcos(){
        JOptionPane.showMessageDialog(null,"        En el mapa hay 13 barcos:\n\n" + 
                                                                        "                   1 barco de 4 casillas\n" + 
                                                                        "                   2 barcos de 3 casillas\n" + 
                                                                        "                   4 barcos de 2 casillas\n" + 
                                                                        "                   6 barcos de 1 casilla\n\n", 
                                                                        "    informacion", JOptionPane.PLAIN_MESSAGE);
    }
    
}
