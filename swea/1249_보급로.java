import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
class Vertex implements Comparable<Vertex>{
    int r;
    int c;
    int weight;
 
    public Vertex(int r, int c, int weight) {
        this.r = r;
        this.c = c;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}
 
public class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            System.out.printf("#%d %d\n", t, dijkstra(map));
        }
    }
 
    static int dijkstra(int[][] map) {
        int N = map.length;
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(0, 0, 0));
        distance[0][0] = 0;
        while (!pq.isEmpty()) {
            Vertex top = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nr = top.r + dir[k][0];
                int nc = top.c + dir[k][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (distance[nr][nc] > distance[top.r][top.c] + map[nr][nc]) {
                        distance[nr][nc] = distance[top.r][top.c] + map[nr][nc];
                        pq.add(new Vertex(nr, nc, map[nr][nc]));
                    }
                }
            }
        }
        return distance[N-1][N-1];
    }
}
