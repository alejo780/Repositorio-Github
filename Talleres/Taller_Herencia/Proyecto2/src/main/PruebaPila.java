package main;
import clases.ColeccionInterface;
import clases.Pila;

    public class PruebaPila {

        public static void rellenar(ColeccionInterface c) {
            for (int i = 0; i <= 10; i++) {
                c.añadir(i);
        }
    }

    public static void imprimirYVaciar(ColeccionInterface col) {
         if (!col.estaVacia()) {
            System.out.println(col.extraer());
        }
    }

    public static void main(String[] args) {
        
        Pila p = new Pila(20);
        rellenar(p);
        System.out.println("La pila: " + p);
        imprimirYVaciar(p);
        System.out.println("Ahora la pila es: " + p);
    }
}
