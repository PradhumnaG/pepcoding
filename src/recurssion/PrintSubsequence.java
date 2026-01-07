package recurssion;

import java.util.Scanner;



public class PrintSubsequence
{
    public static void  main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        print(str, "");
    }
    public static void print(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        print(ros, ans + ch);
        print(ros, ans + "");
    }
}
