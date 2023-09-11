package BOJ.week1._9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            System.out.println(solution(input));
        }
    }

    private static String solution(String input) {
        Stack<String> stack = new Stack<>();
        String[] arr = input.split("");
        for (String s : arr) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

}
