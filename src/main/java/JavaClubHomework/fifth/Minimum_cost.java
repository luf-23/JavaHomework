package JavaClubHomework.fifth;

import java.util.Scanner;

public class Minimum_cost {
    public int minPathSum(int[][] grid) {
        int [][]dp = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        dp[0][0] = grid[0][0];
        for (int i=1;i<n;i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i=1;i<m;i++) dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]grid = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) grid[i][j] = sc.nextInt();
        }
        Minimum_cost min = new Minimum_cost();
        System.out.println(min.minPathSum(grid));
        sc.close();
    }
}
