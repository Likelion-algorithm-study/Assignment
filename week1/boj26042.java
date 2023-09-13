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
