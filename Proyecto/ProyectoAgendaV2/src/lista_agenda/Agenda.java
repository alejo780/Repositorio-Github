package lista_agenda;
import java.io.*;
import javax.swing.JOptionPane;
 
public class Agenda{
    public Contacto[] contactos;
    
    public int NumContactos() throws ClassNotFoundException, IOException{
        int num=0;
        ObjectInputStream ois=null;
        try {
            File archivo=new File("AgendaSerializable.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream(archivo);
                ois=new ObjectInputStream(fis);
                Contacto c= (Contacto) ois.readObject();
                while(ois!= null) {
                    num++;
                    c= (Contacto) ois.readObject();
                }
                
            } else {
                num=0;
                return num;
            }
         } catch (FileNotFoundException e) {
                e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
               return num;
         }
        return num;
    }
    
    //AGREGAR
    public void Agregar(Contacto persona, File archivo){ 
       try {
           FileOutputStream fos; 
            if (archivo.length() == 0) {
                fos = new FileOutputStream(archivo);
            } else {
                fos = new FileOutputStream(archivo, true);
            }
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persona);
            oos.flush();
            oos.close();
            fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
    }
    
    //BUSCAR
    public Contacto Buscar(File archivo, int num, String cadena) {
        Contacto c;
        try {
            
            FileInputStream fis = new FileInputStream(archivo);
            for (int i=1; i<=num; i++) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            c=(Contacto) ois.readObject();
            
            if ((c.nombre.equals(cadena)) || (c.apellido.equals(cadena)) || (c.correo.equals(cadena))
               || (c.direccion.equals(cadena)) || (c.telefono.equals(cadena)) || (c.alias.equals(cadena))) {
                //System.out.println(c.toString());
                i=num+1;
                return c;
                }
              }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }
    
    //EXPORTAR
    public void Exportar(File archivo, int num) {
        Contacto persona;
        try {
                FileInputStream fis = new FileInputStream(archivo);
                for (int i=1; i<=num; i++) {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    persona=(Contacto) ois.readObject();
                    escribirPersona(persona,i);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    //
    public void escribirPersona(Contacto persona, int i){
        try {
            File f=new File("AgendaTelefonica.txt");
            if (f.exists() && i==1) {
                f.delete();
            }
            FileWriter fw;
            BufferedWriter bw;
            if (f.exists()) {
                 fw=new FileWriter(f, true);
                 bw = new BufferedWriter(fw);
                 bw.newLine();
                 bw.write(persona.toString());
            } else {
                 fw=new FileWriter(f);
                 bw = new BufferedWriter(fw);
                 bw.write(persona.toString());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void escribirSer(Contacto persona, File archivo, int i){ 
       try {
           FileOutputStream fos;
           if(i==1) {
                fos = new FileOutputStream(archivo);
           } else {
               fos = new FileOutputStream(archivo, true);
           }
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(persona);
           oos.flush();
           oos.close();
           fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
    }
    
    public  void Eliminar(File archivo, String cadena, int num) {
        contactos = new Contacto[num+1];
        Contacto c;
        int contador=0;
         try {
            FileInputStream fis = new FileInputStream(archivo);
           for (int i=1; i<=num; i++) {    
               ObjectInputStream ois = new ObjectInputStream(fis);
               c=(Contacto) ois.readObject();
               if ((c.nombre.equals(cadena)) || (c.apellido.equals(cadena)) || (c.correo.equals(cadena))
               || (c.direccion.equals(cadena)) || (c.telefono.equals(cadena)) || (c.alias.equals(cadena))) {
                    //System.out.println(c.toString()+"eliminado");
                    contador=i;
                } else {
                    contactos[i] = c;
               }
           }
           for (int i=1; i<=num; i++) {
               if (i!=contador){
                escribirSer(contactos[i],archivo,i);
               }
           }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
}
    
    public  void Modificar(File archivo, String cadena, Contacto p, int num) {
        contactos = new Contacto[num+1];
        Contacto c;
         try {
            FileInputStream fis = new FileInputStream(archivo);
           for (int i=1; i<=num; i++) {    
               ObjectInputStream ois = new ObjectInputStream(fis);
               c=(Contacto) ois.readObject();
               if ((c.nombre.equals(cadena)) || (c.apellido.equals(cadena)) || (c.correo.equals(cadena))
               || (c.direccion.equals(cadena)) || (c.telefono.equals(cadena)) || (c.alias.equals(cadena))) {
                //System.out.println(c.toString()+"modificado");
                contactos[i]=p;
                } else {
                    contactos[i] = c;
               }
               //System.out.println(contactos[i].toString());
           }
           for (int i=1; i<=num; i++){
               escribirSer(contactos[i],archivo,i);
           }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
}
    
    //IMPORTAR
    public int Importar(File archivo, File archivo2) {
        int num=0;
        try {
            if (archivo2.length() != 0) {
                FileReader fr=new FileReader(archivo2);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine()) != null) {
                    String [] contacto = linea.split(";");
                    Contacto persona=new Contacto(contacto[0],contacto[1],contacto[2],
                                                                          contacto[3],contacto[4],contacto[5]);
                    persona.toString();
                    Agregar(persona,archivo);
                    num++;
                  }
              } else {
                JOptionPane.showMessageDialog(null, "No hay contactos para importar");
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return num;
    }
}