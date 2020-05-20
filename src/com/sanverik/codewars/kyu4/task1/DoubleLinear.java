package com.sanverik.codewars.kyu4.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Task: "Twice linear"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/5672682212c8ecf83e000050">CodeWars</a>
 */
public class DoubleLinear {


    public static int dblLinear(int n) {

        Set<Integer> resultSet = new TreeSet<>();
        Set<Integer> prevSet = new HashSet<>();
        Set<Integer> currentSet = new HashSet<>();

        prevSet.add(1);

        while (resultSet.size() <= 8 * n) {

            currentSet.clear();
            for (Integer element : prevSet) {
                currentSet.add(2 * element + 1);
                currentSet.add(3 * element + 1);
            }

            resultSet.addAll(prevSet);
            prevSet.clear();
            prevSet.addAll(currentSet);

        }
        return new ArrayList<>(resultSet).get(n);
    }

    public static void main(String[] args) {

        System.out.println(DoubleLinear.dblLinear(10));
        System.out.println(DoubleLinear.dblLinear(20));
        System.out.println(DoubleLinear.dblLinear(30));
        System.out.println(DoubleLinear.dblLinear(50));

    }
}
