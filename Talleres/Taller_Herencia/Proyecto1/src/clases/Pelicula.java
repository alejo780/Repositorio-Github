package clases;

public class Pelicula extends Multimedia {
    private String actorPrincipal;
    private String actrizPrincipal;

    public Pelicula(String titulo, String autor, Formato formato, double duracion, String actor, String actriz) {
        
        super(titulo, autor, formato, duracion);
        if (actor == null && actriz == null) {
            throw new IllegalArgumentException("Tienes los dos parametros vacios");
        }
        actorPrincipal = actor;
        actrizPrincipal = actriz;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(String actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }
    
    @Override
    public String toString() {
        String s = "Protagonizado por: " ;
        if (actrizPrincipal != null) {
            s += actrizPrincipal;
            if (actorPrincipal != null) {
                s += " y"  + actorPrincipal;
            }
        } else {
            assert actorPrincipal != null;
            s += actorPrincipal;
        }
        return super.toString() + s;
    }

}