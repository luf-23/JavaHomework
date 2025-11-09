# 第一次作业报告

##### 姓名：杨志军

##### 班级：软件2302班

+++

* ***[和的平方和平方的和的差值](https://www.luogu.com.cn/problem/U265022)***

**思路：O(n)算出平方的和，O(1)算出和的平方**

```java
public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum1 = 0;
        long sum2 = 0;
        for (int i=1;i<=n;i++) sum1 += (long)i*i;
        sum2 = n*n*(n+1)*(n+1)/4;
        System.out.println(sum2-sum1);
    }
```

* ***[序列中的最大乘积](https://www.luogu.com.cn/problem/U265129)***

**思路：暴力枚举起点，然后取长度为n的字串，再与最大值进行比较更新，时间复杂度O(n*len)**

```java
public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String str;
        int len,n;
        len = Integer.parseInt(sc.nextLine());
        str = sc.nextLine();
        n = sc.nextInt();
        long ans = 0;
        for (int i=0;i+n-1<str.length();i++){
            long tmp = 1;
            for (int j=i;j<=i+n-1;j++) tmp *= (str.charAt(j)-'0');
            ans = Math.max(ans,tmp);
        }
        System.out.println(ans);
    }
```

* ***[格子路径](https://www.luogu.com.cn/problem/U265594)***

**思路1：组合数学直接$C_{n+m}^{n}$或$C_{n+m}^{m}$即可O(1)得出答案，复杂度O(1)**

**思路2：利用动态规划写，定义数组`dp[i][j]`表示走到第i行第j列的方案数，复杂度O(nm)**

```java
public class Main {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        ++m;
        ++n;
        long [][]dp = new long[n+1][m+1];
        for (int i=1;i<=m;i++) dp[1][i] = 1;
        for (int i=1;i<=n;i++) dp[i][1] = 1;
        for (int i=2;i<=n;i++){
            for (int j=2;j<=m;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[n][m]);
    }
}
```

* ***[阶乘各位数的和](https://www.luogu.com.cn/problem/U273769)***

**思路：暴力即可，O(n)复杂度**

```java
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger now = BigInteger.valueOf(1);
        for (int i=1;i<=n;i++){
            now = now.multiply(BigInteger.valueOf(i));
        }
        int ans = 0;
        String str = String.valueOf(now);
        for (int i=0;i<str.length();i++) ans += str.charAt(i)-'0';
        System.out.println(ans);
    }
}

```

* ***[字典排序](https://www.luogu.com.cn/problem/U273777)***

**思路1：暴力dfs，执行n次即为答案，复杂度O(`K!T`)，70分**

**思路2：采用离线方法，先把输入都存起来，最后一起按顺序输出，时间复杂度O(K!),空间复杂度O(KT)**

```java
package edu.wust;
import java.util.*;
public class Main {
    int cnt;
    int []now = new int[10];
    int []ans = new int[10];
    int []vis = new int[10];
    HashMap<Integer,List<Integer>>mp = new HashMap<>();
    List<Integer>query = new ArrayList<>();
    public void dfs(int step){
        if (step==10){
            ++cnt;
            if (mp.containsKey(cnt)){
                List<Integer>tmp = new ArrayList<>();
                for (int i=0;i<10;i++) tmp.add(now[i]);
                mp.put(cnt,tmp);
            }
            return;
        }
        for (int i=0;i<10;i++){
            if (vis[i]==0){
                vis[i] = 1;
                now[step] = i;
                dfs(step+1);
                vis[i] = 0;
            }
        }
    }
    public void solve(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n;
            n = sc.nextInt();
            query.add(n);
            mp.put(n,new ArrayList<>());
        }
        dfs(0);
        int mx = 1;
        for (int i=1;i<=10;i++) mx *= i;
        for (int n : query) {
            if (n <= mx){
                for (int x : mp.get(n)) System.out.print(x);
                System.out.println();
            }
            else System.out.println("WustJavaClub");
        }
    }
    public static void main(String []args) {
        new Main().solve();
    }
}
```

* ***[用最少数量的键引爆气球](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/)***

**思路：贪心，先按区间右端点从小到大排序，不难发现每次选区间的右端点可以覆盖尽可能多的区间，利用双指针实现，时间复杂度O(n)**

```java
public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->a[1]-b[1]);
        int ans = 0;
        for (int i=0;i<points.length;i++){
            int j = i;
            int t = points[i][1];
            while (j<points.length&&points[j][0]<=t&&points[j][1]>=t){
                j++;
            }
            ans++;
            i = j-1;
        }
        return ans;
    }
```

* ***[分发饼干](https://leetcode.cn/problems/assign-cookies/description/)***

**思路1：先把孩子的期望值数组和饼干数组从小到大排序，然后枚举每个孩子，再选择第一个大于该孩子期望值的饼干，如果没有，退出循环，如果有，答案加一，下一个孩子找期望值的时候从选中的饼干后面去选择，时间复杂度O(nlogn+mlogm)**

```java
public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int tail = 0;
        for (int i=0;i<g.length;i++){
            for (int j=tail;j<s.length;j++){
                if (s[j]>=g[i]){
                    ans++;
                    tail = j+1;
                    break;
                }
            }
        }
        return ans;
    }
```

* ***[盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/)***

**思路1：暴力枚举选中的两条直线，答案即为`(j-i) * min(height[i],height[j])`，时间复杂度O($n^2$)**

**思路2：考虑到高度范围比较小，可以开h个数组，数组`st[h[i]]`存放高度大于等于`h[i]`的所有下标，由贪心思路可知在一个高度下下标差值越大答案越大，所以只用考虑每个数组的首尾元素，时间复杂度O(nh)**

```java
public int maxArea(int[] height) {
        int mx = 0;
        for (int i=0;i<height.length;i++) mx = Math.max(mx,height[i]);
        List<List<Integer>>st = new ArrayList<>();
        for (int i=0;i<=mx;i++) st.add(new ArrayList<>());
        for (int i=0;i<height.length;i++){
            for (int j=0;j<=height[i];j++){
                st.get(j).add(i);
            }
        }
        int ans = 0;
        for (int i=0;i<height.length;i++){
            int ret1 = Math.abs(i-st.get(height[i]).getFirst())*height[i];
            int ret2 = Math.abs(i-st.get(height[i]).getLast())*height[i];
            ans = Math.max(ans,Math.max(ret1,ret2));
        }
        return ans;
    }
```

**思路3：双指针，开始时指向左右端点，由贪心思路肯定是移动两边h较小的一边，然后逐步更新答案**

```java
public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length-1;
        while (l<r){
            ans = Math.max(ans,(r-l)*Math.min(height[l],height[r]));
            if (height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
```

