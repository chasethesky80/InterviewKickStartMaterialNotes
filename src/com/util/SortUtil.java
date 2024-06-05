package com.util;

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
}
