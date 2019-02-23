package pcontrolador;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import pmodelo.EstadoBarco;

public class Disparo {
    private int ticks = 30; //Numero de movimientos con el que se inicializa el juego
    private Clip clip; //Sonido por emitir
    private final String path = "/pcontrolador/"; //Ruta para el sonido
    private int aciertospc=0;
    private int aciertosjugador=0;
    
    
    public Disparo(){
    }
    
    /**
     * Verificar que ha pasado en el tablero tras dar un 'disparo'.
     * @param matriz1
     * @param matriz2
     * @param px
     * @param py 
     */
    public void Actualizar(Object[][] matriz1, Object[][] matriz2, int px, int py) {
        int conversionx;
        int conversiony;
        conversionx = (int)((px-518)/33);
        conversiony = (int)((py-35)/33);
        if(this.getTicks() > 0){
            if (matriz2[conversionx][conversiony].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !((EstadoBarco)matriz2[conversionx][conversiony]).pDestruida()) {
                ((EstadoBarco)matriz2[conversionx][conversiony]).Destruido();
                Play("bomba");
                aciertosjugador+=1;

            } else if ((int)matriz2[conversionx][conversiony] == 0) {
                matriz2[conversionx][conversiony] = 1;
            } else if (matriz2[conversionx][conversiony].getClass().getName().equals("pmodelo.EstadoBarco")
                    && ((EstadoBarco)matriz2[conversionx][conversiony]).pDestruida()) {
                 ((EstadoBarco)matriz2[conversionx][conversiony]).Destruido();
                System.out.println(conversionx+" "+conversiony);
            } 
            
        this.ticks--;
        esTurnoPc(matriz1);
        }
    }
    
    /**
     * Darle el turno al pc pasandole la matriz que le corresponde
     * @param matriz 
     */
    public void esTurnoPc(Object[][] matriz) {
        int pcx = (int)(Math.random() * 15);
        int pcy = (int)(Math.random() * 15);
        if (matriz[pcx][pcy].getClass().getName().equals("pmodelo.EstadoBarco")
                    && !((EstadoBarco)matriz[pcx][pcy]).pDestruida()) {
                ((EstadoBarco)matriz[pcx][pcy]).Destruido();
                System.out.println(pcx+" "+pcy);
                aciertospc++;
                
            } else if ((int)matriz[pcx][pcy] == 0) {
                matriz[pcx][pcy] = 1;
                
            } else if (matriz[pcx][pcy].getClass().getName().equals("pmodelo.EstadoBarco")
                    && ((EstadoBarco)matriz[pcx][pcy]).pDestruida()) {
                 ((EstadoBarco)matriz[pcx][pcy]).Destruido();
                
            }
        
    }
    
    /**
     * Obtener los movimientos restantes
     * @return 
     */
    public int getTicks() {
        return this.ticks;
    }
    
    public int getAciertospc() {
        return this.aciertospc;
    }
    
    public int getAciertosjugador() {
        return this.aciertosjugador;
    }
    /**
     * Sonar cuando se dispare
     * @param value 
     */
    public void Play(String value){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path+value+".wav")));
            clip.loop(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
