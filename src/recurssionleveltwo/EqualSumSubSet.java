package recurssionleveltwo;

import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumSubSet {
    public static void solution(int []arr,int vidx,int n,int k ,int[] subsetSum,int asf,ArrayList<ArrayList<Integer>>ans){
        if (vidx == arr.length) {
            if (asf == k) {
                boolean flag = true;
                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        flag = false;
                        break;

                    }
                }
                if (flag) {
                    for (ArrayList<Integer> patitions : ans) {
                        System.out.println(patitions + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }
            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i).size() > 0) {
                    ans.get(i).add(arr[vidx]);
                    subsetSum[i] += arr[vidx];
                    solution(arr, vidx, n, k, subsetSum, asf, ans);
                    ans.get(i).remove(ans.get(i).size() - 1);
                } else {
                    ans.get(i).add(arr[vidx]);
                    subsetSum[i] += arr[vidx];
                    solution(arr, vidx, n, k, subsetSum, asf + 1, ans);
                    ans.get(i).remove(ans.get(i).size() - 1);
                    break;
                }

            }
        }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
        sum += arr[i];
    }
    int k = sc.nextInt();
    if (k == 1) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "");
        }
        System.out.println("]");
        return;
    }
    if (k > n || sum % k != 0) {
        System.out.println("-1");
        return ;
    }
    int[] sunsetSum = new int[k];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        ans.add(new ArrayList<>());
    }
    solution(arr, 0, n, k, sunsetSum, 0, ans);
}
}



