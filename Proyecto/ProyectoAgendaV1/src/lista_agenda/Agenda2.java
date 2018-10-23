package lista_agenda;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;


public class Agenda2 {
    Contacto lista;
    public Contacto Busqueda(String cadena) {
        return lista;
    }
    
    public void Agregar(File archivo) {
        String nombre = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el nombre del contacto"));
        String apellido = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el apellido del contacto"));
        String telefono = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el telefono del contacto"));
        String correo = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el correo del contacto"));
        String direccion = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el direccion del contacto"));
        String alias = (JOptionPane.showInputDialog(null, 
                            "Porfavor ingresa el alias del contacto"));
        lista = new Contacto(nombre, apellido, telefono, correo, direccion,alias);
        try {
            if (archivo.length() == 0) {
                
                FileOutputStream fos = new FileOutputStream(archivo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lista);
                oos.flush();
            
            } else {
                
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lista);
                oos.flush();
            
            }
            
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    
    public void Modificar(Contacto lista) {
        
    }
    
    public void Eliminar(Contacto lista) {
        
    }
    
    public void Exportar(int num_contactos, File archivo, File archivo2) {
         try {
            FileWriter fw = new FileWriter(archivo2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            for(int i=1; i<=num_contactos; i++) {
                lista=(Contacto) ois.readObject();
                JOptionPane.showInputDialog(null,lista.toString());
                bw.write(lista.toString());
                bw.newLine();
                lista=null;
                }
            bw.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
    }
    
    public void Importar() {
        
    }
    
}
