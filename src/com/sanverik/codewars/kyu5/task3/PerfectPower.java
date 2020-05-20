package com.sanverik.codewars.kyu5.task3;

import java.util.Arrays;

/**
 * Task: "What's a Perfect Power anyway?"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/54d4c8b08776e4ad92000835">CodeWars</a>
 */
public class PerfectPower {
    public static int[] isPerfectPower(int n) {

        int limit1 = (int) Math.sqrt(n);
        int limit2 = log2(n);
        for (int i = 2; i <= limit1; i++){
            for (int j = 2; j <= limit2; j++){
                int expN = (int) (Math.pow(i, j));

                if (expN == n){
                    return new int[]{i, j};
                } else if (expN > n){
                    break;
                }
            }
        }

        return null;
    }

    public static int log2(int x){
        return (int) Math.ceil(Math.log(x)/Math.log(2));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(0)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(1)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(2)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(3)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(4)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(8)));
        System.out.println(Arrays.toString(PerfectPower.isPerfectPower(9)));
    }
}
