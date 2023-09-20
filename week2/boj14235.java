/* 문제 풀이 방법 
 * PriorityQueue 사용한 이유
 *  아이들에게 선물을 줄 때 가장 가치가 높은 선물을 줘야 하므로 기본적으로 정렬되어 있는 자료구조를 사용하는 것이 좋음.
 * 
 * 만약 입력이 0이면 : isEmpty()가 아니라면 peek에 있는 값을 반환
 * 만약 입력이 양수 n이라면 : n회 값을 입력받아서 우선순위 큐에 넣는다.
*/

/* 시간 복잡도 ( 솔직히 시간 초과 뜨는지만 보면 되서 정확하게 구하는건 저도 잘 모릅니다. )
 * 
 * 우선순위 큐의 삽입/삭제 시간은 log_2 N이다 ( 힙이니까 당연하죠? )
 * N<=5000, A<=100이므로 시간복잡도 = O(NA * log_2 N)
 * 
 * 끽해야 500만쯤? 돌겠다
 * (제한 시간 2초면 2억번 이내로 돌면 됨)
*/

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj14235 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stk.nextToken());
      if (a == 0) {
        if (pQueue.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(pQueue.poll());
        }
      } else {
        for (int j = 0; j < a; j++) {
          int price = Integer.parseInt(stk.nextToken());
          pQueue.add(price);
        }
      }
    }
  }
}
