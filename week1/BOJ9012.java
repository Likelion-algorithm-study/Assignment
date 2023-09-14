package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        Stack<String> leftParenthesisQueue = new Stack<>();

        for (int i = 0; i < testCase; i++) {
            String answer = "YES";
            String[] strArr = br.readLine().split("");
            for(String str : strArr) {
                if(str.equals("(")) {
                    leftParenthesisQueue.add(str);
                } else if (str.equals(")")) {
                    if(leftParenthesisQueue.contains("(")) {
                        leftParenthesisQueue.pop();
                    } else if (!leftParenthesisQueue.contains("(")) {
                        answer = "NO";
                    }
                }
            }
            if(!leftParenthesisQueue.empty()) answer = "NO";
            leftParenthesisQueue.clear();

            System.out.println(answer);
        }
    }
}
