package ejerciciosCap7;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
   
     public static void main(String[] args) {
         int numEntero=0;
         int numeros=0;
         try {
            File archivo = new File("archivoEjer2.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            while((cadena=br.readLine())!=null){
                 System.out.println(cadena);
                 numEntero += Integer.parseInt(cadena);
                 numeros++;
            }
            double Resultado = (double)numEntero/numeros;
             System.out.printf("%nEl promedio de los numeros es: %f %n", Resultado);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
