package com.sanverik.codewars.kyu6.task3;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Task: "Tribonacci Sequence"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/556deca17c58da83c00002db">CodeWars</a>
 */
public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {

        // trivial
        if (n == 0) return new double[]{};
        if (n == 1) return new double[]{s[0]};
        if (n == 2) return new double[]{s[0], s[1]};
        if (n == 3) return new double[]{s[0], s[1], s[2]};

        //else

        double[] partOfResult = Stream.iterate(new double[]{s[0], s[1], s[2], s[0] + s[1] + s[2]}, it -> new double[]{it[1], it[2], it[3], it[1] + it[2] + it[3]})
                .mapToDouble(el -> el[3])
                .limit(n - 3)           // minus three start elements
                .toArray();

        double[] result = DoubleStream.concat(Arrays.stream(s), Arrays.stream(partOfResult)).toArray();

        return result;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Xbonacci().tribonacci(new double[]{1, 1, 1}, 10)));
        System.out.println(Arrays.toString(new Xbonacci().tribonacci(new double[]{0, 0, 1}, 10)));
        System.out.println(Arrays.toString(new Xbonacci().tribonacci(new double[]{0, 1, 1}, 10)));
    }
}
