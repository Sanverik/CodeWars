package com.sanverik.codewars.kyu5.task4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Task: "Weight for weight"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/55c6126177c9441a570000cc">CodeWars</a>
 */
public class WeightSort {

    public static String orderWeight(String strng) {

        String[] strWeights = strng.split(" ");

        Arrays.sort(strWeights, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                int i1 = s1.chars().map(Character::getNumericValue).sum();
                int i2 = s2.chars().map(Character::getNumericValue).sum();


                return i1 - i2 != 0 ? i1 - i2 : s1.compareTo(s2);
            }
        });

        return String.join(" ", strWeights);
    }

    public static void main(String[] args) {
        System.out.println(WeightSort.orderWeight("103 123 4444 99 2000"));
        System.out.println(WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));

    }
}
