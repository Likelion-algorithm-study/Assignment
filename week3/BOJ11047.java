package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 동전O
public class BOJ11047 {

    private static List<Integer> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(coins, (i1, i2) -> i2 - i1);
        int count = 0;

        for (int coin : coins) {
            int quotient;

            if (K >= coin) { // 4200 > 1000
                quotient = K / coin;
                K -= coin * quotient;
                count += quotient;
            }
        }

        System.out.print(count);
    }
}
