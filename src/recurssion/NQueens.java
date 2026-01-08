package recurssion;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        printNQueens(arr, "", 0);


    }

    private static void printNQueens(int[][] board, String s, int row) {
        if (row == board.length) {
            System.out.println(s + ".");
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col) == true) {
                board[row][col] = 1;
                printNQueens(board, s + row + "-" + col + ", ", row + 1);
                board[row][col] = 0;
            }

        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        //check vertical up}
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        //check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        //check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
