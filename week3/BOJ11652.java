package week3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long [] list = new long [n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextLong();
        }
        long minNumber = 0;
        int maxCount = 1, count = 1;
        Arrays.sort(list);
        minNumber = list[0];
        for (int s = 1; s < list.length; s++) {
            if (list[s] == list[s-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                minNumber = list[s-1];
            }
        }
        System.out.println(minNumber);
    }
}
