/* 문제 풀이 방법 : 입력값을 모두 stack에 넣은 뒤, stack에서 하나씩 빼면서 역순으로 최댓값 갱신 및 탐색 
 * 볼 수 있는 막대기의 최소높이는 이전에 있던 막대기 중 가장 긴 막대기이므로 최댓값을 사용하면 됨
 * 최댓값을 0으로 설정한 뒤, 최댓값보다 큰 값이 나오면 최댓값을 갱신하고 ans+=1
*/

/* 시간 복잡도 : O(N) */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj17608 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            stack.push(number);
        }
        int max = 0, ans = 0;
        while (!stack.empty()) {
            int current = stack.pop();
            if (max < current) {
                max = current;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
