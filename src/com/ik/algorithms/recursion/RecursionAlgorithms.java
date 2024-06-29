package com.ik.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RecursionAlgorithms {

    public static void main(String[] args) {
        System.out.println("FIBONACCI RECURSIVE " + fibonacci(4));
        System.out.println("FIBONACCI RECURSIVE " + fibonacciLinear(4));
        System.out.println("FIBONACCI RECURSIVE WITH GIVEN BASE CASES "+ fibonacciRecursionImproved(4, 2, 4));
        System.out.println("PEOPLE BEHIND ME "+ peopleBehindMe(7));
        System.out.println("N RAISED TO POWER K "+ nRaiseToPowerK(3, 3));
        System.out.println("NO OF SUBSETS FOR SET OF SIZE N "+noOfSubsetsForSet(5));
        System.out.println("ENUMERATE BINARY STRINGS OF LENGTH N RECURSIVE "+ enumerateBinaryStringsRecursive(4));
        System.out.println("ENUMERATE BINARY STRINGS OF LENGTH N RECURSIVE IMPROVED ");
        enumerateBinaryStringsRecursiveImproved(3);
        System.out.println();
        System.out.println("ENUMERATE BINARY STRINGS OF LENGTH N ITERATIVE "+ enumerateStringsIterative(3));
        System.out.println("ENUMERATE ALL STRINGS OF LENGTH N RECURSIVE REPETITIONS ALLOWED FROM INPUT STRING");
        enumerateDecimalStringsRecursiveImproved(2, List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        System.out.println("ENUMERATE ALL STRINGS OF LENGTH N RECURSIVE REPETITIONS NOT ALLOWED");
        enumerateDecimalStringsWithRepetitionsNotAllowed(List.of("0", "1", "2"));
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

    private static Integer noOfSubsetsForSet(int N) {
        if (N == 0) {
            return 1;
        }
        return 2 * noOfSubsetsForSet(N-1);
    }

    private static List<String> enumerateBinaryStringsRecursive(int N) {
        if (N == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("0");
            arrayList.add("1");
            return arrayList;
        }

        final ArrayList<String> result = new ArrayList<>();
        final List<String> prevResult = enumerateBinaryStringsRecursive(N-1);
        for (String item: prevResult) {
            result.add(item.concat("0"));
            result.add(item.concat("1"));
        }
        return result;
    }

    private static List<String> enumerateStringsIterative(int N) {
        List<String> result = Arrays.asList("0", "1");
        for (int i = 2; i <= N; i++) {
            final List<String> newResult = new ArrayList<>();
            for (String s: result) {
                newResult.add(s.concat("0"));
                newResult.add(s.concat("1"));
            }
            result = newResult;
        }
        return result;
    }

    private static void enumerateBinaryStringsRecursiveImproved(int N) {
        enumerateBinaryStringsRecursiveHelper("", N);
    }

    private static void enumerateBinaryStringsRecursiveHelper(final String slate, int N) {
        if (N == 0) {
            System.out.print(slate.concat(" "));
        } else {
            enumerateBinaryStringsRecursiveHelper(slate.concat("0"), N - 1);
            enumerateBinaryStringsRecursiveHelper(slate.concat("1"), N - 1);
        }
    }

    private static void enumerateDecimalStringsRecursiveImproved(int N, final List<String> input) {
        enumerateDecimalStringsRecursiveHelper("", N, input);
    }

    private static void enumerateDecimalStringsRecursiveHelper(final String slate, int N, final List<String> input) {
        if (N == 0) {
            System.out.print(slate.concat(" "));
        } else {
            for (String suffix: input) {
                enumerateDecimalStringsRecursiveHelper(slate.concat(suffix), N - 1, input);
            }
        }
    }

    private static void enumerateDecimalStringsWithRepetitionsNotAllowed(final List<String> input) {
        enumerateDecimalStringsWithRepetitionsNotAllowedHelper("", input);
    }

    private static void enumerateDecimalStringsWithRepetitionsNotAllowedHelper(final String slate, final List<String> input) {
        if (input.isEmpty()) {
            System.out.print(slate.concat(" "));
        }
        for (int i = 0; i < input.size(); i++) {
            final List<String> newList = Stream.concat(input.subList(0, i).stream(), input.subList(i+1, input.size()).stream()).toList();
            enumerateDecimalStringsWithRepetitionsNotAllowedHelper(slate.concat(input.get(i)), newList);
        }
    }
}
