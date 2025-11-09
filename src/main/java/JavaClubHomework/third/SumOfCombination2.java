package JavaClubHomework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfCombination2 {

    List<List<Integer>>ans = new ArrayList<>();
    List<Integer>now = new ArrayList<>();
    public void dfs(int start,int cnt,int target,int []candidates){
        if (cnt==target){
            List<Integer>tmp = new ArrayList<>();
            tmp = new ArrayList<>(now);
            tmp.sort((a,b)->a-b);
            if (!ans.contains(tmp)) ans.add(tmp);
            return;
        }
        if (start==candidates.length||cnt>target) return;
        for (int i=start;i<candidates.length;i++){
            if (i>start&&candidates[i]==candidates[i-1]) continue;
            now.add(candidates[i]);
            dfs(i+1,cnt+candidates[i],target,candidates);
            now.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        dfs(0,0,target,candidates);
        return ans;
    }
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  []candidates = new int[n];
        for (int i=0;i<candidates.length;i++) candidates[i] = sc.nextInt();
        int tar =sc.nextInt();
        List<List<Integer>>ans = new ArrayList<>();
        ans = new SumOfCombination2().combinationSum2(candidates,tar);
        for (List<Integer> x : ans) System.out.println(x);
    }
}
