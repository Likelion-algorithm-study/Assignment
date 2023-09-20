package week2;

import java.util.*;

public class BOJ14235 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int s = 0; s<n; s++){
            int a = sc.nextInt();
            if (a==0){
                if (priorityQueue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int gift_value = priorityQueue.poll();
                    System.out.println(gift_value);
                }
            } else {
                for (int i = 0; i<a; i++) {
                    int gift = sc.nextInt();
                    priorityQueue.add(gift);
                }
            }
        }
    }
}