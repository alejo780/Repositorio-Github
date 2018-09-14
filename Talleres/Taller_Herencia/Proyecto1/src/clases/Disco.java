package clases;

public class Disco extends Multimedia {

    private Genero genero;

    public Disco(String titulo, String autor, Formato formato, double duracion, Genero g) {
        super(titulo, autor, formato, duracion);
        this.genero = g;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nGenero: " + genero;
    }

}