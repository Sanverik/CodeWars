package com.sanverik.codewars.kyu4.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Task: "Square into Squares. Protect trees!"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/54eb33e5bc1a25440d000891">CodeWars</a>
 */
public class Decompose {

    public String decompose(long n) {

        List<Long> decomposeArray = getDecomposeArray(n, n * n);

        if (decomposeArray == null) return "";

        decomposeArray.remove(decomposeArray.size() - 1);
        List<String> result = new ArrayList<>();

        for (Long ele : decomposeArray) {
            result.add(String.valueOf(ele.longValue()));
        }

        return String.join(" ", result);

    }

    public List<Long> getDecomposeArray(long n, long remain) {

        System.out.println(n + " " + remain);
        if (remain == 0) {
            List<Long> r = new ArrayList<>();
            r.add(n);
            return r;
        }

        for (long i = n - 1; i > 0; i--) {
            if ((remain - i * i) >= 0) {
                List<Long> r = getDecomposeArray(i, (remain - i * i));

                if (r != null) {
                    r.add(n);
                    return r;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(new Decompose().decompose(11));
        System.out.println(new Decompose().decompose(50));
    }
}
