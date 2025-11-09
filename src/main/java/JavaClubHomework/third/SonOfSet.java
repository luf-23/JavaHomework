package JavaClubHomework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SonOfSet {
    List<List<Integer>>ans = new ArrayList<>();
    List<Integer>now = new ArrayList<>();
    public void dfs(int step,int []nums){
        if (step==nums.length){
            List<Integer>tmp = new ArrayList<>(now);
            tmp.sort((a,b)->a-b);
            if (!ans.contains(tmp)) ans.add(new ArrayList<>(tmp));
            return;
        }
        dfs(step+1,nums);
        now.add(nums[step]);
        dfs(step+1,nums);
        now.removeLast();
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for (int i=0;i<nums.length;i++) nums[i] = sc.nextInt();
        List<List<Integer>>ans = new ArrayList<>(new SonOfSet().subsetsWithDup(nums));
        for (List<Integer> x : ans) System.out.println(x);
    }
}
