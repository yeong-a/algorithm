import java.io.*;
import java.util.*;

class Tower {
	int height;
	int index;

	public Tower(int height, int index) {
		this.height = height;
		this.index = index;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Tower> stack = new Stack<>();
		stack.push(new Tower(Integer.MAX_VALUE, 0));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		for (int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());
			Tower tower = new Tower(height, i);
			while (stack.peek().height < tower.height) {
				stack.pop();
			}
			bw.write(stack.peek().index + " ");
			stack.push(tower);
		}
		bw.close();
	}
}
