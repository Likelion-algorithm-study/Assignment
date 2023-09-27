package week3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }

        Arrays.sort(list, (o1, o2) ->
        {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }

    }
}
