package com.ik.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionAlgorithms {

    public static void main(String[] args) {
        System.out.println("FIBONACCI RECURSIVE " + fibonacci(4));
        System.out.println("FIBONACCI RECURSIVE " + fibonacciLinear(4));
        System.out.println("FIBONACCI RECURSIVE WITH GIVEN BASE CASES "+ fibonacciRecursionImproved(4, 2, 4));
        System.out.println("PEOPLE BEHIND ME "+ peopleBehindMe(7));
        System.out.println("N RAISED TO POWER K "+ nRaiseToPowerK(3, 3));
    }

    /**
     * TC = O(2 ^ N/2) - > Top Down Approach
     * @param n
     * @return
     */
    private static Integer fibonacci(final Integer n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * TC = O(N) - > Fibonacci linear sequence with the given first 2 base cases
     * @param n
     * @return
     */
    private static Integer fibonacciRecursionImproved(final Integer n, final Integer baseCase1, final Integer baseCase2) {
        if (n == 0) {
            return baseCase1;
        }
        return fibonacciRecursionImproved(n-1, baseCase2, baseCase1 + baseCase2);
    }

    /**
     * TC = O(N) - > Bottom Up Approach - Dynamic Programming style
     * @param n
     * @return
     */
    private static Integer fibonacciLinear(final Integer n) {
        final List<Integer> result = new ArrayList<>();
        result.add(0, 0);
        result.add(1, 1);
        for (int i = 2; i < n + 1; i++) {
            result.add(i, Integer.sum(result.get(i-1), result.get(i-2)));
        }
        return result.get(n);
    }

    private static Integer peopleBehindMe(final Integer n) {
        if (n == 1) {
            return 1;
        }
        return 1 + peopleBehindMe(n-1);
    }

    private static Integer nRaiseToPowerK(int n, int k) {
        if (k == 0) {
            return 1;
        }
        return n * nRaiseToPowerK(n, k-1);
    }
}
