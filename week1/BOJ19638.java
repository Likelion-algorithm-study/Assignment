package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int giantNum = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int hammerLimit = Integer.parseInt(st.nextToken());

        // 우선순위큐 채우기
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < giantNum; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 해머 사용
        int hammerUse = 0;
        for (int i = 0; i < hammerLimit; i++) {
            if ((pq.peek() < centiHeight) || (pq.peek() == 1)) break;

            pq.add(pq.poll() / 2);
            hammerUse++;
        }

        // 정답 만들기
        String answer = "NO";
        if (pq.peek() > centiHeight) answer = "YES";

        StringBuilder sb = new StringBuilder(answer);
        sb.append("\n").append(answer.equals("YES") ? hammerUse : pq.peek());
        System.out.println(sb);
    }
}
