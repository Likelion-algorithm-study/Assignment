package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 30
public class BOJ10610_ {
    // 30 배수 판별법
    // 3 배수 판별법 : 각 자리의 수의 합이 3 또는 6 또는 9
    // 10 배수 판별법 : 일의 자리가 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String numbers = br.readLine();

        String[] split = numbers.split("");
        List<String> answer = new ArrayList<>();
        for (String str : split) {
            answer.add(str);
        }

        Collections.sort(answer, Collections.reverseOrder()); // 내림차순 정렬. 30 배수인게 판명났으니 내림차순 정렬해두면 바로 sb 에 붙일 수 있음

        if (validate3Multiples(answer) && validate10Multiples(answer)) { // 30 배수 가능하다면
            answer.stream().forEach(str -> sb.append(str));
            System.out.print(sb);
        } else { // 30 배수 불가능하다면
            System.out.print(-1);
        }
    }

    private static boolean validate3Multiples(List<String> sortedReverse) {
        int sum = sortedReverse.stream().mapToInt(str -> Integer.parseInt(str)).sum();
        return (sum % 3 == 0);
    }

    private static boolean validate10Multiples(List<String> sortedReverse) {
        return sortedReverse.get(sortedReverse.size() - 1).equals("0");
    }
}
