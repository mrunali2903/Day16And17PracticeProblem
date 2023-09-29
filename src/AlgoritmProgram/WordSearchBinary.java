package AlgoritmProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordSearchBinary {
    public static void main(String[] args) {
        try {
            // Read the list of words from a file
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line = reader.readLine();
            String[] wordList = line.split(",");

            // Sort the word list
            Arrays.sort(wordList);

            // Prompt the user to enter the word to search
            System.out.print("Enter a word to search: ");
            String searchWord = System.console().readLine();

            // Perform binary search
            boolean found = binarySearch(wordList, searchWord);

            // Print the result
            if (found) {
                System.out.println(searchWord + " is found in the list.");
            } else {
                System.out.println(searchWord + " is not found in the list.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static boolean binarySearch(String[] wordList, String searchWord) {
        int left = 0;
        int right = wordList.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = searchWord.compareTo(wordList[mid]);

            if (compareResult == 0) {
                return true; // Word found
            } else if (compareResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // Word not found
    }
}
