package pmodelo;

import java.awt.Point;
import java.util.ArrayList;

public class Barco {
    private EstadoBarco[] piezas;
    private Point PuntoInicial;
    
    /**
     * Por si se desean construir barcos en base a un vector de piezas
     * @param lista 
     */
    public Barco(EstadoBarco[] lista){
        piezas = lista;
        PuntoInicial = new Point(0,0);
    }
    
    /**
     * Constructor de barco con una lista de piezas
     * @param lista 
     */
    public Barco(ArrayList<EstadoBarco> lista){
        piezas = lista.toArray(new EstadoBarco[0]);
        PuntoInicial = new Point(0,0);
    }
    
    /**
     * Verificar si a un barco aun le quedan piezas
     * @return 
     */
    public boolean verificarVida(){
        boolean estaMuerto = true;
        for (int i = 0; i < piezas.length; i++) {
            if (!piezas[i].pDestruida()) {
                estaMuerto = false;
            }
        }
        return estaMuerto;
    }
    
    /**
     * Obtener el conjunto de piezas del barco
     * @return 
     */
    public EstadoBarco[] getEstadoBarco() {
        return piezas;
    }
    
    /**
     * Cambiar la posicion inicial del barco
     * @param PI 
     */
    public void setPosicionInicial(Point PI){
        PuntoInicial = PI;
    }
    
    /**
     * Obtener el punto inicial del barco
     * @return 
     */
    public Point getPuntoInicial() {
        return PuntoInicial;
    }
}
