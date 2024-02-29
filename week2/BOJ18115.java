package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 카드 놓기
public class BOJ18115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 기술1. 맨 위 카드를 빼내어 쌓는다.
        // 기술2. 위에서 두번째 카드를 빼내어 쌓는다.
        // 기술3. 맨 밑 카드를 빼내어 쌓는다.

        // "쌓는다" = 카드 위에 카드가 순차적으로 놓이는 방식이기 때문에 반복문을 돌릴 수 있다.
        // 기술을 역으로 정리하면 다음과 같다.

        // 기술1. 카드를 맨 위에 복귀시킨다.
        // 기술2. 카드를 위에서 두번째에 복귀시킨다.
        // 기술3. 카드를 맨 밑에 복귀시킨다.

        // 기술을 시행하는 순서도 반대로 해야 한다.
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        Deque<Integer> origin = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                origin.addFirst(i);
            } else if (num == 2) {
                int top = origin.removeFirst();
                origin.addFirst(i);
                origin.addFirst(top);
            } else {
                origin.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (origin.size() != 0) {
            sb.append(origin.removeFirst() + " ");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
