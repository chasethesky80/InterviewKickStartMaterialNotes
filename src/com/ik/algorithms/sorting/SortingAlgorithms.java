package com.ik.algorithms.sorting;

import com.ik.util.SortUtil;

import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

    public static void main(String[] args) {
        final List<Integer> input = Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9);
        System.out.println("SORTED ARRAY SELECTION SORT "+ performSelectionSort(Arrays.asList(7, 5, 4, 2, 1, 3)));
        System.out.println("SORTED ARRAY BUBBLE SORT "+ performBubbleSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        System.out.println("SORTED ARRAY INSERTION SORT "+ performInsertionSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        System.out.println("SORTED ARRAY MERGE SORT " + performMergeSort(Arrays.asList(10, 1, 7, 2, 6, 5, 3, 4, 8, 9)));
        performQuickSort(input, 0, input.size() - 1 );
        System.out.println("SORTED ARRAY QUICK SORT "+ input);
        /**
         * 2ND INPUT FOR QUICK SORT
         */
        final List<Integer> arr = Arrays.asList(7, 5, 4, 2, 1, 3);
        performQuickSort(arr, 0, arr.size() - 1 );
        System.out.println("SORTED ARRAY QUICK SORT "+ arr);
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
            SortUtil.swap(input, i, minIndex);
        }
        return input;
    }

    private static List<Integer> performBubbleSort(final List<Integer> input) {
        for (int i =0; i < input.size(); i++) {
          for (int j = input.size() -1; j >= i+1; j--) {
              if (input.get(j-1).compareTo(input.get(j)) > 0) {
                 SortUtil.swap(input, j-1, j);
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

    private static List<Integer> performMergeSort(final List<Integer> input) {
        if (input.size() == 1) {
            return input;
        }
        int mid = input.size()/ 2;
        final List<Integer> leftHalf = input.subList(0, mid);
        final List<Integer> rightHalf = input.subList(mid, input.size());
        return SortUtil.mergeSortHelper(performMergeSort(leftHalf), performMergeSort(rightHalf));
    }

    private static void performQuickSort(final List<Integer> input, final Integer left, final Integer right) {
        if (left >= right) {
            return;
        }
        int idx = SortUtil.rearrange(input, left, right);
        performQuickSort(input, left, idx-1);
        performQuickSort(input, idx + 1, right);
    }
}
