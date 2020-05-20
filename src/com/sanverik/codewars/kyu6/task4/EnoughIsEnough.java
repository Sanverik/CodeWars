package com.sanverik.codewars.kyu6.task4;

import java.util.*;

/**
 * Task: "Delete occurrences of an element if it occurs more than n times"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/554ca54ffa7d91b236000023">CodeWars</a>
 */
public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] result = Arrays.stream(elements)
                .filter(e -> map.merge(e, 1, Integer::sum) <= maxOccurrences)
                .toArray();

        return result;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)));
        System.out.println(Arrays.toString(deleteNth(new int[]{20, 37, 20, 21}, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)));
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 1, 1, 1, 1}, 5)));
        System.out.println(Arrays.toString(deleteNth(new int[]{}, 5)));
    }
}
