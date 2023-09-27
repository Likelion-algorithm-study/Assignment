package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);
        int average = list[0], center = 0, frq = 0, range = 0;
        int maxCount = 1, count = 1;
        ArrayList<Integer> frqNum = new ArrayList<>();
        frqNum.add(list[0]);
        for (int s = 1; s < n; s++) {
            average += list[s];
            if (list[s] == list[s-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                frqNum.clear();
                frqNum.add(list[s]);
            } else if (count == maxCount) {
                frqNum.add(list[s]);
            }
        }


        double averageNum = average;
        averageNum = Math.round(averageNum/n);
        int aNum;
        aNum = (int)averageNum;
        center = list[n/2];
        if (frqNum.size()>1) frq=frqNum.get(1);
        else frq=frqNum.get(0);
        range = (list[n-1]-list[0]);

        System.out.println(aNum+"\n"+center+"\n"+frq+"\n"+range);

    }
}
