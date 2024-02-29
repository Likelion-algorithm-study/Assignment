package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 단어 수학
public class BOJ1339_ {

    private static final List<String> LIST = new ArrayList<>(10);
    private static final Map<String, Integer> MAP = new HashMap<>(26);
    private static final Queue<Integer> NUMBERS = new LinkedList<>(); // 동적 큐이므로 capacity 지정 불가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            LIST.add(br.readLine());
        }

        for (int i=9; i>=0; i--) {
            NUMBERS.add(i);
        }

        for (int i = 0; i < tc; i++) {
            String line = LIST.get(i);
            int mul = (int) Math.pow(10, line.length() - 1);

            List<String> split = Arrays.stream(line.split("")).collect(Collectors.toList());
            for (String s : split) {
                MAP.put(s, MAP.getOrDefault(s, 0) + mul);
                mul /= 10;
            }
        }

        Map<String, Integer> sortedMap = MAP.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // KeyMapper
                        Map.Entry::getValue, // valueMapper
                        (oldValue, newValue) -> oldValue, // BinaryOperator
                        LinkedHashMap::new)); // MapFactory

        int sum = sortedMap.entrySet().stream().mapToInt(entry -> entry.getValue() * NUMBERS.poll()).sum();

        System.out.print(sum);
    }
}

