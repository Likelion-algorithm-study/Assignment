package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj19638 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int giant = Integer.parseInt(stk.nextToken());
    int centi = Integer.parseInt(stk.nextToken());
    int hitTimes = Integer.parseInt(stk.nextToken());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    int cnt = 0;
    for (int i = 0; i < giant; i++) {
      priorityQueue.add(Integer.parseInt(br.readLine()));
    }
    while (hitTimes > 0) {
      int largest = priorityQueue.peek();
      if (largest < centi || largest == 1) {
        break;
      }
      priorityQueue.poll();
      priorityQueue.add(largest / 2);
      hitTimes -= 1;
      cnt++;
    }
    int maxValue = priorityQueue.peek();
    if (centi <= maxValue) {
      System.out.println("NO");
      System.out.println(maxValue);
    } else {
      System.out.println("YES");
      System.out.println(cnt);
    }
  }
}
