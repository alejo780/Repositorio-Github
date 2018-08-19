public class Raices{
  public static void main(String args[]){

    int a = 3;
    int b = 2;
    int c = 6;

    double value = (b*b) - ((4*a)*c);  

    if(a != 0){

      if(value < 0){

        System.out.println("Raices Imaginarias");
        value = value*(-1);

        double x1 = ((-b) + (Math.sqrt(value))) / (2*a);
        double x2 = ((-b) - (Math.sqrt(value))) / (2*a);
    
        System.out.println("X1: " + x1 + " i X2: " + x2 + " i ");
      }
      else if(value == 0){
        System.out.println("Raices Iguales");

        double x1 = (-b) / (2*a);

        System.out.println("X1: X2" + x1);
      }
      else{
        System.out.println("Raices Diferentes");

        double x1 = ((-b) + (Math.sqrt(value))) / (2*a);
        double x2 = ((-b) - (Math.sqrt(value))) / (2*a);

        System.out.println("X1: " + x1 + " X2: " + x2);
      }
    }
    else{
      System.out.println("El coeficiente -a- debe ser diferente de cero.");
    }
  }
}