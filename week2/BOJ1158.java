package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 순열
public class BOJ1158 {

    // (7,3)-요세푸스 순열
    // 1 2 3 4 5 6 7
    // 1 2   4 5 6 7 -> 3
    // 1 2   4 5   7 -> 3 6
    // 1     4 5   7 -> 3 6 2
    // 1     4 5     -> 3 6 2 7
    // 1     4       -> 3 6 2 7 5
    //       4       -> 3 6 2 7 5 1
    //               -> 3 6 2 7 5 1 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("<");

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}
