package com.sanverik.codewars.kyu6.task1;

/**
 * Task: "Multiples of 3 or 5"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/514b92a657cdc65150000006">CodeWars</a>
 */
public class Solution {

    public int solution(int number) {

        int result = 0, currentN = 1;

        while (currentN < number) {

            if (currentN % 3 == 0 || currentN % 5 == 0) {
                result += currentN;
            }

            currentN++;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(new Solution().solution(10));

    }
}