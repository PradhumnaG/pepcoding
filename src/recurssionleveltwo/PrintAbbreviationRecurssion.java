package recurssionleveltwo;

import java.util.Scanner;

public class PrintAbbreviationRecurssion {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str,"",0,0);
    }
    public static void  solution(String str,String ags,int count,int pos){
        if( pos == str.length()){
            if(count == 0){
                System.out.println(ags);
            }else{
                System.out.println(ags + count);
            }
            return;
        }
        if(count >0) {
            solution(str, ags + count + str.charAt(pos), 0, pos + 1);
        }else {
            solution(str,ags +str.charAt(pos),0,pos+1);
        }

            solution(str, ags, count + 1, pos + 1);

    }
}
