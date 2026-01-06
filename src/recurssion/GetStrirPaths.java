package recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStrirPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> base = new ArrayList<>();
        System.out.println(base);
    }

    public static ArrayList<String> getStrirPaths(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if (n < 0) {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> path1 = getStrirPaths(n - 1);
        ArrayList<String> path2 = getStrirPaths(n - 2);
        ArrayList<String> path3 = getStrirPaths(n - 3);
        ArrayList<String> myres = new ArrayList<>();
        for (String p1 : path1) {
            myres.add("1" + p1);
        }
        for (String p2 : path2) {
            myres.add("2" + p2);
        }
        for (String p3 : path3) {
            myres.add("3" + p3);
        }
        return myres;
    }
}
