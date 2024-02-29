package week5;

import java.util.*;
import java.util.stream.Collectors;

// 셀프 넘버
public class BOJ4673 {

    private static final List<String> NUMBERS = new ArrayList<>();
    private static final Set<String> ANSWER_SET = new HashSet<>();
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {

        for (int i = 1; i < 10_000; i++) {
            NUMBERS.add(String.valueOf(i));
        }

        for (int i = 1; i < 10_000; i++) {
            int tmp = d(i);
            if (tmp < 10_000) {
                ANSWER_SET.add(String.valueOf(tmp));
            }
        }

        for (String s : NUMBERS) {
            if (!ANSWER_SET.contains(s)) {
                SB.append(s + "\n");
            }
        }

        System.out.println(SB);
    }

    private static int d(int n) {
        String s = String.valueOf(n);
        List<String> list = Arrays.stream(s.split("")).collect(Collectors.toList()); // toList() JAVA 16 버전부터 지원
        int sum = list.stream().mapToInt(i -> Integer.parseInt(i)).sum();
        return n + sum;
    }
}
