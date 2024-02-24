package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 듣보잡
public class BOJ1764 {

    private static StringBuilder sb = new StringBuilder();
    private static Map<String, Integer> map = new HashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            // 만약 존재하는 key 라면 value 끄집어내서(=1) value(=1)에 1 더해서 2 저장
            // 만약 존재하지 않는 key 라면 value(=0)에 1 더해서 1 저장
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) == 2) {
                answer.add(key);
            }
        }

        System.out.println(answer.size());
        answer.stream().sorted().forEach(System.out::println);
    }
}
