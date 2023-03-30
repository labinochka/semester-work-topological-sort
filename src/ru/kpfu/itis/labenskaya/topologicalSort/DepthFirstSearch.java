package ru.kpfu.itis.labenskaya.topologicalSort;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch {

    static int iterationCount = 0;

    // посещаем вершину
    public static void visit(Graph graph, int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = graph.adj[v].iterator();
        // проходим по смежным вершинам
        while (it.hasNext()) {
            i = it.next();
            // если есть не посещенные вершины, то посещаем их
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
            iterationCount++;
        }
        // обработанную вершину добавляем в стек
        stack.push(v);
        ;
    }

    public static void DFS(Graph graph) {
        // создаем стек, в котором будут храниться вершины
        Stack<Integer> stack = new Stack<>();
        // создаем массив, который будет хранить данные о посещенных вершинах
        boolean visited[] = new boolean[graph.V];
        // через цикл посещаем все вершины
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                visit(graph, i, visited, stack);
            }
            iterationCount++;
        }


        System.out.println("Кол-во итераций: " + iterationCount);
        // выводим топологический порядок через цикл
        for (int i = 0; i < graph.V; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}