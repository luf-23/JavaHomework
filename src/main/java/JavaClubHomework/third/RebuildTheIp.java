package JavaClubHomework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RebuildTheIp {
    List<String>ans = new ArrayList<>();
    List<String>now = new ArrayList<>();
    public void dfs(int start,String s){
        if (now.size()==4||start==s.length()){
            if (now.size()==4&&start==s.length()){
                int f = 1;
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<4;i++){
                    if (now.get(i).charAt(0)=='0'&&now.get(i).length()>1) f = 0;
                    int ret = 0;
                    for (int j=0;j<now.get(i).length();j++) ret = ret*10 + now.get(i).charAt(j)-'0';
                    if (ret>255) f = 0;
                    sb.append(now.get(i));
                    if (i!=3) sb.append(".");
                }
                if (f==1) ans.add(sb.toString());
            }
           return;
        }
        int j = start;
        int ret = s.charAt(j)-'0';
        while (j<s.length()&&ret<=255){
            now.add(s.substring(start,j+1));
            dfs(j+1,s);
            now.removeLast();
            ret = ret*10 + s.charAt(j)-'0';
            j++;
        }
    }
    public List<String> restoreIpAddresses(String s) {
        dfs(0,s);
        return ans;
    }
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String>ans = new ArrayList<>();
        ans= new RebuildTheIp().restoreIpAddresses(s);
        for (String x : ans) System.out.println(x);
    }

}
