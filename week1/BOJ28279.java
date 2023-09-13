import java.io.BufferedReader;
import java.io.BufferedWriter;
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