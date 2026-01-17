package Day2;

import java.util.Scanner;

public class RotateANUmber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int temp = n;
        int idx = 0;
        while(temp >0) {
            temp = temp / 10;
            idx++;
        }
        k = k % idx;
        if(k< 0){
            k = k + idx;
        }
        int dix = 1;
        int mul = 1;
        for (int i = 0;i<n;i++){
            if(i<=k){
                dix = dix * 10;
            }
            else{
                mul = mul * 10;
            }
        }
         int q = n / dix;
        int r = n %  dix;
        int s  = q * mul +r;
        System.out.println(s);


    }
}
