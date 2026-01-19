package amazon;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
    public static int solution(String str){
        int ans = 0;
        int i  = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
          while(true){
              boolean f1 = false;
              boolean f2 = false;

            //acquire
        while(i<str.length()-1){
            i++;
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch) == 2){
                break;
            }else{
                int len = i -j;
                if(len > ans){
                    ans  = len;
                }
            }

        }
        //relese
              while(j<i){
                  j++;
                  char ch  = str.charAt(j);
                  map.put(ch,map.getOrDefault(ch,0)-1);
                  if(map.get(ch) == 1){
                      break;
                  }

              }
              if(f1 == false && f2 == false){
                  break;
              }
        }
          return ans;
    }






    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

}
