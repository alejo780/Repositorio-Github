package ejerciciosCap7.ejercicio3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int cont=0;
 
        while (!salir) {
            System.out.println("MENU:");
            System.out.println("1. Escribir en archivo");
            System.out.println("2. Leer archivo");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        cont = Escritura.main(args); 
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        String mesaje = String.valueOf(cont);
                        args[0]= mesaje;
                        Lectura.main(args);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
