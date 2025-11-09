package JavaClubHomework.second;

import java.util.*;

public class Main {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer>stk = new Stack<Integer>();
        for (int i=0;i<prices.length;i++){
            while (!stk.empty()&&prices[i]<=prices[stk.peek()]){
                prices[stk.peek()] -= prices[i];
                stk.pop();
            }
            stk.push(i);
        }
        return prices;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []prices = new int[n];
        for (int i=0;i<n;i++) prices[i] = sc.nextInt();
        prices = finalPrices(prices);
        for (int i=0;i<n;i++) System.out.print(String.format("%d ",prices[i]));

    }
}