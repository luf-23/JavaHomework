package JavaClubHomework.fifth;

import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Collections.binarySearch;

public class SumOfThreeDigits {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        HashSet<List<Integer>>st = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int z = -nums[i]-nums[j];
                int l,r,mid;
                l = j;
                r = nums.length-1;
                while (l+1<r){
                    mid = (l+r)/2;
                    if (z>nums[mid]) l = mid;
                    else if (z<=nums[mid]) r = mid;
                }
                if (nums[r]==z){
                    List<Integer>tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(z);
                    tmp.sort((a,b)->a-b);
                    st.add(tmp);
                }
            }
        }
        List<List<Integer>>ans = new ArrayList<>(st);
        return ans;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for (int i=0;i<n;i++) nums[i] = sc.nextInt();
        SumOfThreeDigits s = new SumOfThreeDigits();
        List<List<Integer>>ans = s.threeSum(nums);
        for (List<Integer>tmp:ans){
            for (int i:tmp) System.out.print(i+" ");
            System.out.println();
        }
    }
}
