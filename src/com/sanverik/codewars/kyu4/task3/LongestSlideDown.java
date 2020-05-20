package com.sanverik.codewars.kyu4.task3;

import java.util.Arrays;

/**
 * Task: "Pyramid Slide Down"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/551f23362ff852e2ab000037">CodeWars</a>
 */
public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int[][] myPathPyramid = new int[pyramid.length][];

        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                myPathPyramid[i] = new int[pyramid[i].length];
            }
        }

        myPathPyramid[0][0] = pyramid[0][0];

        for (int i = 1; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                if (j < myPathPyramid[i - 1].length) {
                    myPathPyramid[i][j] = Math.max(myPathPyramid[i - 1][j] + pyramid[i][j], myPathPyramid[i][j]);
                }
                if (j > 0) {
                    myPathPyramid[i][j] = Math.max(myPathPyramid[i - 1][j - 1] + pyramid[i][j], myPathPyramid[i][j]);
                }

                if (j < myPathPyramid[i - 1].length - 1) {
                    myPathPyramid[i][j] = Math.max(myPathPyramid[i - 1][j + 1] + pyramid[i][j], myPathPyramid[i][j]);
                }
            }
        }


        for (int i = 0; i < pyramid.length; i++) {
            System.out.println(Arrays.toString(myPathPyramid[i]));
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(LongestSlideDown.longestSlideDown(new int[][]
                {
                        {45},
                        {27, 36},
                        {0, 28, 40},
                        {51, 84, 63, 62}
                }));
    }
}
