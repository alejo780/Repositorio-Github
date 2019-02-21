package pmodelo;
import java.awt.*;
import javax.swing.ImageIcon;

public class EstadoBarco {
    private Image PiezaViva; //imagen de la pieza que no ha sido atacada
    private boolean PiezaMuerta; //imagen de la pieza atacada
    boolean EsJugador1; //determinar de que jugador se trata 

    //Construir una pieza en base a que jugador es
    public EstadoBarco(boolean EsJugador1) {
        this.EsJugador1 = EsJugador1;
        
        if(EsJugador1)
            PiezaViva = new ImageIcon("jugador.png").getImage();
        else 
            PiezaViva = new ImageIcon("oculto.png").getImage();
        PiezaMuerta = false;
    }
    
    //Cambiar la imagen de la pieza, por ejemplo cuando le disparan
    public void setBarcoImage(String file) {
        PiezaViva = new ImageIcon(file).getImage();
    }
    
    //Obtener la imagen de la pieza
    public Image getShipImage() {
        return PiezaViva;
    }
    
    //Cuando la pieza se destruye su imagen cambia
    public void Destruido() {
        PiezaMuerta = true;
        if(EsJugador1) {
            setBarcoImage("acierto.png");
        } else {
            setBarcoImage("acierto.png");
        }
    }
    
    //Verificar si una pieza esta destruida 
    public boolean pDestruida() {
        return PiezaMuerta;
    }
    
}
