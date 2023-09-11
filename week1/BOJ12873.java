package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ12873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++) {
            que.add(i);
        }
        for (int i = 1; i<n; i++){
            long index = que.size();
            if ((long)i*i*i % que.size()!=0) {
                index = (long)i*i*i % que.size();
            }
            for (int j = 1; j < index; j++) {
                que.add(que.poll());
            }
            que.poll();
        }
        System.out.println(que.peek());
    }
}
