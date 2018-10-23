package lista_agenda;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {
     public static void main(String[] args) throws ClassNotFoundException, IOException {

         int opcion = 0, num_contactos=0;
         String cadena,nombre,apellido,telefono,correo,direccion,alias;
         Contacto contacto;
         Agenda agenda = new Agenda();
         File archivo = new File("AgendaSerializable.txt");
         
         num_contactos=agenda.NumContactos();
         //System.out.println("numero de contactos: "+num_contactos);
        do {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                        + "1. Buscar un contacto\n"
                        + "2. Agregar un contacto\n"
                        + "3. Modificar un contacto\n"
                        + "4. Eliminar un contacto\n"
                        + "5. Exportar todos los contactos\n"
                        + "6. Importar contactos\n"
                        + "7. Salir.\n\n"));
                
                switch (opcion) {
                    case 1:
                        if (archivo.exists()) {
                            cadena = (JOptionPane.showInputDialog(null,
                                "Por favor ingresa lo que vas a buscar "));
                            contacto=agenda.Buscar(archivo, num_contactos, cadena);
                            if (contacto!=null){
                                JOptionPane.showMessageDialog(null,  contacto.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "El contacto no existe.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Todavía no has agregado contactos.");
                        }
                            
                        break;
                        
                    case 2:
                        nombre = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el nombre del contacto"));
                        apellido = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el apellido del contacto"));
                        telefono =(JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el teléfono del contacto"));
                        correo = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el correo del contacto"));
                        direccion = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el dirección del contacto"));
                        alias = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el alias del contacto"));
                        contacto = new Contacto(nombre, apellido, telefono, correo, direccion,alias);
                        agenda.Agregar(contacto, archivo);
                        JOptionPane.showMessageDialog(null, "Contacto agregado.");
                        num_contactos+=1;
                        break;
                        
                    case 3:
                        cadena = (JOptionPane.showInputDialog(null, 
                                "Por favor ingresa el nombre del contacto que vas a modificar "));
                        contacto = agenda.Buscar(archivo, num_contactos, cadena);
                        if (contacto!=null){
                             nombre = (JOptionPane.showInputDialog(null, 
                                            "Por favor ingresa el nombre del nuevo contacto"));
                            apellido = (JOptionPane.showInputDialog(null, 
                                                "Por favor ingresa el apellido del nuevo contacto"));
                            telefono =(JOptionPane.showInputDialog(null, 
                                                "Por favor ingresa el teléfono del nuevo contacto"));
                            correo = (JOptionPane.showInputDialog(null, 
                                                "Por favor ingresa el correo del nuevo contacto"));
                            direccion = (JOptionPane.showInputDialog(null, 
                                                "Por favor ingresa el dirección del nuevo contacto"));
                            alias = (JOptionPane.showInputDialog(null, 
                                                "Por favor ingresa el alias del nuevo contacto"));
                            contacto = new Contacto(nombre, apellido, telefono, correo, direccion,alias);
                            agenda.Modificar(archivo, cadena, contacto, num_contactos);
                            JOptionPane.showMessageDialog(null, "Contacto modificado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El contacto no existe.");
                        }
                        
                        break;
                        
                    case 4:
                        cadena = (JOptionPane.showInputDialog(null, 
                                "Por favor ingresa el nombre del contacto que vas a eliminar "));
                        contacto = agenda.Buscar(archivo, num_contactos, cadena);
                        if (contacto!=null){
                            agenda.Eliminar(archivo, cadena, num_contactos);
                            JOptionPane.showMessageDialog(null, "Contacto eliminado.");
                            num_contactos--;
                        } else {
                            JOptionPane.showMessageDialog(null, "El contacto no existe.");
                        }
                        break;
                        
                    case 5:
                        if (num_contactos != 0) {
                            agenda.Exportar(archivo, num_contactos);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay contactos para exportar.");
                        }
                       break;
                        
                    case 6:
                        File archivo2 = new File("Importar.txt");
                        if (archivo2.exists()) {
                            int num=agenda.Importar(archivo, archivo2);
                            num_contactos=num_contactos+num;
                        } else {
                            JOptionPane.showMessageDialog(null, "El archivo desde el que vas a importar no existe.");
                        }
                        break;
                        
                    case 7:
                        opcion = 7;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, vuelve intentar nuevamente.");
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Tienes que ingresar un número.");
            }
        } while (opcion != 7);
    }
}
