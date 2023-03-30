package ru.kpfu.itis.labenskaya.topologicalSort.dataset;

import java.io.*;
import java.util.*;

public class FileWriter {

    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int n = 10000;
        LinkedList<Integer>[] adj = new LinkedList[n];

        try {
            File f = new File("src/ru/kpfu/itis/labenskaya/topologicalSort/dataset/Files/File10000.txt");
            f.createNewFile();
            FileOutputStream file = new FileOutputStream(f);
            PrintStream printStream = new PrintStream(file);
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
            int count = 0;
            while (count < n) {
                int n1 = r.nextInt(n), n2 = r.nextInt(n);
                if (!adj[n1].contains(n2) && n1 != n2) {
                    printStream.println(n1 + " " + n2);
                    count++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

