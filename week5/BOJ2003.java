package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 수들의 합 2
public class BOJ2003 {

    private static final List<Integer> LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 ~ 10,000
        int M = Integer.parseInt(st.nextToken()); // 1 ~ 300,000,000

        st = new StringTokenizer(br.readLine());

        while (N-- > 0) {
            LIST.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 0; i < LIST.size(); i++) { // 10,000
            int start = LIST.get(i);

            if (start == M) {
                answer++;
                continue;
            }

            for (int j = i + 1; j < LIST.size(); j++) { // 10,000

                start += LIST.get(j);

                if (start == M) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
