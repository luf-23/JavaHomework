package JavaClubHomework.fifth;

import java.util.Scanner;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        s = ' ' + s;
        boolean [][]dp = new boolean[len+1][len+1];
        for (int i=1;i<=len;i++) dp[i][i] = true;
        for (int Len=2;Len<=len;Len++){
            for (int l=1;l+Len-1<=len;l++){
                if (Len==2){
                    dp[l][l+Len-1] = (s.charAt(l)==s.charAt(l+Len-1));
                }else{
                    dp[l][l+Len-1] = (s.charAt(l)==s.charAt(l+Len-1)&&dp[l+1][l+Len-2]);
                }
            }
        }
        int ans = 0;
        String ret = "";
        for (int Len=1;Len<=len;Len++){
            for (int l=1;l+Len-1<=len;l++){
                if (dp[l][l+Len-1]){
                    if (ans<Len){
                        ret = s.substring(l,l+Len);
                        ans = Len;
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        LongestPalindrome s = new LongestPalindrome();
        System.out.println(s.longestPalindrome(str));
    }
}
