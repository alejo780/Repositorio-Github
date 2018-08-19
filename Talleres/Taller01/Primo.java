public class Primo{
  public static void main(String args[]){
    int num = 5;
    int contador = 0;
    for(int i=1; i<=7; i++){
      if(num%i == 0){
        contador += 1;
      }
    }
    if((num == 1) || (num==0)){
      System.out.println("El numero no es primo");
    }
    else if(contador <= 2){
      System.out.println("El numero es primo");
    } 
    else{
      System.out.println("El numero no es primo");
    }
  }
}