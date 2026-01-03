import recurssion.DisplayArrReverse;
import recurssion.Displayarr;
import recurssion.MaxArray;
import recurssion.PrintZigZag;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner  scn = new Scanner(System.in);
        System.out.println("give the value of n");
        int n = scn.nextInt();
         int [] arr = new int[n];
         for (int i = 0; i < n; i++){
             arr[i] = scn.nextInt();
         }
       // Displayarr.displayArr(arr, 0);
       // DisplayArrReverse.displayArrReverse(arr , 0 );
       // PrintZigZag.pzz(n);
           //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        int  max = MaxArray.maxArray(arr,0);
        System.out.println("Maximum element in the array: " + max);
        }
    }

