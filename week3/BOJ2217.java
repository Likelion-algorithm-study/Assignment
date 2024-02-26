package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 로프
public class BOJ2217 {

    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        // 특정 중량으로 통일한 경우 (가장 작거나 가장 큰 중량으로만 제한두지마라)
        for (int i = 0; i < list.size(); i++) {
            answer.add(list.get(i) * (list.size() - i));
        }

        // 개별 중량의 경우
        for (int i : list) {
            answer.add(i);
        }

        System.out.print(answer.stream().max(Integer::compareTo).get());
    }
}
