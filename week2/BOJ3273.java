package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 두 수의 합
public class BOJ3273 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tc; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int answer = 0;
        int condition = Integer.parseInt(br.readLine());
        for (int i : list) {
            answer += binarySearch(condition - i);
        }
        System.out.print(answer / 2);
    }

    private static int binarySearch(int target) {
        int midIdx;
        int lowIdx = 0;
        int highIdx = list.size() - 1;

        while (lowIdx <= highIdx) {
            midIdx = (lowIdx + highIdx) / 2;

            if (list.get(midIdx) == target) {
                return 1;
            } else if (list.get(midIdx) < target) {
                lowIdx = midIdx + 1;
            } else {
                highIdx = midIdx - 1;
            }
        }
        return 0;
    }
}
