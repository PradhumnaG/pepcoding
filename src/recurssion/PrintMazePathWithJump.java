package recurssion;

import java.util.Scanner;

public class PrintMazePathWithJump {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        printMazePathsWithJump(1, 1, n, m, "");
    }

    public static void printMazePathsWithJump(int x, int y, int n, int m, String path) {
        for (int jump = 1; jump <= n - x; jump++) {
            printMazePathsWithJump(x + jump, y, n, m, path + "h" + jump);
        }
        for (int jump = 1; jump <= m - y; jump++) {
            printMazePathsWithJump(x, y + jump, n, m, path + "v" + jump);
        }
        for (int jump = 1; jump <= n - x && jump <= m - y; jump++) {
            printMazePathsWithJump(x + jump, y + jump, n, m, path + "d" + jump);
        }
        if (x == n && y == m) {
            System.out.println(path);
            return;
        }
    }
}
