package ru.kpfu.itis.labenskaya.topologicalSort;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[this.V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
