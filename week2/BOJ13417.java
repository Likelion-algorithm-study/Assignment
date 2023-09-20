package week2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ13417 {
    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++) {
            int count = sc.nextInt();
            for (int s = 0; s < count; s++) {
                char word = sc.next().charAt(0);
                if (!deque.isEmpty()){
                    if (word<=deque.peekFirst())
                        deque.addFirst(word);
                    else
                        deque.addLast(word);
                } else {
                    deque.addLast(word);
                }
            }
            for (Character x : deque)
                System.out.print(x);
            System.out.println();
            deque.clear();
        }
    }
}
