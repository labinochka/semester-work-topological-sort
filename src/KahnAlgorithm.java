import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class KahnAlgorithm {

    public static void KahnSort(Graph graph) {
        int indegree[] = new int[graph.V];
        ArrayList<Integer> sort = new ArrayList<>();

        for (int i = 0; i < graph.V; i++) {
            LinkedList<Integer> indeg = graph.adj[i];
            for (int node : indeg) {
                indegree[node]++;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.V; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
        }

        int count = 0;

        while (!stack.empty()) {
            int i = stack.pop();
            sort.add(i);

            for (int node: graph.adj[i]) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    stack.add(node);
                }
            }
            count++;
        }

        if (count != graph.V) {
            System.out.println("В графе есть цикл");
        }
        else {
            for(int i: sort) {
                System.out.print(i + " ");
            }
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
        KahnSort(graph);
    }
}
