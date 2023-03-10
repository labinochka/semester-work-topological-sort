import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch {


    public static void visit(Graph graph, int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = graph.adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void DepthFirstSearchSort(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
        }
        for (int i = 0; i < graph.V; i++) {
            System.out.print(stack.pop() + " ");

        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 1);
        graph.addEdge(6, 5);
        DepthFirstSearchSort(graph);
    }
}