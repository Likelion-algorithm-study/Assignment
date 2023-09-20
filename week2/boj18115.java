package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj18115 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> orders = new LinkedList<>();
    Deque<Integer> cardStack = new LinkedList<>();

    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      orders.addLast(Integer.parseInt(stk.nextToken()));
    }
    for (int i = 1; i <= n; i++) {
      int order = orders.pollLast();
      if (order == 1) {
        cardStack.addFirst(i);
      } else if (order == 2) {
        int top = cardStack.pollFirst();
        cardStack.addFirst(i);
        cardStack.addFirst(top);
      } else {
        cardStack.addLast(i);
      }
    }
    while (!cardStack.isEmpty()) {
      stb.append(Integer.toString(cardStack.pollFirst()) + " ");
    }
    System.out.println(stb.toString());
  }
}
