package recurssionleveltwo;

import java.util.HashMap;
import java.util.Scanner;

//all character be even
//all character be even and only one odd. 
public class PalindromePartitioning {
    public static void generatepw(int cs,int ts,HashMap<Character,Integer>fmap,Character oddc,String asf){
       if(cs>ts){
           String rev = "";
           for (int i = asf.length()-1;i>=0;i--){
               rev +=asf.charAt(i);
           }
           String res = asf;
           if(oddc !=null){
               res +=oddc;
           }
           res +=rev;
           System.out.println(res);
           return;
       }

        for(char ch : fmap.keySet()){
            int freq = fmap.get(ch);
            if(freq > 0){
                fmap.put(ch,freq -1);
                generatepw(cs+1,ts,fmap,oddc,asf +ch);
                fmap.put(ch,freq +1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(int i = 0;i <str.length();i++){
            char ch = str.charAt(i);
            if(fmap.containsKey(ch)){//like a2 b2 like thisthey work
                int of = fmap.get(ch);
                fmap.put(ch,of +1);
            }else{
                fmap.put(ch,1);

            }
           /* fmap.put(ch,fmap.getOrDefault(ch,0)+1);*/
        }
        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch: fmap.keySet()){
            int freq = fmap.get(ch);
            if(freq % 2 == 1){
                odd = ch ;
                odds++;
            }
            fmap.put(ch,freq/2);
            len +=freq/2;
        }
    generatepw(1,len,fmap,odd,"");
    }


}
