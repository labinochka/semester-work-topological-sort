package ru.kpfu.itis.labenskaya.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class KahnAlgorithm {

    static int iterationCount = 0;

    public static void KahnSort(Graph graph) {
        // создаем массив, который будет хранить степени входа вершин
        int indegree[] = new int[graph.V];
        // создаем список, который будет хранить топологическую сортировку
        ArrayList<Integer> sort = new ArrayList<>();

        // заполняем массив indegree
        for (int i = 0; i < graph.V; i++) {
            LinkedList<Integer> indeg = graph.adj[i];
            for (int node : indeg) {
                indegree[node]++;
                iterationCount++;
            }
        }

        // проверяем, есть ли вершины со степенью 0. Если да, добавляем их в стек
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.V; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
            iterationCount++;
        }

        // пока стек непустой, добавляем из него вершины в отсортированный список.
        while (!stack.empty()) {
            int i = stack.pop();
            sort.add(i);

            // уменьшаем степени всех смежных вершин на 1. Если появляются вершины со степенью 0, то добавляем их в стек
            for (int node : graph.adj[i]) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    stack.add(node);
                }
                iterationCount++;
            }
        }

        // выводим топологический порядок
        System.out.println("Кол-во итераций: " + iterationCount);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }
}

