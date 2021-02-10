import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.charAt(i);
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == '*') {
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    i++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == '+') {
                    if (i + 3 < n && arr[i + 3] == '*') {
                        char temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = arr[i + 2];
                        arr[i + 2] = temp;
                        i++;
                    } else {
                        char temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        i++;
                    }
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                char temp = arr[i];
                if (temp == '*' || temp == '+') {
                    int a = stack.pop();
                    int b = stack.pop();
                    if (temp == '*') {
                        stack.push(a * b);
                    } else {
                        stack.push(a + b);
                    }
                } else {
                    stack.push(arr[i] - '0');
                }
            }
            System.out.printf("#%d %d\n", t, stack.pop());
        }
    }
}