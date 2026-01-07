package recurssion;
import java.io.*;
import java.util.*;
import java.util.Scanner;



public class PrintKeypadCombination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        print(str, "");
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","y z"};
    public static void print(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++)
        {
            char chcode = code.charAt(i);
            print(ros, ans + chcode);

        }
    }
}
