package recurssionleveltwo;

import java.util.ArrayList;
import java.util.Scanner;
public class GoldMineTwo {
    public static void collect(int[][] arr,int i,int j,boolean[][] visited,ArrayList<Integer>bag ) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length ||  visited[i][j] ==true || arr[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        bag.add(arr[i][j]);
        collect( arr, i - 1,j,visited,bag);
        collect( arr, i ,j +1,visited,bag);
        collect( arr, i ,j -1,visited,bag);
        collect( arr, i +1,j,visited,bag);
    }

public static int maxi(int [][]arr){
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    int max = 0;
    for(int i = 0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if (arr[i][j] != 0 &&  !visited[i][j] ){
                ArrayList<Integer> bag = new ArrayList<>();
                collect(arr, i, j, visited, bag);
                int sum = 0;

                for( int val: bag){
                sum+=val;
                }
                if(sum>max){
                    max = sum;
                }
            }
        }
    }
    return max;
}






    public static  void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for(int i = 0; i < n;i++){
            for(int j= 0;j<m;j++){
                 arr[i][j] = sc.nextInt();
                 System.out.println(maxi(arr));
            }
        }
    }
}
