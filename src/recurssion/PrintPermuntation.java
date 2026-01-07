package recurssion;

import java.util.Scanner;

public class PrintPermuntation
{
    public  static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        printPermutations(str,"");
    }
    public static void printPermutations(String str,String ans)
    {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i= 0;i<str.length();i++){
            char ch=str.charAt(i);
            String sros=str.substring(0,i) ;
            String fros=str.substring(i+1);
            String ros=sros+fros;
            printPermutations(ros,ans+ch);
        }


    }
}
