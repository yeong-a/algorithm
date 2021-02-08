import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < N; i++) {
				Integer a = Integer.parseInt(st.nextToken());
				list.add(a);
			}
			int S = Integer.parseInt(br.readLine());
			String str2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			for (int i = 0; i < S; i++) {
				if (st2.nextToken().equals("I")) {
					int x = Integer.parseInt(st2.nextToken());
					int y = Integer.parseInt(st2.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(x++, Integer.parseInt(st2.nextToken()));
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			System.out.printf("#%d %s\n", t, sb);
		}
	}
}
