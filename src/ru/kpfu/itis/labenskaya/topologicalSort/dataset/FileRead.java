package ru.kpfu.itis.labenskaya.topologicalSort.dataset;

import ru.kpfu.itis.labenskaya.topologicalSort.DepthFirstSearch;
import ru.kpfu.itis.labenskaya.topologicalSort.Graph;
import ru.kpfu.itis.labenskaya.topologicalSort.KahnAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRead {

    public static void main(String[] args) {
        try {
            File file = new File("src/ru/kpfu/itis/labenskaya/topologicalSort/dataset/Files/File.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            List<int[]> list = new ArrayList<>();
            int vertex = 0;

            while (line != null) {
                int[] intArray = new int[2];
                String[] array = line.split(" ");
                intArray[0] = Integer.parseInt(array[0]);
                intArray[1] = Integer.parseInt(array[1]);
                vertex++;
                list.add(intArray);
                line = reader.readLine();
            }

            Graph graph = new Graph(vertex);
            for (int[] arr: list) {
                graph.addEdge(arr[0], arr[1]);
            }
            double startTime1 = System.nanoTime();
            DepthFirstSearch.DFS(graph);
            double endTime1 = System.nanoTime();
            System.out.println("Время мс: " + (endTime1-startTime1) / 1000000);

            System.out.println();

            double startTime2 = System.nanoTime();
            KahnAlgorithm.KahnSort(graph);
            double endTime2 = System.nanoTime();
            System.out.println("Время мс: " + (endTime2-startTime2) / 1000000);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
