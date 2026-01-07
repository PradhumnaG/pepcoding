package recurssion;

import java.util.Scanner;

public class TargetSumSubset
{
    public  static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i< arr.length;i++){
            arr[i] = in.nextInt();
        }
            int target = in.nextInt();
            printTargetSumSubset(arr,0,"",0,target);
    }
    public  static void printTargetSumSubset(int[] arr,int start,String set,int sum,int target)
    {
        if(start==arr.length){
            if(sum==target){
                System.out.println(sum + ".");
            }
            return;
        }
        printTargetSumSubset(arr,start+1,set+arr[start]+",",sum+arr[start],target);
        printTargetSumSubset(arr,start+1,set,sum,target);
    }
}
