package recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithJump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<String> paths = new ArrayList<>();
        paths = getMazePathsWithJump(1, 1, n, m);
        System.out.println(paths);
    }
    public  static ArrayList<String> getMazePathsWithJump(int row, int col, int n, int m) {
       if( row == n && col == m) {
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
       }
        ArrayList<String> paths = new ArrayList<>();

        for(int  jump = 1; jump <= m - col; jump++){
            ArrayList<String> hpaths = new ArrayList<>();
            hpaths= getMazePathsWithJump(row, col + jump, n, m);
            for(String path :hpaths){
                paths.add("h" + jump + path);

            }

        }
        for(int jump =1; jump <= n - row; jump++){
            ArrayList<String> vpaths = new ArrayList<>();
            vpaths = getMazePathsWithJump(row + jump, col, n, m);
            for(String path : vpaths){
                paths.add("v" + jump + path);
            }
        }
        for(int jump =1; jump <= n - row && jump <= m - col; jump++){
            ArrayList<String> dpaths = new ArrayList<>();
            dpaths = getMazePathsWithJump( row + jump, col + jump, n, m);
            for(String path : dpaths){
                paths.add("d" + jump + path);
            }
        }
        return paths;
    }
}
