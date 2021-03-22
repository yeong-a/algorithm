import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex> {
    int index;
    int weight;

    public Vertex(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Vertex>[] list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Vertex>();
        }
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        int[] res = new int[V + 1];

        Arrays.fill(res, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Vertex(v, w));

        }

        queue.add(new Vertex(K, 0));
        res[K] = 0;
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (visited[vertex.index]) {
                continue;
            }
            visited[vertex.index] = true;
            for (Vertex o : list[vertex.index]) {
                if (res[o.index] > res[vertex.index] + o.weight) {
                    res[o.index] = res[vertex.index] + o.weight;
                    queue.add(new Vertex(o.index, res[o.index]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(res[i]);
            }
        }
    }
}
