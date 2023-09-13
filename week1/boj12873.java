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