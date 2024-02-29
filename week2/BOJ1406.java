package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 에디터
public class BOJ1406 {

    private static Stack<String> leftStack = new Stack();
    private static Stack<String> rightStack = new Stack();

    // 커서 왼쪽 한칸 이동 (단, 커서 맨 앞이라면 무시)
    private static void L() {
        if (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }

    // 커서 오른쪽 한칸 이동 (단, 커서 맨 뒤라면 무시)
    private static void D() {
        if (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }

    // 커서 왼쪽 문자 삭제
    private static void B() {
        if (!leftStack.isEmpty()) {
            leftStack.remove(leftStack.size() - 1);
        }
    }

    // 커서 왼쪽 문자 추가
    private static void P(String s) {
        leftStack.push(s);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        for (char c : charArray) {
            leftStack.push(String.valueOf(c)); // leftStack <- a b c d
        }

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // P x, L, P y

            switch (st.nextToken()) {
                case "L":
                    L();
                    break;
                case "D":
                    D();
                    break;
                case "B":
                    B();
                    break;
                case "P":
                    P(st.nextToken());
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);

    }
}
