package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 영화감독 숌
public class BOJ1436 {

    private static final int MAX = Integer.MAX_VALUE;
    private static final List<Integer> LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 666, j = N; i <= MAX && j > 0; i++) {
            if (String.valueOf(i).contains("666")) {
                LIST.add(i);
                j--;
            }
        }

        System.out.println(LIST.get(LIST.size()-1));
    }
}
