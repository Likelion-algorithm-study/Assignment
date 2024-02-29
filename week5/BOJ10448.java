package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 유레카 이론
public class BOJ10448 {

    // K 는 1000을 넘지 않는다
    // K 를 최대 3개의 삼각수의 합으로 표현된다 했으므로
    // 삼각수 또한 1000을 넘지 않아야 한다

    private static final List<Integer> NATURAL_NUM_LIST = new ArrayList<>(1000);
    private static final List<Integer> TRI_NUM_LIST = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            NATURAL_NUM_LIST.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= 44; i++) {
            TRI_NUM_LIST.add(i * (i + 1) / 2);
        }

        System.out.println(eureka());
    }

    private static StringBuilder eureka() {
        for (int N : NATURAL_NUM_LIST) {

            int limit = TRI_NUM_LIST.size() - 1;
            boolean flag = false;

            middleLoop:
            for (int i = 0; i <= limit; i++) {
                for (int j = 0; j <= limit; j++) {
                    for (int k = 0; k <= limit; k++) {

                        if (N == TRI_NUM_LIST.get(i) + TRI_NUM_LIST.get(j) + TRI_NUM_LIST.get(k)) { //
                            sb.append(1 + "\n");
                            flag = true;
                            break middleLoop;
                        }
                    }
                }
            }
            if (!flag) { // 3개의 삼각수의 합으로 자연수를 만들 수 없다면
                sb.append(0 + "\n");
            }

        }
        return sb;
    }
}
