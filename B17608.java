import java.util.*;

// 막대기
public class B17608 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int count = 1;

        for(int i=0; i<testCase; i++) {
            stack.push(sc.nextInt());
        }

        int popped = stack.pop();
        while(!stack.empty()) {
            if(stack.peek() > popped) {
                count++;
                popped = stack.pop();
                continue;
            }
            stack.pop();
        }

        System.out.println(count);
    }
}
