package ejerciciosCap7.ejercicio3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Escritura {
    public static int main(String[] args) {
         int cont=0;
         Persona p;
         String nombre;
         String apellido;
         String correo;
         Scanner entrada = new Scanner(System.in);
         try {
            cont ++ ;
            File archivo = new File("archivoEjer3.txt");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            System.out.println("Escribe el nombre");
            nombre = entrada.nextLine();
            System.out.println("Escribe el apellido");
            apellido = entrada.nextLine();
            System.out.println("Escribe el correo");
            correo = entrada.nextLine();
            
            p=new Persona(cont,nombre,apellido,correo);
            oos.writeObject(p);
            
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
         return cont;
    }
}