package JavaClubHomework.fifth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int []sum = new int[n+1];
        for (int i=1;i<=n;i++) sum[i] = sum[i-1] + nums[i-1];
        boolean ok = false;
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,0);
        for (int i=1;i<=n;i++){
            int now = sum[i]%k;
            //System.out.print(now+" ");
            if (mp.containsKey(now)&&i-mp.get(now)>=2) ok = true;
            if (!mp.containsKey(now)) mp.put(now,i);
        }
        return ok;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []nums = new int[n];
        for (int i=0;i<n;i++) nums[i] = sc.nextInt();
        CheckSubarraySum s = new CheckSubarraySum();
        System.out.println(s.checkSubarraySum(nums,k));
    }
}
