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

        System.out.println("ENUMERATE ALL STRINGS OF LENGTH N WITH TRANSFORMING THE CASE OF EACH LETTER OF STRING ");
        final List<String> result = new ArrayList<>();
        enumerateCaseTransformationsRecursiveHelper("", 0, "a1b2", result);
        System.out.println(result);
        result.clear();

        System.out.println("ENUMERATE ALL STRINGS OF LENGTH N WITH TRANSFORMING THE CASE OF EACH LETTER OF STRING IMPROVED ");
        final List<Character> buffer = new ArrayList<>();
        enumerateCaseTransformationsRecursiveHelperImproved(buffer, 0, "a1b2", result);
        System.out.println(result);

        System.out.println("PRINT ALL SUBSETS OF A GIVEN SET OF INTEGERS ");
        printAllSetsOfAnInputSet(new ArrayList<>(), Arrays.asList(4, 2, 5), 0);

        System.out.println("PRINT ALL SUBSETS OF SIZE K FOR A GIVEN SET OF INTEGERS ");
        printAllSetsOfSizeKOfAnInputSet(new ArrayList<>(), Arrays.asList(4, 2, 5, 6), 0, 3);
        System.out.println();
        printAllSetsOfSizeKOfAnInputSet(new ArrayList<>(), Arrays.asList(4, 2, 5, 6), 0, 2);

        System.out.println("ENUMERATE ALL SUBSETS OF A GIVEN SET OF INTEGERS ");
        final List<List<Integer>> subsetResultList = new ArrayList<>();
        enumerateAllSetsOfAnInputSet(new ArrayList<>(), Arrays.asList(4, 2, 5), 0, subsetResultList);
        System.out.println(subsetResultList);
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

    /**
     * TC = (2^N * N^2) and SC = O(N^2)
     * @param slate
     * @param index
     * @param input
     * @param result
     */
    private static void enumerateCaseTransformationsRecursiveHelper(final String slate, int index, String input, final List<String> result) {
        if (index == input.length()) {
            result.add(slate.concat(" "));
        } else {
            if (Character.isDigit(input.charAt(index))) {
                enumerateCaseTransformationsRecursiveHelper(slate.concat(String.valueOf(input.charAt(index))), index + 1, input, result);
            } else {
                enumerateCaseTransformationsRecursiveHelper(slate.concat(String.valueOf(input.charAt(index)).toLowerCase()), index + 1, input, result);
                enumerateCaseTransformationsRecursiveHelper(slate.concat(String.valueOf(input.charAt(index)).toUpperCase()), index + 1, input, result);
            }
        }
    }

    /**
     * TC = (2^N * N) and SC = O(N^2) // IMPROVED TIME COMPLEXITY
     * @param buffer
     * @param index
     * @param input
     * @param result
     */
    private static void enumerateCaseTransformationsRecursiveHelperImproved(final List<Character> buffer, final int index, final String input, final List<String> result) {
        if (index == input.length()) {
            result.add(buffer.toString());
        } else {
            if (Character.isDigit(input.charAt(index))) {
                buffer.add(input.charAt(index));
                enumerateCaseTransformationsRecursiveHelperImproved(buffer, index + 1, input, result);
                buffer.remove(buffer.size() - 1);
            } else {
                buffer.add(Character.toLowerCase(input.charAt(index)));
                enumerateCaseTransformationsRecursiveHelperImproved(buffer, index + 1, input, result);
                buffer.remove(buffer.size() - 1);

                buffer.add(Character.toUpperCase(input.charAt(index)));
                enumerateCaseTransformationsRecursiveHelperImproved(buffer, index + 1, input, result);
                buffer.remove(buffer.size() - 1);
            }
        }
    }

    private static void printAllSetsOfAnInputSet(final List<Integer> slate, final List<Integer> input, final int index) {
        if (index == input.size()) {
            System.out.println(slate);
        } else {
            slate.add(input.get(index));
            printAllSetsOfAnInputSet(slate, input,index+1);
            slate.remove(slate.size() - 1);
            printAllSetsOfAnInputSet(slate, input,index+1);
        }
    }

    private static void printAllSetsOfSizeKOfAnInputSet(final List<Integer> slate, final List<Integer> input, final int index, final Integer k) {
        if (slate.size() == k) {
            System.out.println(slate);
        } else if (index == input.size()) {
            return;
        } else {
            slate.add(input.get(index));
            printAllSetsOfSizeKOfAnInputSet(slate, input,index+1, k);
            slate.remove(slate.size() - 1);
            printAllSetsOfSizeKOfAnInputSet(slate, input,index+1, k);
        }
    }

    private static void enumerateAllSetsOfAnInputSet(final List<Integer> slate, final List<Integer> input, final int index,
                                                     final List<List<Integer>> result) {
        if (index == input.size()) {
            result.add(new ArrayList<>(slate));
        } else {
            slate.add(input.get(index));
            enumerateAllSetsOfAnInputSet(slate, input,index+1, result);
            slate.remove(slate.size() - 1);
            enumerateAllSetsOfAnInputSet(slate, input,index+1, result);
        }
    }
}
