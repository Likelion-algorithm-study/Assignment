package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달
public class BOJ2839_ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        int quotient;
        int answer = 0;

        while (total >= 0) { // total 이 0 이상일 경우에만 반복문
            if (total % 5 == 0) {
                quotient = total / 5;
                total -= quotient * 5;
                answer += quotient;
                break; // 만약 5로 나눠진다면 최소 횟수로 나누는 데 성공한 것이므로 반복문 탈출
            }

            total -= 3; // 만약 5로 나눠지지 않는다면 3씩 감소시키며 5의 배수가 나올 가능성을 준비

            if (total < 0) { // total 이 음수라는 것은 3으로 나눠지지 않았음을 의미하므로 -1 출력
                System.out.print(-1);
                return; // 메서드 종료
            }

            answer++;
        }

        System.out.print(answer);
    }
}
