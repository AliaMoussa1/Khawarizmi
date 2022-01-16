package Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Merge {
    public int merge(ArrayList<Integer> arr, int p, int q, int r) {
        int steps=0;
        int n1 = q - p + 1;
        int n2 = r - q;

        int []L = new int[n1];
        int []M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr.get(p + i);
        }
        for (int j = 0; j < n2; j++) {
            M[j] = arr.get(q + 1 + j);
        }
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            steps+=2;
            if (L[i] <= M[j]) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, M[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, M[j]);
            j++;
            k++;
        }
        return steps;
    }

    public int mergeSort(ArrayList<Integer> arr, int l, int r) {
        int steps=0;
        if (l < r) {

            int m = (l + r) / 2;

            steps += mergeSort(arr, l, m);
            steps += mergeSort(arr, m + 1, r);

            steps += merge(arr, l, m, r);
        }
        return steps;
    }

    File file = new File("testMerge.txt");

    public void createFile() throws FileNotFoundException {
        FileWriter fw = null;
        int maxSize = 1000;
        try {
            fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            int line;
            Random random = new Random();
            while (maxSize > 0) {
                line = random.nextInt(100000);  // Randomize an integer and write it to the output file
                writer.write(String.valueOf(line));
                writer.newLine();
                maxSize--;
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public double sort(int n) throws FileNotFoundException {
        ArrayList <Integer> arr = new ArrayList<>(n);
        Scanner s = new Scanner(file);
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(s.nextLine()));
        return mergeSort(arr,0,n-1);
    }
}
