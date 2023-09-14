package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

import java.util.StringTokenizer;

public class BOJ26042 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        int maxSize = 0;
        int minLast = testCase;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("1")) {

                Integer studentNumber = Integer.parseInt(st.nextToken()); // 두번째 위치 숫자
                al.add(studentNumber);
                queue.add(studentNumber);

                if(maxSize < queue.size()) { // 큐의 크기가 크다면
                    maxSize = queue.size(); // maxSize 최신화
                    minLast = studentNumber; // minLast 최신화
                } else if(maxSize == queue.size()) { // 큐의 크기가 같다면
                    if(minLast > studentNumber) { // 두번째 위치 숫자가 작다면
                        minLast = studentNumber; // minLast 최신화
                    }
                }
                continue; // 큐의 크기가 작다면 다음 반복문 계속
            }
            queue.poll();
        }

        StringBuilder sb = new StringBuilder("");
        for (int i : al) {
            sb.append(i).append(" ");
            if (i == minLast) break;
        }

        System.out.print(sb.deleteCharAt(sb.length()-1));
    }
}

