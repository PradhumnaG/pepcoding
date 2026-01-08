package recurssion;

import java.util.Scanner;

public class Knightour {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] chess = new int[n][n];
        printKnightTour(chess, r, c, 1);
    }
    public  static void printKnightTour(int[][] chess, int r, int c, int sum){
        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]>0){
            return;
        } else if(sum ==chess.length* chess.length){
            chess[r][c] = sum;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = sum;
        printKnightTour(chess,r-2,c+1,sum+1);
        printKnightTour(chess,r-1,c+2,sum+1);
        printKnightTour(chess,r+1,c+2,sum+1);
        printKnightTour(chess,r+2,c+1,sum+1);
        printKnightTour(chess,r+2,c-1,sum+1);
        printKnightTour(chess,r+1,c-2,sum+1);
        printKnightTour(chess,r-1,c-2,sum+1);
        printKnightTour(chess,r-2,c-1,sum+1);


    }
    public  static void displayBoard(int[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
