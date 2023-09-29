package AlgoritmProgram;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the list of words as a single string
        System.out.println("Enter a list of words separated by spaces:");
        String input = scanner.nextLine();
        String[] words = input.split(" "); // Split the input string into an array of words

        // Sort the words using Insertion Sort
        insertionSort(words);

        // Print the sorted list
        System.out.println("Sorted List:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
