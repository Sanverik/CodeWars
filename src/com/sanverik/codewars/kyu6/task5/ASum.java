package com.sanverik.codewars.kyu6.task5;

public class ASum {


    // Sum 1^3 + 2^3 + 3^3 ... + n^3 = ((n*(n-1))/2)^2
    public static long findNb(long m) {

        long res = -1, i = 0, sum = 0;

        while (sum < m) {

            i++;
            sum += i * i * i;

            if (sum == m) {
                res = i;
                break;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(ASum.findNb(4183059834009L));
        System.out.println(ASum.findNb(24723578342962L));
        System.out.println(ASum.findNb(135440716410000L));
        System.out.println(ASum.findNb(40539911473216L));
        System.out.println(ASum.findNb(1071225));
        System.out.println(ASum.findNb(91716553919377L));
        System.out.println(ASum.findNb(2172677945680435601L));
    }

}
