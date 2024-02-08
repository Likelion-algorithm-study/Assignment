package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 카드 문자열
// 데크 쓸 줄 알아야 한다.
public class BOJ13417 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque;
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine()); // 3

        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine()); // 3
            st = new StringTokenizer(br.readLine()); // M K U
            deque = new LinkedList<>();

            deque.addLast(st.nextToken()); // 최초 세팅

            while (num-- > 1) {
                String s2 = st.nextToken(); // K

                if (deque.peekFirst().compareTo(s2) < 0) {
                    deque.addLast(s2); // 바로 뒤에 붙여도 됨
                } else {
                    deque.addFirst(s2); // 맨 앞에 붙여야 함
                }
            }

            deque.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
