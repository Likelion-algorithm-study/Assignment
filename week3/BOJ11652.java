package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// 카드
public class BOJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new TreeMap<>(); // key 에 대해 정렬

        for (int i = 0; i < tc; i++) {
            Long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            // entry.getValue() > maxValue : 가장 처음 조건에 무조건 maxKey, maxValue 를 세팅하기 위함

            // entry.getValue() == maxValue : 처음 이후에 value 가 maxValue 와 같은지 판단하기 위함
            // entry.getKey() < maxKey : 처음 이후에 key 가 maxKey 와 같은지 판단하기 위함
            if (entry.getValue() > maxValue || (entry.getValue() == maxValue && entry.getKey() < maxKey)) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        System.out.println(maxKey);
    }
}
