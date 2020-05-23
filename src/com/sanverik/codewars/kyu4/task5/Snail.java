package com.sanverik.codewars.kyu4.task5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Task: "Snail"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1">CodeWars</a>
 */
public class Snail {

    public static int[] snail(int[][] array) {

        if (array[0].length == 0) {
            return new int[]{};
        }

        int n = array.length;
        String direction = "right";
        ArrayList<Integer> result = new ArrayList<>(n * n);

        int imin = 0, jmin = 0;
        int imax = n - 1, jmax = n - 1;

        while (!(imin > imax || jmin > jmax)) {
            switch (direction) {
                case "right":
                    for (int j = jmin; j <= jmax; j++) {
                        result.add(array[imin][j]);
                    }
                    direction = "down";
                    imin++;
                    break;
                case "down":
                    for (int i = imin; i <= imax; i++) {
                        result.add(array[i][jmax]);
                    }
                    direction = "left";
                    jmax--;
                    break;
                case "left":
                    for (int j = jmax; j >= jmin; j--) {
                        result.add(array[imax][j]);
                    }
                    direction = "up";
                    imax--;
                    break;
                case "up":
                    for (int i = imax; i >= imin; i--) {
                        result.add(array[i][jmin]);
                    }
                    direction = "right";
                    jmin++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Snail.snail(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                })));

        System.out.println(Arrays.toString(Snail.snail(new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                })));
    }
}