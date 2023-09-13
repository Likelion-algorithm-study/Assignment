/* 문제 풀이 방법
 * 
 * deque를 사용한 이유 : 
 *  앞, 뒤로 삽입, 삭제가 일어나므로, LinkedList를 활용한 deque가 적절함 ( O(1) ).
 * 
 * 변수 이름
 *  줄의 최대 길이 : maxLength
 *  줄이 최대 길이일 때, 맨 뒷 사람 번호 최솟값 : lastPeople
 * 
 * 만약 앞자리가 1이면, 그 다음 수 p를 deque 맨 뒤에 넣는다.
 *  만약 줄의 길이(deque.size()) > maxLength이면
 *    maxLength = deque.size(), lastPeople = p
 *  만약 줄의 길이(deque.size()) == maxLength이면
 *    lastPeople = Math.min(lastPeople, p)
 * 
 * 만약 앞자리가 2이면, deque 맨 앞에 있는 수를 없앤다.
*/

/* 시간 복잡도
 * 
 *  deque 삽입 삭제 시간 : LinkedList이므로 O(1)
 *  deque 삽입 삭제 횟수 : 최대 N번
 *  --> O(N) 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj26042 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    int maxLength = 0, lastPeople = -1;
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int order = Integer.parseInt(stk.nextToken());
      if (order == 1) {
        int peopleNumber = Integer.parseInt(stk.nextToken());
        deque.addLast(peopleNumber);
        if (deque.size() > maxLength) {
          maxLength = deque.size();
          lastPeople = peopleNumber;
        } else if (deque.size() == maxLength) {
          lastPeople = Math.min(peopleNumber, lastPeople);
        }
      } else if (order == 2) {
        if (!deque.isEmpty()) {
          deque.pollFirst();
        }
      }
    }
    System.out.printf("%d %d\n", maxLength, lastPeople);
  }
}
