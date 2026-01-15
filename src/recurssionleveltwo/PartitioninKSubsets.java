package recurssionleveltwo;

import java.util.ArrayList;
import java.util.Scanner;

public class PartitioninKSubsets {
   static int count = 1;
    public static void  solution(int i, int n, int k, int asf, ArrayList<ArrayList<Integer>> ans){
if(i >n){ // check till i is greater then n
    if(asf == k){//check no of set are eqal to no of sets
        count++;
        System.out.println(count+"");
        for(ArrayList<Integer> set : ans){
            System.out.println(ans+"");
        }
        System.out.println();
    }
    return;
}

        for(int j = 0;j<ans.size();j++){
    if (ans.get(j).size() >0){
        ans.get(j).add(i);
        solution(i,n,k,asf,ans);
        ans.get(j).remove(ans.get(j).size() - 1);//remove the vale during backtracking
    }else{
        ans.get(j).add(i);
        solution(i,n,k,asf +1,ans);
        ans.get(j).remove(ans.get(j).size() - 1);
        break;
    }
      }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i <k;i++){
            ans.add(new ArrayList<>());
        }
        solution(1,n,k,0,ans);
    }
}
