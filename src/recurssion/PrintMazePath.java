package recurssion;

import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        printMazePaths(1, 1, n, m, "");
    }
    public static void printMazePaths(int x, int y, int n, int m, String path) {
        if (x > n || y > m) {
            return;
        }
        if (x == n && y == m) {
            System.out.println(path);
            return;
        }

            printMazePaths(x + 1, y, n, m, path + "h");
            printMazePaths(x, y + 1, n, m, path + "v");
        }
    }

