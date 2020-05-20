package com.sanverik.codewars.kyu7.task1;

import java.util.stream.Stream;

/**
 * Task: "Sum of odd numbers"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/55fd2d567d94ac3bc9000064">CodeWars</a>
 */
public class RowSumOddNumbers {

    public static int rowSumOddNumbers(int n) {

        int firstNumberInRow = Stream.iterate(new int[]{1, 1}, next -> new int[]{next[0] + 1, next[1] + 2 * (next[0])})
                .mapToInt(el -> el[1])
                .limit(n)
                .reduce((first, second) -> second).getAsInt();


        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += firstNumberInRow + 2*i;
        }

        return sum;
    }


    public static void main(String[] args) {

        System.out.println(RowSumOddNumbers.rowSumOddNumbers(1));
        System.out.println(RowSumOddNumbers.rowSumOddNumbers(42));
    }
}
