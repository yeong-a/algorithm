import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> operator = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '*' || now == '/') {
                while (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    sb.append(operator.pop());
                }
                operator.push(now);
            } else if (now == '+' || now == '-') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    sb.append(operator.pop());
                }
                operator.push(now);
            } else if (now == ')') {
                while (operator.peek() != '(') {
                    sb.append(operator.pop());
                }
                operator.pop();
            } else if (now == '(') {
                operator.push(now);
            } else {
                sb.append(now);
            }
        }
        while (!operator.isEmpty()) {
            sb.append(operator.pop());
        }
        System.out.println(sb);
    }
}
