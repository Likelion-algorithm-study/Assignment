package week1;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int testNum = sc.nextInt();
        for (int t = 0; t<testNum; t++) {
            String parenthesis = sc.next();
            for(int i=0; i<parenthesis.length(); i++){
                char flag = parenthesis.charAt(i);
                System.out.println("flag 변수: " + flag);
                if (stack.empty()) {
                    stack.push(flag);
                } else {
                    if (flag=='(') stack.push(flag);
                    else {
                        if (stack.peek()=='(') stack.pop();
                        else stack.push(flag);
                    }
                }
            }
            if (stack.size()!=0) System.out.println("NO");
            else System.out.println("YES");
            stack.clear();
        }
    }
}
