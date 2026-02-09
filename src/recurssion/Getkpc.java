package recurssion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Getkpc {
    public static void  main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> words= new ArrayList<>();
        words  =  getKPC(str);
        System.out.println(words);
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;//
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = new ArrayList<>();
        rres=getKPC(ros);
        ArrayList<String> myres = new ArrayList<>();
        String codeforch = codes[ch - '0'];
        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for (String rstr : rres) {
                myres.add(chcode + rstr);
            }
        }
        return myres;
    }
}
