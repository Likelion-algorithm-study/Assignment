package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암기왕
public class BOJ2776 {

    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int[] list1; // 실제

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int i1 = Integer.parseInt(br.readLine());
            list1 = new int[i1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i1; j++) {
                list1[j] = Integer.parseInt(st.nextToken()); // 실제 숫자들
            }
            Arrays.sort(list1);

            int i2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i2; j++) {
                binarySearch(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }

    private static void binarySearch(int target) { // target 은 주장 숫자들 중 하나 -> list1(실제 숫자들)에 대해 target 을 하나씩 탐색
        int midIdx;
        int lowIdx = 0; // list1 의 시작 인덱스
        int highIdx = list1.length - 1; // list1 의 끝 인덱스

        while (lowIdx <= highIdx) {
            midIdx = (lowIdx + highIdx) / 2;

            if (target == list1[midIdx]) {
                sb.append(1).append("\n"); // 주장 숫자에 실제 숫자가 존재한다면 1
                return;
            } else if (target < list1[midIdx]) { // target 이 idx mid 보다 왼쪽에 위치할 경우
                highIdx = midIdx - 1;
            } else { // target 이 idx mid 보다 오른쪽에 위치할 경우
                lowIdx = midIdx + 1;
            }
        }
        sb.append(0).append("\n"); // 주장 숫자에 실제 숫자가 존재하지 않다면 0
    }
}
