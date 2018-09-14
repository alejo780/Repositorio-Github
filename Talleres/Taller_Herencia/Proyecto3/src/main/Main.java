package main;
import clases.Publicacion;
import clases.Revista;
import clases.Libro;
import clases.Prestable;

public class Main {

    public static int cuentaPrestados(Object[] lista) {
        int contador = 0;
        // SE COMPRUEBA QUE ES PRESTABLE
        for (Object obj : lista) {
            if (obj instanceof Prestable && ((Prestable) obj).prestado()) {
                contador++;
            }
        }
        return contador;
    }

    public static int publicacionesAnterioresA(Publicacion[] lista, int año) {
        int contador = 0;
        for (Publicacion p : lista) {
            if (p.getAño() < año) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Publicacion[] biblioteca = { new Libro("CCOD5", "Juventud en Extasis", 1996),
                new Revista("COD1", "Alejo Colombia", 2006, 142), new Libro("CCOD3", "4 Acuerdos", 1988),
                new Revista("COD2", "Quo", 2010, 85) };

        Libro l = (Libro) biblioteca[0]; // SE TRANSFORMA A LIBRO PARA PODER
                                            // LLAMAR A prestar()
        l.prestar();
        for (Publicacion p : biblioteca) {
            System.out.println(p);
        }
        System.out.println(publicacionesAnterioresA(biblioteca, 1990));
        System.out.println(cuentaPrestados(biblioteca));
    }

}