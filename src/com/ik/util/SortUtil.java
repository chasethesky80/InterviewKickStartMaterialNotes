package com.ik.util;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

    public static List<Integer> mergeSortHelper(final List<Integer> leftHalf, final List<Integer> rightHalf) {
        final List<Integer> auxillary = new ArrayList<>();
        int i = 0, j = 0;
        while (i < leftHalf.size() && j < rightHalf.size()) {
            if (leftHalf.get(i).compareTo(rightHalf.get(j)) <= 0) {
                auxillary.add(leftHalf.get(i));
                i++;
            } else {
                auxillary.add(rightHalf.get(j));
                j++;
            }
        }
        while (i < leftHalf.size()) {
            auxillary.add(leftHalf.get(i));
            i++;
        }
        while (j < rightHalf.size()) {
            auxillary.add(rightHalf.get(j));
            j++;
        }
        return auxillary;
    }

    public static void quickSortHelper(final List<Integer> input, final int startIndex, final int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        Integer pivot = startIndex;
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;
        while (rightIndex >= leftIndex) {
            if (input.get(leftIndex).compareTo(pivot) > 0 && input.get(rightIndex).compareTo(pivot) < 0) {
                swap(input, leftIndex, rightIndex);
            }
            if (input.get(leftIndex).compareTo(pivot) <= 0) {
                leftIndex = leftIndex + 1;
            }
            if (input.get(rightIndex).compareTo(pivot) >= 0) {
                rightIndex = rightIndex - 1;
            }
        }
        swap(input, pivot, rightIndex);
        int leftSubArrayLength = rightIndex - 1 - startIndex;
        int rightSubArrayLength = endIndex - (rightIndex + 1);
        if (leftSubArrayLength < rightSubArrayLength) {
            quickSortHelper(input, startIndex, rightIndex-1);
            quickSortHelper(input, rightIndex + 1, endIndex);
        } else {
            quickSortHelper(input, rightIndex + 1, endIndex);
            quickSortHelper(input, startIndex, rightIndex-1);
        }
    }

    public static void swap(final List<Integer> input, final Integer left, final Integer right) {
        int temp = input.get(left);
        input.set(left, input.get(right));
        input.set(right, temp);
    }
}
