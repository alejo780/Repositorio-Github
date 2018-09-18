package ejemplosCap7;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Ejemplo1 {
    public static void main(String[] args) {

         File archivo = new File("archivo.txt");
         System.out.println("El nombre del archivo es:"+
         archivo.getName());
         System.out.println("La ruta absoluta del archivo es: "+
         archivo.getAbsoluteFile().toString());
         try {
            if(archivo.createNewFile()){
                System.out.println("El archivo fue creado");;
            }else{
                System.out.println("El archivo NO fue creado");;
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
         System.out.println("Es directorio? "+
         archivo.isDirectory());
         System.out.println("Es archivo? "+archivo.isFile());
         System.out.println("Fecha de modificacion: "+
         archivo.lastModified());
         Date fecha = new Date(archivo.lastModified());
         System.out.println("Fecha de modificacion: "+
         fecha.toString());
         System.out.println("Tamaño "+archivo.length());
        
    }
}