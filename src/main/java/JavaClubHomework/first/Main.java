package JavaClubHomework.first;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int []num = new int[100];
//        int pos = 0;
//        int ans = 0;
//        for (int i=0;i<str.length();i++){
//            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
//                int now = 0;
//                int j = i;
//                while (j<str.length()&&str.charAt(j)>='0'&&str.charAt(j)<='9'){
//                    now = now*10 + str.charAt(j)-'0';
//                    j++;
//                }
//                num[++pos] = now;
//                i = j;
//            }else if (str.charAt(i)!='.'&&str.charAt(i)!='@'){
//                int y = num[pos];
//                --pos;
//                int x = num[pos];
//                --pos;
//                int t = 0;
//                if (str.charAt(i)=='+') t = x + y;
//                else if (str.charAt(i)=='-') t = x - y;
//                else if (str.charAt(i)=='*') t = x * y;
//                else if (str.charAt(i)=='/') t = x / y;
//                num[++pos] = t;
//            }
//        }
//        System.out.println(num[pos]);
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> stk = new Stack<Integer>();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                int now = 0;
                int j = i;
                while (j<str.length()&&str.charAt(j)>='0'&&str.charAt(j)<='9'){
                    now = now*10 + str.charAt(j)-'0';
                    j++;
                }
                stk.push(now);
                i = j;
            }else if (str.charAt(i)!='.'&&str.charAt(i)!='@'){
                Integer y = (Integer) stk.peek();
                stk.pop();
                Integer x = (Integer) stk.peek();
                stk.pop();
                int t = 0;
                if (str.charAt(i)=='+') t = x + y;
                else if (str.charAt(i)=='-') t = x - y;
                else if (str.charAt(i)=='*') t = x * y;
                else if (str.charAt(i)=='/') t = x / y;
                stk.push(t);
            }
        }
        System.out.println(stk.peek());
    }
}