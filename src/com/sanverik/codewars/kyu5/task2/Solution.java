package com.sanverik.codewars.kyu5.task2;

/**
 * Task: "Number of trailing zeros of N!"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/52f787eb172a8b4ae1000a34">CodeWars</a>
 */
public class Solution {
    public static int zeros(int n) {

        int result = 0, ratio = n / 5;
        while (ratio != 0){
            result += ratio;
            ratio /= 5;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Solution.zeros(0));
//        System.out.println(Solution.zeros(6));
//        System.out.println(Solution.zeros(12));
        System.out.println(Solution.zeros(2000));
    }
}