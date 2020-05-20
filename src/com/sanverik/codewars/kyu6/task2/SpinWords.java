package com.sanverik.codewars.kyu6.task2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task: "Stop gninnipS My sdroW!"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/5264d2b162488dc400000001">CodeWars</a>
 */
public class SpinWords {

    public String spinWords(String sentence) {

        String result = Arrays.stream(sentence.split(" "))
                .map(SpinWords::compute)
                .collect(Collectors.joining(" "));

        return result;
    }

    public static String compute(String input){
        if (input.length() < 5){
            return input;
        } else {
            return new StringBuilder(input).reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SpinWords().spinWords("Hey fellow warriors"));
        System.out.println(new SpinWords().spinWords("This is a test"));
        System.out.println(new SpinWords().spinWords("This is another test"));
    }
}