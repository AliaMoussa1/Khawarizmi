package Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Selection {
    double selectionSort(ArrayList<Integer> arr) {
        int size = arr.size();
        int steps=0;

        for (int j = 0; j < size - 1; j++) {
            int min_idx = j;
            steps++;

            for (int i = j + 1; i < size; i++) {
                if (arr.get(i) < arr.get(min_idx)) {
                    min_idx = i;
                    steps+=2;
                }
            }

            int temp = arr.get(j);
            arr.set(j, arr.get(min_idx));
            arr.set(min_idx, temp);
            steps+=3;
        }
        return steps;
    }

    File file = new File("testSelection.txt");

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
        return selectionSort(arr);
    }

}
