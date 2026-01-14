package recurssionleveltwo;

import java.util.Scanner;

public class SudukuB {
    public static void display(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.println(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solveSuduku(int[][] board,int i,int j ){
        int ni = 0;
        int nj= 0;
        if( j == board[0].length -1){
            ni = i + 1;
            nj = 0;
        }
        else {
            ni = 0;
            nj = j + 1;
        }
        if(board[i][j] != 0){
            solveSuduku(board,ni,nj);
        }else{
            for (int po = 1;po<=9;po++){
                if (isValid(board,i,j,po) == true){
                    board[i][j] = po;
                    solveSuduku(board,ni,nj);
                    board[i][j] = 0;
                }
            }
        }
    }
    public static boolean isValid(int [][] board,int x,int y,int po){
        for(int j = 0;j<board[0].length;j++){
            if(board[x][j] == po)
            {
                return false;
            }
        }
        for(  int i= 0;i<board.length;i++){
            if(board[i][y] == po)
            {
                return false;
            }
        }
   int smi = x/3 * 3;
   int smj = y/3 * 3;
   for(int i = 0;i<3;i++){
       for(int j = 0;j<3;j++){
           if(board[smi][smj] == po){
               return false;
           }
       }
   }
   return true;
 }


    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int [9][9];
        for(int i= 0;i<9;i++){
            for(int j= 0;j<9;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        solveSuduku(arr,0,0);
    }
}
