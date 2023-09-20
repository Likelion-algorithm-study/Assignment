package week2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ2075 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int line = 0; line<n; line++){
            String[] nums = br.readLine().split(" ");
            for (int num = 0; num<n; num++) {
                int a = Integer.parseInt(nums[num]);
                priorityQueue.add(a);
            }
        }
        for (int i = 0; i<n-1; i++)
            priorityQueue.poll();
        bw.write(priorityQueue.peek().toString());
        bw.flush();
        bw.close();

    }
}
