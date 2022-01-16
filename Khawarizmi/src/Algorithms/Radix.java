package Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Radix {
    double countingSort(ArrayList<Integer> arr, int size, int place) {
        size = arr.size();
        int[] output = new int[size + 1];
        int max = arr.get(0);
        int steps=0;

        for (int i = 1; i < size; i++) {
            if (arr.get(i) > max)
                max = arr.get(i);
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) {
            count[i] = 0;
            steps++;
        }

        for (int i = 0; i < size; i++) {
            count[(arr.get(i) / place) % 10]++;
            steps++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            steps++;
        }

        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr.get(i) / place) % 10] - 1] = arr.get(i);
            count[(arr.get(i) / place) % 10]--;
            steps++;
        }

        for (int i = 0; i < size; i++)
            arr.set(i, output[i]);
        return steps;
    }

    // Function to get the largest element from an array
    public int getMax(ArrayList<Integer> arr, int n) {
        int max = arr.get(0);
        for (int i = 1; i < n; i++)
            if (arr.get(i) > max)
                max = arr.get(i);
        return max;
    }

    // Main function to implement radix sort
    double radixSort(ArrayList<Integer> arr, int size) {
        int steps=0;
        // Get maximum element
        int max = getMax(arr, size);
        steps++;
        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            steps += countingSort(arr, size, place);
        return steps;
    }

    File file = new File("testRadix.txt");

    public void createFile() throws FileNotFoundException {
        FileWriter fw = null;
        int maxSize = 1000;
        try {
            fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            int line;
            Random random = new Random();
            while (maxSize > 0) {
                line = random.nextInt(100);  // Randomize an integer and write it to the output file
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
        return radixSort(arr, n);
    }

}
