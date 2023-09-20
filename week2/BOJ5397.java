package week2;

import java.io.*;
import java.util.Stack;

public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int s = 0; s<t; s++) {
            String input = br.readLine();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < input.length(); i++){
                char command = input.charAt(i);
                if (command=='<') {
                    if (!left.isEmpty()){
                        right.push(left.pop());
                    }
                } else if (command=='>') {
                    if (!right.isEmpty()){
                        left.push(right.pop());
                    }
                } else if (command=='-') {
                    if (!left.isEmpty()){
                        left.pop();
                    }
                } else {
                    left.push(command);
                }
            }
            for (Character x : left) {
                output.append(x);
            }
            while (!right.isEmpty()) {
                output.append(right.pop());
            }
            bw.write(output.toString());
            bw.write("\n");
            left.clear();
            bw.flush();
        }
        bw.close();

    }
}
