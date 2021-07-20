import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(from, to, weight));
        }
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        int res = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (find(node.from) == find(node.to)) {
                continue;
            }
            union(node.from, node.to);
            res += node.weight;
        }
        System.out.println(res);
    }

    static int find(int n) {
        if (n == parents[n]) {
            return n;
        } else {
            int temp = find(parents[n]);
            parents[n] = temp;
            return temp;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
        }
    }
}
