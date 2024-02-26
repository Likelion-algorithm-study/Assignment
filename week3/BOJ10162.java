package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 전자레인지
public class BOJ10162 {

    private static final List<Integer> BUTTONS = List.of(300, 60, 10);
    private static List<Integer> answer = new ArrayList<>(3);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<3; i++) {
            int time = BUTTONS.get(i);

            if (T >= time) {
                int quotient = T / time;
                T -= time * quotient;
                sb.append(quotient).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        if (T % 10 != 0) {
            System.out.print(-1);
        } else {
            System.out.print(sb);
        }
    }
}
