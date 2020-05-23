package com.sanverik.codewars.kyu4.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task: "Permutations"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/5254ca2719453dcc0b00027d">CodeWars</a>
 */
public class Permutations {

    public static List<String> singlePermutations(String s) {

        Map<Character, Integer> map = new TreeMap<>();
        for (Character chr : s.toCharArray()) {
            map.compute(chr, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }

        char[] str = new char[map.size()];
        int[] count = new int[map.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[s.length()];
        permuteUtil(str, count, result, 0, resultList);

        return resultList;
    }

    private static void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    public static void main(String[] args) {

        System.out.println(Permutations.singlePermutations("abcvdd"));
    }
}
