package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 순열
public class BOJ10974_ {

    static int n;
    static int[] arr; // 기본 0
    static boolean[] visited; // 기본 false

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n + 1];

        dfs(0);
    }

    public static void dfs(int cnt) {
        if (cnt == n) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) { // n = 3
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
