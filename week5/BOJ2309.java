package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 일곱 난쟁이
public class BOJ2309 {

    private final static List<Integer> LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            LIST.add(Integer.parseInt(br.readLine()));
        }

        outLoop:
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                int sum = LIST.stream().mapToInt(k -> k).sum();
                if (sum - LIST.get(i) - LIST.get(j) == 100) {
                    LIST.remove(i); // LIST.remove(i) 사용한다면 요소 삭제되었기 때문에 인덱스 변경 발생함
                    LIST.remove(j-1); // 요소가 삭제되어 i 뒤 요소들이 앞으로 땡겨진만큼 실제로 인덱스 j 도 -1 해줘야 함
                    break outLoop;
                }
            }
        }

        Collections.sort(LIST);
        LIST.stream().forEach(System.out::println);
    }

}
