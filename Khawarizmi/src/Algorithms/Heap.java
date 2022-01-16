package Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Heap {
    public double heapify(ArrayList<Integer> arr, int n, int i) {
        int steps=0;
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;
        steps++;

        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            steps+= heapify(arr, n, largest);
        }
        return steps;
    }


    public double buildMaxHeap(ArrayList<Integer> arr, int n){
        int steps = 0;
        for (int i = n / 2 - 1; i >= 0; i--)
            steps+= heapify(arr, n, i);
        return steps;
    }



    public double heapAlgo(ArrayList<Integer> arr) {
        int n = arr.size();
        int steps = 0;
        buildMaxHeap(arr,n);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            steps+=heapify(arr, i, 0);
        }
        return steps;
    }

    File file = new File("testHeap.txt");

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
        return heapAlgo(arr);
    }

}
