import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws IOException, EmptyStackException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            Stack<Character> stack = new Stack<>();
            int res = 1;
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);
                if (ch == '[' || ch == '{' || ch == '(' || ch == '<') {
                    stack.push(ch);
                } else if (stack.peek() == null || (ch == ']' && stack.pop() != '[')
                        || (ch == '}' && stack.pop() != '{') || (ch == ')' && stack.pop() != '(')
                        || (ch == '>' && stack.pop() != '<') || (i == N - 1 && !stack.isEmpty())) {
                    res = 0;
                    break;
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
