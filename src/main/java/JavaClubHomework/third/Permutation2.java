package JavaClubHomework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation2 {
    List<List<Integer>>ans = new ArrayList<>();
    List<Integer>now = new ArrayList<>();
    public void dfs(int step,int []nums,int []vis){
        if (step==nums.length){
            List<Integer>tmp = new ArrayList<>(now);
            if (!ans.contains(tmp)) ans.add(new ArrayList<>(now));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (vis[i]==0){
                vis[i] = 1;
                now.add(nums[i]);
                dfs(step+1,nums,vis);
                now.removeLast();
                vis[i] = 0;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(0,nums,new int[nums.length]);
        return ans;
    }
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for (int i=0;i<nums.length;i++) nums[i] = sc.nextInt();
        List<List<Integer>>ans = new ArrayList<>(new Permutation2().permuteUnique(nums));
        for (List<Integer> x : ans) System.out.println(x);
    }
}
