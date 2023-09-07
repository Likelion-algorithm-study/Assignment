package BOJ.week1._26042;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        solution(n);
    }

    private static void solution(int n) {
        int longest = 0;
        int studentNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            if (input.equals("1")) {
                int newStudent = sc.nextInt();
                queue.add(newStudent);
                if (queue.size() > longest) {
                    longest = queue.size();
                    studentNum = newStudent;
                } else if (queue.size() == longest) {
                    if (newStudent < studentNum) {
                        studentNum = newStudent;
                    }
                }
            } else if (input.equals("2")) {
                queue.poll();
            }
        }
        System.out.println(longest + " " + studentNum);
    }
}
