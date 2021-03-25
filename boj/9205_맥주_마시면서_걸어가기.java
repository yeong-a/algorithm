import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Vertex {
    int x;
    int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Vertex[] vertices = new Vertex[n + 2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                vertices[i] = new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            boolean[][] map = new boolean[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if ((Math.abs(vertices[i].x - vertices[j].x) + Math.abs(vertices[i].y - vertices[j].y)) <= 1000) {
                        map[i][j] = map[j][i] = true;
                    }
                }
            }
            floyd(map);

            if (map[0][n+1]) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
    static void floyd (boolean[][] map) {
        int n = map.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (j == k || j == i) {
                        continue;
                    }
                    map[i][j] = map[j][i] = map[i][j] || (map[i][k] && map[k][j]);
                }
            }
        }
    }
}
