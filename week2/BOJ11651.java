package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 좌표 정렬하기 2
public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int[][] arr = new int[tc][2];

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x
            arr[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                if (row1[1] == row2[1]) { // y가 같다면
                    return row1[0] - row2[0]; // x 오름차순 비교
                } else { // y가 같지 않다면
                    return row1[1] - row2[1]; // y 오름차순 비교
                }
            }
        };

        Arrays.sort(arr, comp);

        for (int i = 0; i < tc; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.print(sb);
    }
}
