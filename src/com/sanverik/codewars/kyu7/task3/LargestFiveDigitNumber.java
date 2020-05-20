package com.sanverik.codewars.kyu7.task3;

/**
 * Task: "Largest 5 digit number in a series"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/51675d17e0c1bed195000001">CodeWars</a>
 */
public class LargestFiveDigitNumber {

    public static int solve(final String digits) {

        int result = 0;
        for (int i = 0; i <= digits.length() - 5; i++) {
            String substring = digits.substring(i, i + 5);
            int intSubstring = Integer.parseInt(substring);
            result = Math.max(result, intSubstring);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(LargestFiveDigitNumber.solve("283910"));
        System.out.println(LargestFiveDigitNumber.solve("1234567890"));
    }
}
