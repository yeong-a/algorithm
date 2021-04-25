import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    int r;
    int c;

    public Vertex(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[n][n];
            int[][] count = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    char input = str.charAt(j);
                    map[i][j] = input;
                    if (input == '*') {
                        count[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            boolean[][] isOpened = new boolean[n][n];
            getCount(count);
            int res = open(count, isOpened);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    static void getCount(int[][] count) {
        int n = count.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 8; d++) {
                    if (count[i][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if (count[nr][nc] == Integer.MAX_VALUE) {
                            count[i][j]++;
                        }
                    }
                }
            }
        }
    }

    static int open(int[][] count, boolean[][] isOpened) {
        int n = count.length;
        Queue<Vertex> queue = new LinkedList<>();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0 && !isOpened[i][j]) {
                    queue.add(new Vertex(i, j));
                    isOpened[i][j] = true;
                    bfs(count, isOpened, queue);
                    res++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isOpened[i][j] && count[i][j] != Integer.MAX_VALUE) {
                    isOpened[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    static void bfs(int[][] count, boolean[][] isOpened, Queue<Vertex> queue) {
        int n = count.length;
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nr = vertex.r + dir[d][0];
                int nc = vertex.c + dir[d][1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && count[nr][nc] != Integer.MAX_VALUE) {
                    if (isOpened[nr][nc]) {
                        continue;
                    }
                    if (count[nr][nc] == 0) {
                        queue.add(new Vertex(nr, nc));
                    }
                    isOpened[nr][nc] = true;
                }
            }
        }
    }
}
