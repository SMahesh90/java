public class Dijkstra {
    public static void dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] done = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!done[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            done[u] = true;
            for (int v = 0; v < V; v++) {
                if (!done[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println("Distances from vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + ": " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 2, 0},
            {4, 0, 1, 5},
            {2, 1, 0, 3},
            {0, 5, 3, 0}
        };
        dijkstra(graph, 0);
    }
}
