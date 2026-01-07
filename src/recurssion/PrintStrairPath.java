package recurssion;

import java.util.Scanner;
//downward to upward staris paths
public class PrintStrairPath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printStairPaths(n, "");
    }
    public static void printStairPaths(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        if (n < 0) {
            return;
        }
        printStairPaths(n - 1, ans + "1");
        printStairPaths(n - 2, ans + "2");
        printStairPaths(n - 3, ans + "3");

    }
}

