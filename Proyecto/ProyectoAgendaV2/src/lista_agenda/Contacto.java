package lista_agenda;
import java.io.Serializable;

public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    public String nombre;
    public String apellido;
    public String telefono;
    public String correo;
    public String direccion;
    public String alias;

    public Contacto(String nombre, String apellido, String telefono, String correo, String direccion, String alias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return nombre 
                + ';' + apellido 
                + ';' + telefono 
                + ';' + correo 
                + ';' + direccion 
                + ';' + alias;
    }
}
