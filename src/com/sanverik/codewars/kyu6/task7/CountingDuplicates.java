package com.sanverik.codewars.kyu6.task7;

import java.util.HashMap;
import java.util.Map;

/**
 * Task: "Counting Duplicates"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1">CodeWars</a>
 */
public class CountingDuplicates {

    public static int duplicateCount(String text) {

        Map<Character, Boolean> table = new HashMap<>();

        for (Character rawChar : text.toCharArray()) {
            Character ch = Character.toLowerCase(rawChar);
            if (!table.containsKey(ch)) {
                table.put(ch, false);
            } else {
                table.put(ch, true);
            }
        }

        int result = 0;
        for (Character ch : table.keySet()) {
            if (table.get(ch)) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(CountingDuplicates.duplicateCount("abcde"));
        System.out.println(CountingDuplicates.duplicateCount("abcdea"));
        System.out.println(CountingDuplicates.duplicateCount("indivisibility"));
        System.out.println(CountingDuplicates.duplicateCount("Indivisibilities"));
        System.out.println(CountingDuplicates.duplicateCount("aA11"));
        System.out.println(CountingDuplicates.duplicateCount("ABBA"));
    }
}
