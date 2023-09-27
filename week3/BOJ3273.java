package week3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(list);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ans = x - list[i];
            if (ans<=list[i]) break;
            else {
                for (int s = i + 1; s < n; s++) {
                    if (ans==list[s]) {
                        count++;
                        break;
                    } else if (ans<list[s]) break;
                }
            }
        }
        System.out.println(count);
    }
}
