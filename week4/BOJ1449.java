package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 수리공 항승
public class BOJ1449 {

    private static StringTokenizer st;
    private static final List<Integer> HOLES = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int holeNum = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < holeNum; i++) {
            HOLES.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(HOLES);

        int answer = 1;
        int holeStart = HOLES.get(0);

        for (int i = 1; i < holeNum; i++) {
            int hole = HOLES.get(i);  // 현재 구멍
            int length = hole - holeStart + 1; // 기준 구멍부터 현재 구멍까지의 총길이 (1cm 여분 포함)

            if (tapeLength < length) { // 테이프로 커버 불가능하다면
                holeStart = hole; // 현재 구멍이 다음을 위한 기준 구멍이 되어야 하고
                answer++; // 테이프를 1개 사용하는 것으로 인지
            }
        }

        System.out.print(answer);
    }
}
