package week3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (Integer c : list) {
            System.out.println(c);
        }
    }
}
