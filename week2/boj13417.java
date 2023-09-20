/* 문제 풀이 방법 */

/* 시간 복잡도 */

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj13417 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int i = 0; i < tc; i++) {
      Deque<Character> deque = new LinkedList<>();
      int len = Integer.parseInt(br.readLine());
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < len; j++) {
        char word = stk.nextToken().charAt(0);
        if (deque.isEmpty()) {
          deque.addFirst(word);
        } else if (deque.peekFirst() >= word) {
          deque.addFirst(word);
        } else if (deque.peekLast() < word) {
          deque.addLast(word);
        }
      }
      System.out.println(deque.toString());
    }
  }
}
