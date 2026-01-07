package recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> paths = getMaze(1, 1, n, m);
        System.out.println(paths);
    }

    public static ArrayList<String> getMaze(int r, int c, int dr, int dc) {

        if (r == dr && c == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> pathsh = new ArrayList<>();
        ArrayList<String> pathsv = new ArrayList<>();
        if (c < dc) {
            pathsh = getMaze(r, c + 1, dr, dc);
        }
        if (r < dr) {
            pathsv = getMaze(r + 1, c, dr, dc);
        }


        ArrayList<String> paths = new ArrayList<>();
        for (String path : pathsh) {
            paths.add("h" + path);
        }
        for (String path : pathsv) {
            paths.add("v" + path);
        }
        return paths;
    }
}

