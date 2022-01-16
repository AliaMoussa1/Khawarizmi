package Algorithms;

import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Insertion {
    public double insertionAlgo(ArrayList<Integer> arr) {
        int n = arr.size();
        int steps = 0;
        for (int j = 1; j < n; j++) {
            int key = arr.get(j);
            int i = j - 1;
            steps += 2;

            while (i >= 0 && key < arr.get(i)) {
                arr.set(i + 1, arr.get(i));
                i--;
                steps += 2;
            }

            arr.set(i + 1, key);
            steps++;
        }
        return steps;
    }

    File file = new File("testInsertion.txt");

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
        return insertionAlgo(arr);
    }
}








