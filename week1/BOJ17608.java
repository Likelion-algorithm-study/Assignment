package week1;

import java.util.Scanner;
import java.util.Stack;

public class BOJ17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n, h;
        int count = 1;
        int standard, current;
        n = sc.nextInt();
        for (int i=0; i<n; i++){
            h = sc.nextInt();
            stack.push(h);
        }
        standard = stack.pop();
        for (int i=0; i<n-1; i++){
            current = stack.pop();
            if (current > standard){
                count++;
                standard = current;
            }
        }
        System.out.println(count);
    }
}