package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 반전 요세푸스
public class BOJ20301 {

    // (7,3,4)-반전 요세푸스 순열
    //     1 2 3 4 5 6 7
    // [1] 1 2   4 5 6 7 -> 3
    // [2] 1 2   4 5   7 -> 3 6
    // [3] 1     4 5   7 -> 3 6 2
    // [4] 1     4 5     -> 3 6 2 7
    // [1]       4 5     -> 3 6 2 7 1
    // [2]       4       -> 3 6 2 7 1 5
    // [3]               -> 3 6 2 7 1 5 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        Queue<Integer> answer = new LinkedList<>();
        boolean clockwise = true; // 처음에는 시계방향으로 시작
        while (!deque.isEmpty()) {

            if (clockwise) { // 시계방향 (요세푸스)
                for (int i = 0; i < k - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
                answer.add(deque.removeFirst());
            }

            if (!clockwise) { // 반시계방향 (반전 요세푸스)
                for (int i = 0; i < k - 1; i++) {
                    deque.addFirst(deque.removeLast());
                }
                answer.add(deque.removeLast());
            }

            if (answer.size() % m == 0) {
                clockwise = !clockwise; // M명이 제거될 때마다 방향 변경
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}