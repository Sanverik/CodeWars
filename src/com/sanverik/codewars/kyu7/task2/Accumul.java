package com.sanverik.codewars.kyu7.task2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task: "Mumbling"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/5667e8f4e3f572a8f2000039">CodeWars</a>
 */
public class Accumul {

    public static String accum(String s) {

        StringBuilder sb;
        String[] strings = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuilder();

            // Add capital char
            Character chr = s.charAt(i);
            sb.append(chr.toString().toUpperCase());

            // repeat adding other
            for (int j = 0; j < i; j++) {
                sb.append(chr.toString().toLowerCase());
            }

            strings[i] = sb.toString();
        }

        String result = Arrays.stream(strings).collect(Collectors.joining("-"));


        return result;
    }


    public static void main(String[] args) {
        System.out.println(Accumul.accum("ZpglnRxqenU"));
        System.out.println(Accumul.accum("NyffsGeyylB"));
        System.out.println(Accumul.accum("MjtkuBovqrU"));
        System.out.println(Accumul.accum("EvidjUnokmM"));
        System.out.println(Accumul.accum("HbideVbxncC"));
    }
}
