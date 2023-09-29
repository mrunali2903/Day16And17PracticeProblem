package AlgoritmProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

    // Iterative method to generate all permutations of a string
    public static List<String> iterativePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
            int size = permutations.size();

            for (int j = 0; j < size; j++) {
                char[] current = permutations.get(j).toCharArray();
                for (int k = i + 1; k < str.length(); k++) {
                    char temp = current[i];
                    current[i] = current[k];
                    current[k] = temp;
                    permutations.add(String.valueOf(current));
                }
            }
        }

        return permutations;
    }

    // Recursive method to generate all permutations of a string
    public static List<String> recursivePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        recursivePermutationsHelper(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void recursivePermutationsHelper(char[] arr, int index, List<String> permutations) {
        if (index == arr.length) {
            permutations.add(String.valueOf(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            recursivePermutationsHelper(arr, index + 1, permutations);
            swap(arr, index, i); // Backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";

        List<String> iterativeResult = iterativePermutations(input);
        List<String> recursiveResult = recursivePermutations(input);

        System.out.println("Iterative Permutations: " + iterativeResult);
        System.out.println("Recursive Permutations: " + recursiveResult);

        boolean areEqual = Arrays.equals(iterativeResult.toArray(), recursiveResult.toArray());
        System.out.println("Are the results equal? " + areEqual);
    }
}
