package BOJ.week1._12873;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }
        for (int i = 1; i < n; i++) {
            int remain = queue.size();
            long index = ((long) i * i * i) % remain - 1;
            if (index < 0) {
                index = queue.size() - 1;
            }
            for (long j = 0; j < index; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
