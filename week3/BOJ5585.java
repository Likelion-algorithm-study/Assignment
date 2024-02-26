package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BOJ5585 {

    private static final List<Integer> COINS = List.of(500, 100, 50, 10, 5, 1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int payment = Integer.parseInt(br.readLine());
        int exchange = 1000 - payment;
        int answer = 0;

        for (int coin : COINS) {
            int quotient;

            if (exchange >= coin) {
                quotient = exchange / coin;
                exchange -= coin * quotient;
                answer += quotient;
            }
        }

        System.out.println(answer);
    }
}
