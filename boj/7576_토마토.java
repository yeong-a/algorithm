import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int r;
    int c;
    int day;

    public Tomato(int r, int c, int day) {
        this.r = r;
        this.c = c;
        this.day = day;
    }
}

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(box));
    }

    static int bfs(int[][] box) {
        int N = box.length;
        int M = box[0].length;
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }
        int day = 0;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = Math.max(day, tomato.day);
            for (int d = 0; d < 4; d++) {
                int nr = tomato.r + dir[d][0];
                int nc = tomato.c + dir[d][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
                    box[nr][nc] = 1;
                    queue.add(new Tomato(nr, nc, tomato.day + 1));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day;
    }
}
