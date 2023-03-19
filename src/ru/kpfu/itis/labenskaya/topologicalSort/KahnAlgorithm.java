package ru.kpfu.itis.labenskaya.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class KahnAlgorithm {

    static int iterationCount = 0;

    public static void KahnSort(Graph graph) {
        int indegree[] = new int[graph.V];
        ArrayList<Integer> sort = new ArrayList<>();

        for (int i = 0; i < graph.V; i++) {
            LinkedList<Integer> indeg = graph.adj[i];
            for (int node : indeg) {
                indegree[node]++;
                iterationCount++;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.V; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
            iterationCount++;
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
                iterationCount++;
            }
            count++;
        }

        if (count != graph.V) {
            System.out.println("В графе есть цикл");
            System.out.println("Кол-во итераций: " + iterationCount);
        }
        else {
            System.out.println("Кол-во итераций: " + iterationCount);
            for(int i: sort) {
                System.out.print(i + " ");
            }
        }
    }
}
