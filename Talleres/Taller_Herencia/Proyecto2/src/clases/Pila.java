package clases;
import java.util.NoSuchElementException;

public class Pila implements ColeccionInterface {

    private final Object[] array;
    private int contador;

    public Pila(int tamañoMaximo) {
        array = new Object[tamañoMaximo];
        contador = 0;
    }

    @Override
    public boolean estaVacia() {
        return contador == 0;
    }

    @Override
    public boolean añadir(Object objeto) {
        if (contador == array.length) {
            return false;
        } else {
            array[contador] = objeto;
            contador++;
            return true;
        }
    }

    @Override
    public Object primero() {
        if (estaVacia()) {
            throw new NoSuchElementException();
         } else {
            
            return array[contador - 1];
         }
    }

    @Override
    public Object extraer() {
        if (estaVacia()){
            throw new NoSuchElementException();
        } else {
             Object num_extraido = array[contador-1];
             for (int i = contador-1; i >= 0; i--) {
                  if (i > 0){
                      array[i] = array[i-1];
                  } else {
                      array[i] = " ";
                  }
             }
            return num_extraido;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = contador-1; i >= 0; i--) {
        s += array[i].toString() + ", ";
        }
        if (!estaVacia()) {
            // ELIMINAMOS LA ULTIMA COMA
            return s.substring(0, s.length() - 1) + " ]";
        } else {
            return s + "]";
        }

    }

}
