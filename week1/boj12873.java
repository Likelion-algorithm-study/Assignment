/* 문제 풀이 방법 
 * 
 * 솔직히 맨 위 4문제 중 가장 어려웠음
 * 
 * i<=5000 --> 게임 횟수 <= 1250억
 *  --> 무지성으로 돌리면 시간 초과 뜸.
 * 
 * 중복되는 연산을 없앤다.
 *  게임 횟수 = n, 남아있는 사람 = m
 *  게임 횟수 m+1번째에 시작 지점으로 돌아오므로 g = n%m
 *  게임 횟수 m번일 때, 시작 지점 바로 이전으로 돌아오므로 n%m==0이면 g=m
 *  
 * 이렇게 하고 연산 돌리면 시간 초과 안뜸.
*/

/* 시간 복잡도
 * 시작할 때 있는 사람이 n명일 때 n-1번 while문을 돌아간다.
 * 연산 횟수를 최대 n회로 줄였기 때문에 최대 연산 횟수는 1+2+3+...+n-1임.
 * 빅O 표기법이 가장 영향력 있는 항만 남기고, 계수 다 빼주기 때문에 시간복잡도는 O(N^2)임.
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj12873 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int stage = 1;
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      deque.addLast(i);
    }
    while (deque.size() > 1) {
      double gameTimes = Math.pow(stage, 3);
      gameTimes = gameTimes % deque.size();
      if (gameTimes == 0)
        gameTimes = deque.size();
      stage += 1;
      while (--gameTimes > 0) {
        deque.addLast(deque.pollFirst());
      }
      deque.pollFirst();
    }
    System.out.println(deque.pollLast());
    sc.close();
  }
}