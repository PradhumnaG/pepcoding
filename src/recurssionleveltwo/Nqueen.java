package recurssionleveltwo;

import java.util.Scanner;

public class Nqueen {
    public static void solve(Boolean[][] board,int row, Boolean [] cols,Boolean[] ndig, Boolean[] rdig,String asf){
        for(int col = 0; col < board[0].length;col++){
            if(cols[col] == false && ndig [row + col] == false && rdig[ row - col + board.length-1] == false){
                board[row][col] = true;
                cols[col] = true;
                ndig[row +col] = true;
                rdig[ row - col + board.length -1] = true;
                solve(board,row +1, cols,ndig,rdig,asf  +row + "-"+ col+",");
                board[row][col] = false;
                cols[col] = false;
                ndig[row + col] = false;
                rdig[row - col +board.length -1] =false;

            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Boolean[][]  board = new Boolean[n][n];
        Boolean[] cols = new Boolean[n];
        Boolean [] ndig = new Boolean[2 * n - 1];
        Boolean [] rdig = new Boolean[2 * n - 1];
        solve(board,0,cols,ndig,rdig,"");
    }
}
