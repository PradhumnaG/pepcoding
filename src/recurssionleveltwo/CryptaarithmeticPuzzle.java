package recurssionleveltwo;

import java.util.HashMap;
import java.util.Scanner;

public class CryptaarithmeticPuzzle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        HashMap<Character,Integer> charMap = new HashMap<>();
        String unique = "";
        for(int i = 0;i<s1.length();i++){
            if(!charMap.containsKey(s1.charAt(i))){
                charMap.put(s1.charAt(i),-1);
                unique += s1.charAt(i);
            }
        }
        for(int i = 0;i<s2.length();i++){
            if(!charMap.containsKey(s2.charAt(i))){
                charMap.put(s2.charAt(i),-1);
                unique += s2.charAt(i);
            }
        }  for(int i = 0;i<s3.length();i++){
            if(!charMap.containsKey(s3.charAt(i))){
                charMap.put(s3.charAt(i),-1);
                unique += s3.charAt(i);
            }
        }
        boolean[] usednumber = new boolean[10];
        solution(unique,0,charMap,usednumber,s1,s2,s3);
    }
    public static int getNum(String s,HashMap<Character,Integer>charMap){
        String num = " ";
        for(int i = 0;i<s.length();i++){
            num+=charMap.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }
    public static void solution(String unique,int idx,HashMap <Character,Integer> charMap,boolean[] usednumber,String s1,String s2,String s3){
if(idx == unique.length()){
    int num1 = getNum(s1,charMap);
    int num2 = getNum(s2,charMap);
    int num3 =getNum (s3,charMap);
    if( num1+ num2 == num3){
        for(int i = 0;i<26;i++){
            char ch = (char)('a' +i);
            if(charMap.containsKey(ch)){
                System.out.println(ch +"-"+charMap.get(ch));
            }
        }
        System.out.println();
    }
}

        char ch = unique.charAt(idx);
for (int num = 0;num<=9;num++){
    if(usednumber[num] == false){//
        charMap.put(ch,num);
        usednumber[num] = true;
        solution(unique,idx + 1,charMap,usednumber,s1,s2,s3);
        usednumber[num] = false;
        charMap.put(ch,-1);


    }
}
    }

}
