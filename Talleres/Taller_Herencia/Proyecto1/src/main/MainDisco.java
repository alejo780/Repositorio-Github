package main;
import clases.Disco;
import clases.Formato;
import clases.ListaMultimedia;
import clases.Genero;

public class MainDisco {

    public static void main(String[] args) {
        ListaMultimedia lista = new ListaMultimedia(20);
        Disco disco;
        lista.add(new Disco("Shape Of You", "Edd Sheeran", Formato.mp3, 45, Genero.pop));
        lista.add(new Disco("Wake Me Up", "Avicii", Formato.dvd, 45, Genero.pop));

        lista.add(new Disco("El Vals del Obrero", "Ska-p", Formato.cdAudio, 50, Genero.rock));
        System.out.println(lista.toString());
        disco = new Disco("El Vals del Obrero", "Ska-p", null, 0, null);

    }

}
