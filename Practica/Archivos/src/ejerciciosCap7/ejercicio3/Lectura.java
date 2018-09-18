package ejerciciosCap7.ejercicio3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Lectura {
    public static void main(String[] args) {
        Persona p;
        try {
            File archivo = new File("archivoEjer3.txt");
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            int cont = Integer.parseInt(args[0]);
            
            for (int i=0; i<= cont; i++) {
                p=(Persona)ois.readObject();
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}