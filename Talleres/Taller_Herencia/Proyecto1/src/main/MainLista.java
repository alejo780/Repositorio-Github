package main;
import clases.ListaMultimedia;
import clases.Formato;
import clases.Pelicula;

public class MainLista {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ListaMultimedia lista = new ListaMultimedia(10);
        Pelicula pelicula;
        int posicion;
        lista.add (new Pelicula ("Regreso al futuro", " Robert Zemeckis", Formato.wav, 197, "Michael J. Fox", "Lea Thompson"));
        lista.add (new Pelicula ("Titanic", "James Cameronr", Formato.avi, 356, "Leonardo DiCaprio", "Kate Winslet"));
        lista.add (new Pelicula ("Rapidos y Furiosos 8", "F. Gary Gray", Formato.avi, 168, "Vin Diesel", null));

        System.out.println(lista.toString());

    }

}
