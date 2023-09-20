package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        LinkedList<Character> edit = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char phrase;
        String word;
        word = br.readLine();
        for(int i=0;i<word.length();i++){
            phrase=(word.charAt(i));
            edit.addLast(phrase);
        }
        ListIterator<Character> iter = edit.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i<t; i++){
            String command = br.readLine();
            if (command.equals("L")) {
                if(iter.hasPrevious())
                    iter.previous();
            } else if (command.equals("D")) {
                if(iter.hasNext())
                    iter.next();
            } else if (command.equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (command.contains("P")) {
                char edit_word = command.charAt(2);
                iter.add(edit_word);
            }
        }
        for(Character i : edit) {
            bw.write(i);
        }
        bw.flush();
        bw.close();
    }
}
