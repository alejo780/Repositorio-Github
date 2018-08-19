public class Factorial{
  public static void main(String args[]){

    int num = 3;
    int i = 1;
    int fac = 1;

    for(i=1; i<num; i++){
      fac += fac*i;
    
    }
    System.out.println(fac);
  }
}