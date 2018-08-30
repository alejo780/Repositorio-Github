/* Ejercicio 4 multiplica n m veces*/

public class Exponencial{
  public static void main(String args[]){

    int n=5;
    int m=6;
    int S=1;
    
    for (int i=1; i<=m; i++) {
      S *= n;
    }
    System.out.println(S);
  }
}