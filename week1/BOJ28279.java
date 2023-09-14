package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ28279 {

    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder("");
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int firstToken = Integer.parseInt(st.nextToken());

            if(firstToken == 1) {
                Integer secondToken = Integer.parseInt(st.nextToken());
                _1X(secondToken);
            } else if(firstToken == 2) {
                Integer secondToken = Integer.parseInt(st.nextToken());
                _2X(secondToken);
            }
            else if (firstToken == 3) {
                sb.append(_3()).append("\n");
            }
            else if (firstToken == 4) {
                sb.append(_4()).append("\n");
            }
            else if (firstToken == 5) {
                sb.append(_5()).append("\n");
            }
            else if (firstToken == 6) {
                sb.append(_6()).append("\n");
            }
            else if (firstToken == 7) {
                sb.append(_7()).append("\n");
            }
            else if (firstToken == 8) {
                sb.append(_8()).append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }

    private static void _1X(Integer x) {
        deque.addFirst(x);
    }

    private static void _2X(Integer x) {
        deque.addLast(x);
    }

    private static Integer _3() {
        if(!deque.isEmpty()) {
            return deque.pollFirst();
        }
        return -1;
    }

    private static Integer _4() {
        if(!deque.isEmpty()) {
            return deque.pollLast();
        }
        return -1;
    }
    
    private static Integer _5() {
        return deque.size();
    }

    private static Integer _6() {
        if(deque.isEmpty()) return 1;
        return 0;
    }

    private static Integer _7() {
        if(!deque.isEmpty()) {
            return deque.peekFirst();
        }
        return -1;
    }

    private static Integer _8() {
        if(!deque.isEmpty()) {
            return deque.peekLast();
        }
        return -1;
    }
}
