import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cabbage {
    int r;
    int c;
    int index;

    public Cabbage(int r, int c, int index) {
        this.r = r;
        this.c = c;
        this.index = index;
    }
}

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];

            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            System.out.println(go(map));
        }
    }

    static int go(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] visited = new int[N][M];
        int index = 1;
        Queue<Cabbage> queue = new LinkedList<>();
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    queue.add(new Cabbage(i, j, index));
                    visited[i][j] = index++;
                    bfs(map, queue, visited);
                }
            }
        }
        return index - 1;
    }

    static void bfs(int[][] map, Queue<Cabbage> queue, int[][] visited) {
        int N = map.length;
        int M = map[0].length;
        while(!queue.isEmpty()) {
            Cabbage cabbage = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cabbage.r + dir[d][0];
                int nc = cabbage.c + dir[d][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == 0 && map[nr][nc] == 1) {
                    queue.add(new Cabbage(nr, nc, cabbage.index));
                    visited[nr][nc] = cabbage.index;
                }
            }
        }
    }
}
