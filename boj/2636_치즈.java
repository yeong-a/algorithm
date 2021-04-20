import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex {
    int r;
    int c;

    public Vertex(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] table = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        int count = 0;
        while (true) {
            fillAir(table);
            count++;
            int temp = meltCheese(table);
            if (temp == 0) {
                break;
            }
            res = temp;
        }
        System.out.println(count - 1);
        System.out.println(res);
    }

    static void fillAir(int[][] table) {
        int H = table.length;
        int W = table[0].length;
        boolean[][] isVisited = new boolean[H][W];
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            table[vertex.r][vertex.c] = 2;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    for (int d = 0; d < 4; d++) {
                        int nr = vertex.r + dir[d][0];
                        int nc = vertex.c + dir[d][1];
                        if (nr >= 0 && nr < H && nc >= 0 && nc < W && !isVisited[nr][nc]
                                && (table[nr][nc] == 0 || table[nr][nc] == 2)) {
                            queue.add(new Vertex(nr, nc));
                            isVisited[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }

    static int meltCheese(int[][] table) {
        int H = table.length;
        int W = table[0].length;
        boolean[][] isMelted = new boolean[H][W];
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (table[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dir[d][0];
                        int nc = j + dir[d][1];
                        if (nr >= 0 && nr < H && nc >= 0 && nc < W && !isMelted[i][j] && table[nr][nc] == 2) {
                            table[i][j] = 0;
                            isMelted[i][j] = true;
                            count += 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
