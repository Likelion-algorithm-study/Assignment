package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 키로거
public class BOJ5397 {

    private static final Stack<Character> LEFT_STACK = new Stack();
    private static final Stack<Character> RIGHT_STACK = new Stack();
    private static StringBuilder sb;

    private static void left() {
        if (!LEFT_STACK.isEmpty()) {
            RIGHT_STACK.push(LEFT_STACK.pop());
        }
    }

    private static void right() {
        if (!RIGHT_STACK.isEmpty()) {
            LEFT_STACK.push(RIGHT_STACK.pop());
        }
    }

    private static void delete() {
        if (!LEFT_STACK.isEmpty()) {
            LEFT_STACK.remove(LEFT_STACK.size()-1);
        }
    }

    private static void enter(char c) {
        LEFT_STACK.push(c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            sb = new StringBuilder();
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                switch (c) {
                    case '<':
                        left();
                        break;
                    case '>':
                        right();
                        break;
                    case '-':
                        delete();
                        break;
                    default:
                        enter(c);
                }
            }
            while (!LEFT_STACK.isEmpty()) {
                RIGHT_STACK.push(LEFT_STACK.pop());
            }
            while (!RIGHT_STACK.isEmpty()) {
                sb.append(RIGHT_STACK.pop());
            }
            System.out.println(sb);
        }
    }
}
