package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 크리스마스 선물
// 모든 조건으로 분기하는게 좋은 것이 아니다. else 를 적절히 사용하자
public class BOJ14235 {

    private static final PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine()); // "0", "232"
            int firstNum = Integer.parseInt(st.nextToken()); // 0, 2

            if (firstNum == 0) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                for (int i=0; i<firstNum; i++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
