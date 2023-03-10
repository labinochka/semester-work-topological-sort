import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adj[];

    Graph(int V) {
        this.V = V;
        adj = new LinkedList[this.V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
