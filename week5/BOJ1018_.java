package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
public class BOJ1018_ {

    private static Boolean[][] BOARD_NXM;
    private static final Boolean[][] BOARD_8X8 = new Boolean[8][8];
    private static final List<Integer> PAINTS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행. 8 ~ 50
        int M = Integer.parseInt(st.nextToken()); // 열. 8 ~ 50

        BOARD_NXM = new Boolean[N][M];

        // 제시된 체어판 준비
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                BOARD_NXM[i][j] = convert(split[j]);
            }
        }

        // 8 x 8 이 유효한 기준점 설정하기
        for (int i = 0; i <= N - 8; i++) { // 10 - 8 = 2
            for (int j = 0; j <= M - 8; j++) { // 13 - 8 = 5

                // (i,j) ~ (i+7,j+7) 까지 기준점을 이동하여 8 x 8 오려내기
                for (int row = i, rowSize = 0; row < i + 8 && rowSize < 8; row++, rowSize++) { // 8
                    for (int col = j, colSize = 0; col < j + 8 && colSize < 8; col++, colSize++) { // 8
                        BOARD_8X8[rowSize][colSize] = BOARD_NXM[row][col];
                    }
                }

                // 오려낸 8 x 8 체스판에서 설정된 기준점을 기준으로 삼아 얼마나 칠해야 하는지 검사
                // 8 x 8 의 (0,0) 이 W(true) 로 시작할 경우
                find(true);
                // 8 x 8 의 (0,0) 이 B(false) 로 시작할 경우
                find(false);

                // 각 모서리 총 4개의 기준점을 모두 고려할 필요없다.
                // 8 x 8 의 (0,0) 색깔을 정해버리고, (7,7) 색깔까지 그 패턴을 적용하여 잘못 색칠된 색깔을 카운트하면 된다.
                // 그리고 그 중 최소값을 선택하면 된다.
            }
        }

        System.out.print(PAINTS.stream().mapToInt(i -> i).min().orElseThrow());
    }

    private static void find(boolean f) {
        int paint = 0;
        boolean flag = f;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                boolean pos = flag; // 예상
                boolean real = BOARD_8X8[r][c];
                if (pos != real) { // 예상과 실제가 다르다면 색칠
                    paint++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        PAINTS.add(paint);
    }

    private static boolean convert(String color) {
        if (color.equals("W")) {
            return true;
        } else {
            return false;
        }
    }
}



