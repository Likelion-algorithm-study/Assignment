/* 문제 풀이 방법 
 * 
 * PriorityQueue 사용한 이유
 *  n 번째 큰 수를 구하면 되니까, 우선순위 큐의 peek 값이 n 번째로 큰 수가 되도록 조정하면 됨.
 * 
 *  우선순위 큐 안의 값들을 오름차순으로 배열되게 하고, 우선순위 큐의 원소 갯수가 n을 넘지 않도록 poll을 해준다.
 *  --> 로직이 끝났을 때, peek 값이 n번째로 큰 수가 된다.
 * 
*/

/* 시간 복잡도
 * 
 * 우선순위 큐의 삽입 / 삭제의 시간 복잡도는 O(log_2 N)
 * 표의 가로 길이를 n이라고 할 때, 시간 복잡도 = O(N^2 * log_2 N)
 * 
*/

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj2075 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        pq.add(Integer.parseInt(stk.nextToken()));
        if (pq.size() > n)
          pq.poll();
      }
    }
    System.out.println(pq.poll());
  }
}
