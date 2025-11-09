package JavaClubHomework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfCombination {
    List<List<Integer>>ans = new ArrayList<>();
    List<Integer>now = new ArrayList<>();
    public void dfs(int start,int cnt,int target,int []candidates){
        if (start==candidates.length||cnt>target) return;
        if (cnt==target){
            ans.add(new ArrayList<>(now));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            now.add(candidates[i]);
            dfs(i,cnt+candidates[i],target,candidates);
            now.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,0,target,candidates);
        return ans;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []candidates = new int[n];
        for (int i=0;i<n;i++) candidates[i] = sc.nextInt();
        int tar = sc.nextInt();
        List<List<Integer>>ans = new ArrayList<>();
        ans = new SumOfCombination().combinationSum(candidates,tar);
        for (List<Integer> x : ans){
            for (int item : x){
                System.out.print(String.format("%d ",item));
            }
            System.out.println();
        }
    }
}
