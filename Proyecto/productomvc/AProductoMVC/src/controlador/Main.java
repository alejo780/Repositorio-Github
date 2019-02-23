package controlador;
import vista.interfaz;

public class Main {
    
    public static void main(String[] args) {
        //ejecuta el controlador y este la vista
        new controlador( new interfaz() ).iniciar() ;
    }

}
