package com.sanverik.codewars.kyu6.task6;

/**
 * Task: "Highest Scoring Word"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/57eb8fcdf670e99d9b000272">CodeWars</a>
 */
import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static String high(String s) {

        Map<String, Integer> table = new HashMap<>();

        for (String word : s.split(" ")) {
            int accum = 0;
            for (char ch : word.toCharArray()) {
                accum += ch - 96;
            }
            table.put(word, accum);
        }


        int max = -1;
        int v = 0;
        String res = "";
        for (String key : table.keySet()) {

            v = table.get(key);
            if (v > max) {
                res = key;
                max = v;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(Kata.high("man i need a taxi up to ubud"));
        System.out.println(Kata.high("what time are we climbing up to the volcano"));
        System.out.println(Kata.high("take me to semynak"));
    }
}
