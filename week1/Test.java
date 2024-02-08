package week1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        Queue<Integer> pq1 = new PriorityQueue<>();

        pq1.add(1);
        pq1.add(3);
        pq1.add(2);

        for (Integer i : pq1) {
            System.out.print(i);
        }
    }
}
