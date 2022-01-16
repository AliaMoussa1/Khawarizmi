package Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quick {
    // method to find the partition position
    static int partition(ArrayList<Integer> arr, int low, int high) {

        int pivot = arr.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }

        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return (i + 1);
    }

    static double quickSort(ArrayList<Integer> arr, int low, int high) {
        int steps = 0;
        if (low < high) {
            int pi = partition(arr, low, high);
            steps += pi;
            steps += quickSort(arr, low, pi - 1);
            steps += quickSort(arr, pi + 1, high);
        }
        return steps;
    }

    File file = new File("testQuick.txt");

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
        return quickSort(arr, 0 ,n-1);
    }
}
