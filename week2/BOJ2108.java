package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 통계학
public class BOJ2108 {

    private static List<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        sb.append(avg()).append("\n")
                .append(mid()).append("\n")
                .append(frq()).append("\n")
                .append(range());

        System.out.print(sb);
    }

    private static int avg() {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return (int) Math.round(sum / list.size());
    }

    private static int mid() {
        int mid = list.size() / 2;
        return list.get(mid);
    }

    private static int frq() {
        Map<Integer, Integer> map = new HashMap<>(); // number : count
        for (int i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> tmp = new ArrayList<>();
        int max = Collections.max(map.values()); // 최빈값의 최대 출현 횟수 (최빈값이 한 개일수도, 여러 개일수도 있음)
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() == max) {
                tmp.add(entrySet.getKey());
            }
        }

        Collections.sort(tmp); // 최빈값 중 두번째로 작은 수를 얻어내기 위해 오름차순 정렬
        if (tmp.size() == 1) {
            return tmp.get(0);
        } else {
            return tmp.get(1); // 최빈값 중 두번째로 작은 수 얻어내기
        }
    }

    private static int range() {
        int min = list.get(0);
        int max = list.get(list.size() - 1);
        return max - min;
    }
}
