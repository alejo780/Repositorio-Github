package logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utp
 * 
 */
public class OpBasicas {
    private static int num1, num2;
    public static int suma(String num1, String num2) {
        OpBasicas.num1=Integer.parseInt(num1);
        OpBasicas.num2=Integer.parseInt(num2);
        return OpBasicas.num1+OpBasicas.num2;
    }
    
    public static int resta(String num1, String num2) {
        OpBasicas.num1=Integer.parseInt(num1);
        OpBasicas.num2=Integer.parseInt(num2);
        return OpBasicas.num1-OpBasicas.num2;
    }
    
    public static int multiplicacion(String num1, String num2) {
        OpBasicas.num1=Integer.parseInt(num1);
        OpBasicas.num2=Integer.parseInt(num2);
        return OpBasicas.num1*OpBasicas.num2;
    }
    
    public static int division(String num1, String num2) {
        OpBasicas.num1=Integer.parseInt(num1);
        OpBasicas.num2=Integer.parseInt(num2);
        return OpBasicas.num1/OpBasicas.num2;
    }
    
    public static int residuo(String num1, String num2) {
        OpBasicas.num1=Integer.parseInt(num1);
        OpBasicas.num2=Integer.parseInt(num2);
        return OpBasicas.num1%OpBasicas.num2;
    }
    
}
