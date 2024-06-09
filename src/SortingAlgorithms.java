import com.util.SortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

    public static void main(String[] args) {
        System.out.println("SORTED ARRAY SELECTION SORT "+ performSelectionSort(Arrays.asList(7, 5, 4, 2, 1, 3)));
        System.out.println("SORTED ARRAY BUBBLE SORT "+ performBubbleSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        System.out.println("SORTED ARRAY INSERTION SORT "+ performInsertionSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        System.out.println("SORTED ARRAY MERGE SORT " + mergeSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        System.out.println("FIBONACCI RECURSIVE " + fibonacci(4));
        System.out.println("FIBONACCI RECURSIVE " + fibonacciLinear(4));
    }

    private static List<Integer> performSelectionSort(final List<Integer> input) {
        for (int i =0; i < input.size(); i++) {
            int minValue = input.get(i);
            int minIndex = i;
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(j).compareTo(minValue) < 0) {
                    minValue = input.get(j);
                    minIndex = j;
                }
            }
            swap(input, i, minIndex);
        }
        return input;
    }

    private static List<Integer> performBubbleSort(final List<Integer> input) {
        for (int i =0; i < input.size(); i++) {
          for (int j = input.size() -1; j >= i+1; j--) {
              if (input.get(j-1).compareTo(input.get(j)) > 0) {
                 swap(input, j-1, j);
              }
          }
        }
        return input;
    }

    private static List<Integer> performInsertionSort(final List<Integer> input) {
        for (int i =0;i < input.size(); i++) {
            int temp = input.get(i);
            int k = i-1;
            while (k >= 0 && input.get(k).compareTo(temp) > 0) {
                input.set(k+1, input.get(k));
                k = k -1;
            }
            input.set(k+1, temp);
        }
        return input;
    }

    private static List<Integer> mergeSort(final List<Integer> input) {
        if (input.size() == 1) {
            return input;
        }
        int mid = input.size()/ 2;
        final List<Integer> leftHalf = input.subList(0, mid);
        final List<Integer> rightHalf = input.subList(mid, input.size());
        return SortUtil.mergeSortHelper(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    // TC = O(2 ^ N/2)
    private static Integer fibonacci(final Integer n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // TC = O(N)
    private static Integer fibonacciLinear(final Integer n) {
        final List<Integer> result = new ArrayList<>();
        result.add(0, 0);
        result.add(1, 1);
        for (int i = 2; i < n + 1; i++) {
            result.add(i, Integer.sum(result.get(i-1), result.get(i-2)));
        }
        return result.get(n);
    }

    private static void swap(final List<Integer> input, final Integer left, final Integer right) {
        int temp = input.get(left);
        input.set(left, input.get(right));
        input.set(right, temp);
    }
}
