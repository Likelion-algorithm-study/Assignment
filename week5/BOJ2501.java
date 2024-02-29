package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 약수 구하기
public class BOJ2501 {

    private static final List<Integer> LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            if (N % i == 0) {
                LIST.add(i);
            }
        }

        try {
            System.out.print(LIST.get(K-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.print(0);
        }

    }
}
