package ru.kpfu.itis.labenskaya.topologicalSort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;

public class DepthFirstSearch {

    static int iterationCount = 0;

    public static void visit(Graph graph, int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = graph.adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
            iterationCount++;
        }
        stack.push(v);;
    }

    public static void DFS(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        boolean cycle = false;
        boolean visited[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
            iterationCount++;
        }

        Map<Integer, Integer> pos = new HashMap<>();
        int ind = 0;
        while (!stack.empty()) {
            pos.put(stack.peek(), ind);
            ind += 1;
            stack.pop();
        }

        for (int i = 0; i < graph.V; i++) {
            for (Integer it: graph.adj[i]) {
                if (pos.get(i) > pos.get(it)) {
                    cycle = true;
                    break;
                }
            }
            if (cycle) {
                break;
            }
        }


        if (cycle) {
            System.out.println("В графе есть цикл");
        }
        else {
            System.out.println("Кол-во итераций: " + iterationCount);
            for (int i = 0; i < graph.V; i++) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}