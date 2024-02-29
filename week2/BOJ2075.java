package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// N번째 큰 수
public class BOJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int tc = Integer.parseInt(br.readLine());
        int dup = tc;

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        while (dup-- > 1) {
            pq.poll();
        }

        System.out.println(pq.poll());

    }
}
