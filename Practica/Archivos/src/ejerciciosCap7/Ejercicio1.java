package ejerciciosCap7;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        int numero;
        Scanner entrada = new Scanner(System.in);
        
         try {
            File archivo = new File("archivoEjer1.txt");
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=1; i<=10; i++){
                  numero = entrada.nextInt();
                  bw.write("Usted ingreso el numero = " + numero);
                  bw.newLine();
         }
         bw.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}