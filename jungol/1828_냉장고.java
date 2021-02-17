import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Chemicals implements Comparable<Chemicals>{
	int minTemp;
	int maxTemp;

	public Chemicals(int minTemp, int maxTemp) {
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	@Override
	public int compareTo(Chemicals o) {
		return this.maxTemp - o.maxTemp;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Chemicals[] arr = new Chemicals[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			arr[i] = new Chemicals(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		int temperature = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (temperature < arr[i].minTemp) {
				temperature = arr[i].maxTemp;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
