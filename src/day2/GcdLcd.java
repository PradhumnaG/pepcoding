package day2;

import java.util.Scanner;

public class GcdLcd {
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2= sc.nextInt();
        int op1 = n1;
        int op2 = n2;
        while ( n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }//
        int gcd = n2;
        int lcd =  ( op1 * op2) /gcd;
        System.out.println(" GCD"+" "+gcd);
        System.out.println("LCD"+"   "+lcd);
    }

}
