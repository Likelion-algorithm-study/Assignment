/* 문제 풀이 방법
 * 
 * deque 사용 이유 : 
 *  앞, 뒤로 삽입, 삭제, 조회가 일어나므로 LinkedList를 활용한 Deque 사용 ( O(1) )
 * 
 * 사용한 변수 : 
 *  order : 명령 종류를 나타냄
 * 
 * order 값에 따라서 적절하게 deque에서 삽입, 삭제, 조회 해주면 됨.
 * 주의할 점 : order가 비어있는 경우에 대한 예외가 있기 때문에 이 부분만 조심해주면 됨.
*/

/* 시간 복잡도 
 * isEmpty : O(1)
 * poll : O(1)
 * add : O(1)
 * peek : O(1)
 * --> O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int order = Integer.parseInt(stk.nextToken());
      switch (order) {
        case 1:
          int toPutFirst = Integer.parseInt(stk.nextToken());
          deque.addFirst(toPutFirst);
          break;
        case 2:
          int toPutLast = Integer.parseInt(stk.nextToken());
          deque.addLast(toPutLast);
          break;
        case 3:
          if (deque.isEmpty()) {
            stb.append("-1" + "\n");
          } else {
            stb.append(Integer.toString(deque.pollFirst()) + "\n");
          }
          break;
        case 4:
          if (deque.isEmpty()) {
            stb.append("-1" + "\n");
          } else {
            stb.append(Integer.toString(deque.pollLast()) + "\n");
          }
          break;
        case 5:
          stb.append(Integer.toString(deque.size()) + "\n");
          break;
        case 6:
          if (deque.isEmpty())
            stb.append("1" + "\n");
          else
            stb.append("0" + "\n");
          break;
        case 7:
          if (deque.isEmpty()) {
            stb.append("-1" + "\n");
          } else {
            stb.append(Integer.toString(deque.peekFirst()) + "\n");
          }
          break;
        case 8:
          if (deque.isEmpty()) {
            stb.append("-1" + "\n");
          } else {
            stb.append(Integer.toString(deque.peekLast()) + "\n");
          }
          break;
      }
    }
    System.out.println(stb);
  }
}