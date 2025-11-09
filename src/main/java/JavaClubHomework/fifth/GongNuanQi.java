package JavaClubHomework.fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class GongNuanQi {
    public int findRadius(int[] houses, int[] heaters) {
        int l,r,mid;
        l = -1;
        r = (int)1e9 + 5;
        sort(houses);
        while (l+1<r){
            mid = (l+r)/2;
           List<List<Integer>>now = new ArrayList<>();
           for (int i=0;i<heaters.length;i++){
               List<Integer>tmp = new ArrayList<>();
               tmp.add(heaters[i]-mid);
               tmp.add(heaters[i]+mid);
               now.add(tmp);
           }
           boolean flag = true;
           now.sort((a,b)->a.get(0)-b.get(0));
           int tail = 0;
           for (int i=0;i<houses.length;i++){
               while (tail<now.size()&&houses[i]<now.get(tail).get(0)) tail++;
               while (tail<now.size()&&houses[i]>now.get(tail).get(1)) tail++;
               if (tail>=now.size()||houses[i]<now.get(tail).get(0)||houses[i]>now.get(tail).get(1)) flag = false;
           }
           if (flag) r = mid;
           else l = mid;
        }
        return r;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []houses = new int[n];
        int []heaters = new int[m];
        for (int i=0;i<n;i++) houses[i] = sc.nextInt();
        for (int i=0;i<m;i++) heaters[i] = sc.nextInt();
        GongNuanQi s = new GongNuanQi();
        System.out.println(s.findRadius(houses,heaters));
    }
}
