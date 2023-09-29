package AlgoritmProgram;

import java.util.ArrayList;
import java.util.List;

public class MergeSortStrings {

    public static void main(String[] args) {
        List<String> unsortedList = new ArrayList<>();
        unsortedList.add("banana");
        unsortedList.add("apple");
        unsortedList.add("cherry");
        unsortedList.add("date");
        unsortedList.add("fig");

        System.out.println("Unsorted List: " + unsortedList);

        mergeSort(unsortedList);

        System.out.println("Sorted List: " + unsortedList);
    }

    public static void mergeSort(List<String> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;

            List<String> left = list.subList(0, mid);
            List<String> right = list.subList(mid, list.size());

            mergeSort(left);
            mergeSort(right);

            merge(list, left, right);
        }
    }

    private static void merge(List<String> result, List<String> left, List<String> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.set(k, left.get(i));
                i++;
            } else {
                result.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            result.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            result.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
