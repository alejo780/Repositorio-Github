package pmodelo;

import pvista.Tablero;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import pvista.Menu;
import pvista.Ventana;


public class LogicaJuego {
    public static int tamTablero = 15;
    
    public static int tamBarcoSimple = 1;
    public static int tamBarcoDoble = 2;
    public static int tamBarcoTriple = 3;
    public static int tamBarcoCuatro = 4;
    public static int barcoSimple = 6;
    public static int barcoDoble = 4;
    public static int barcoTriple  = 2;
    public static int barcoCuatro = 1;
    
    private JFrame ventana;
    private Ventana graficos;
    
    private boolean ejecutar;
    
    public void Iniciar() throws Exception {
         
        ventana = new Ventana();
         graficos = new Ventana();
        
        graficos.DimensionVentana(ventana);
        ejecutar = true;
        
        Menu MenuInicio = new Menu(ventana);
        MenuInicio.loadTitleScreen();
        while(MenuInicio.EsVVisible()){}
        
        Barco[] j1Barcos = IniciarBarcos(true);
        Barco[] pcBarcos = IniciarBarcos(false);
        
        Tablero t = new Tablero(DistribuirBarcos(j1Barcos),DistribuirBarcos(pcBarcos));
        JLabel nMovimientos = new JLabel(); 
        
        graficos.CargarElementos(ventana, t,nMovimientos);
        
        ciclo(t,j1Barcos,pcBarcos,nMovimientos); 
    }
    
    public Barco[] IniciarBarcos(boolean EsJugador1){
        Barco[] barcosSimples = crearBarco(tamBarcoSimple, barcoSimple, EsJugador1);
        Barco[] barcosDobles = crearBarco(tamBarcoDoble, barcoDoble, EsJugador1);
        Barco[] barcosTriples = crearBarco(tamBarcoTriple, barcoTriple, EsJugador1);
        Barco[] barcosCuatro = crearBarco(tamBarcoCuatro, barcoCuatro, EsJugador1);
        
        Barco[] barcos = concatArrayBarcos(barcosSimples, barcosDobles);
        Barco[] barcos1 = concatArrayBarcos(barcos, barcosTriples);
        Barco[] barcos2 = concatArrayBarcos(barcos1, barcosCuatro);
        return barcos2;
    }
    
    public Barco[] crearBarco(int tam, int numElementos, boolean EsJugador1){
        Barco[] listaBarco = new Barco[numElementos];
        for (int i = 0; i < numElementos; i++) {
            EstadoBarco[] BarcoArray = new EstadoBarco[tam];
            for (int j = 0; j < tam; j++){
                EstadoBarco p = new EstadoBarco(EsJugador1);
                BarcoArray[j] = p;
            }
            listaBarco[i] = new Barco(BarcoArray);
        }
        return listaBarco;
    }
    
    public Barco[] concatArrayBarcos(Barco[] s, Barco[] d) {
        int sLen = s.length;
        int dLen = d.length;
        Barco[] c = new Barco[sLen + dLen]; 
        System.arraycopy(s, 0, c, 0, sLen);
        System.arraycopy(d, 0, c, sLen, dLen);
        return c;
    }
    
    public Object[][] DistribuirBarcos(Barco[] b){
        Object[][] resultado = new Object[15][15];
        
        for(int i= 0; i<15; i++){
            for(int  j=0; j<15; j++){
                resultado[i][j] = 0;
            }
        }
        
        int x,y;
        
        for (int i = 12; i < 13; ) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*12);
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+1].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+2].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+3].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                resultado[x][y+1] = b[i].getEstadoBarco()[1];
                resultado[x][y+2] = b[i].getEstadoBarco()[2];
                resultado[x][y+3] = b[i].getEstadoBarco()[3];
                i++;
           }
        }
        
        for (int i = 11; i < 12; ) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*13);
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+1].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+2].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                resultado[x][y+1] = b[i].getEstadoBarco()[1];
                resultado[x][y+2] = b[i].getEstadoBarco()[2];
                i++;
           }
        }
        
        for (int i = 10; i < 11; ) {
            x = (int)Math.floor(Math.random()*13);
            y = (int)Math.floor(Math.random()*15);
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x+1][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x+2][y].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                resultado[x+1][y] = b[i].getEstadoBarco()[1];
                resultado[x+2][y] = b[i].getEstadoBarco()[2];
                i++;
           }
        }
        
        for (int i = 8 ; i <  10; ) {
            x = (int)Math.floor(Math.random()*14);
            y = (int)Math.floor(Math.random()*15);
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x+1][y].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                resultado[x+1][y] = b[i].getEstadoBarco()[1];
                i++;
                    }
        }
        
        for (int i = 6 ; i <  8; ) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*14);
            
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !resultado[x][y+1].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                resultado[x][y+1] = b[i].getEstadoBarco()[1];
                i++;
                    
            }
        }
        
        for (int i = 0 ; i < 6;) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*15);
            
            if (!resultado[x][y].getClass().getName().equals("pmodelo.EstadoBarco")) {
                resultado[x][y] = b[i].getEstadoBarco()[0];
                i++;
                    
            }
        }
        return resultado;
    }
    
    public void ciclo(Tablero t,  Barco[] pc, Barco[] jugador, JLabel Mvtos) throws IOException, Exception {
        
        while(ejecutar) {
            Mvtos.setText("Disparos disponibles: " + Integer.toString(t.getDisparo().getTicks()));
            
            boolean todosMuertos1 = true;
            boolean todosMuertos2 = true;
            
            for (int i = 0; i < jugador.length; i++) {
                
                    if ( !jugador[i].verificarVida()) {
                       todosMuertos1 = false; 
                    
                }
            }
            
            for (int i = 0; i < pc.length; i++) {
                
                if ( !pc[i].verificarVida()) {
                   todosMuertos2 = false; 
                    
                }
            }
            
            if(todosMuertos1 || todosMuertos2 || t.getDisparo().getTicks() == 0) {
                t.repaint();
                if (todosMuertos1) {
                    graficos.finalizar(ventana, t, Mvtos,0);
                    
                    this.setEjecutar(false);
                } else if (todosMuertos2) {
                    graficos.finalizar(ventana, t, Mvtos, 1);
                    this.setEjecutar(false);
                } else if (t.getDisparo().getTicks() == 0) {
                    for (int i = 0; i < jugador.length; i++) {
                        for (int j = 0; j < jugador[i].getEstadoBarco().length; j++) {
                            jugador[i].getEstadoBarco()[j].Destruido();
                        }
                    }
                    graficos.finalizar(ventana, t, Mvtos, 2);
                    this.setEjecutar(false);
                } 
            } 
            t.repaint();
        }
    }
    
    public void setEjecutar(boolean E) {
        ejecutar = E;
    }
}
