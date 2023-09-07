package BOJ.week1._17608;

import java.util.Scanner;
import java.util.Stack;

/*
"마지막" 번호의 막대기를 기준으로 보이는 것과 안 보이는 것을 판단하기 때문에 Stack 자료구조를 사용하는 것이 적합하다고 생각했다.
그래서 초기 비교 막대기를 stack.peek() 으로 두었는데 이때 발생한 문제는
비교하다가 더 큰 막대기가 있으면 그 막대기 뒤로는 비교 기준을 다르게 해주어야 한다는 것이었다.
그래서 비교할 때 막대기가 더 큰게 있으면 비교 기준을 해당 막대기로 변경해주었다.
 */

// 시간복잡도 : O(n)

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int inputNum = sc.nextInt();
            stack.push(inputNum);
        }
        System.out.println(solution(stack));
    }

    private static int solution(Stack<Integer> stack) {
        int answer = 1;
        int peek = stack.peek();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (peek < num) {
                answer += 1;
                peek = num;
            }
        }
        return answer;
    }
}
