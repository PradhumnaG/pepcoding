package recurssionleveltwo;

import java.util.Scanner;

public class PalindromePartioningOfaStringRecursive {
    public static boolean isPalindrome(String str){
        int li =0;
        int ri = str.length() -1;
        while(li<ri){
            char left = str.charAt(li);
            char right = str.charAt(ri);
            if(left != right){
                return false;
            }
        }
        return true;
    }
    public static void solution(String str,String asf){
        for(int i = 0;i <str.length();i++){
            String prefix = str.substring(0,i+1);
            String ros = str.substring(i +1);
            if(isPalindrome(prefix)){
                solution(ros,asf+"("+prefix+")");

            }
        }
    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"");

    }
}
