package clases;
import clases.Formato;

public class Multimedia {
  
    private String titulo;
    private String autor;
    private Formato formato;
    private double duracion;
   
    public Multimedia(String titulo, String autor, Formato formato, double duracion) {

        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }
    
    //Estos metodo debe devolver cada uno de los atributos Setter and Geter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString(){
        return "multimedia {"
                + " titulo: " + titulo
                + ", autor: " + autor
                + ", formato: " + formato
                + ", duracion: " + duracion+'}';
    }
    
    // Metodo para verificar si las cadenas autor y titulo son iguales
    public boolean equals(Multimedia m) {
        return titulo.equals(m.getTitulo()) && autor.equals(m.getAutor());
    } 
}
