package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ26042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();
        int max_size = 0, current_size = 0;
        int current_student = 0, student_num = 0;
        for (int i = 0; i < n; i++) {
            String info;
            info = sc.next();
            if (info.equals("1")) {
                current_student = sc.nextInt();
                que.add(current_student);
                current_size = que.size();
                if (current_size > max_size) {
                    max_size = current_size;
                    student_num = current_student;
                } else if (current_size == max_size) {
                    if (student_num > current_student) {
                        student_num = current_student;
                    }
                }
            }
            else {
                que.poll();
            }
        }
        System.out.println(max_size + " " + student_num);
    }
}
