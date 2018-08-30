/* Ejercicio 6 Horas equivalentes */

public class Horas{
  public static void main(String args[]){

    int semanas=0;
    int dias=0;
    int horas = 1000;
    
    if (horas >= 168) {
      while (horas >= 168) {
        horas -= 168;
        semanas += 1;
      }
    }

    if (horas >= 24) {
      while (horas >= 24) {
        horas -= 24;
        dias += 1;
      }
    }
    System.out.println(semanas + " semanas, " + dias + " dias y " + horas + " horas");
  }
}