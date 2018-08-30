/* Ejercicio 3 Fibonacci */

public class Fibonacci{
  public static void main(String args[]){

    int f0 = 1;
    int f1 = 1;
    int num = 7;
    int S;

    for (int i = 2; i<=num; i++) { 
      f1 = f1+f0;
      f0 = f1-f0;    
    }
    System.out.println(f1);
  }
}