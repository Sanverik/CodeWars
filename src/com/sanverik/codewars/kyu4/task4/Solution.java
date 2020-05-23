package com.sanverik.codewars.kyu4.task4;

/**
 * Task: "Range Extraction"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/51ba717bb08c1cd60f00002f">CodeWars</a>
 */
public class Solution {

    public static String rangeExtraction(int[] arr) {

        StringBuilder sb = new StringBuilder();

        int start = 0, end = 0;
        while (end < arr.length - 1) {

            if (arr[end] + 1 == arr[end + 1]) {
                end++;
            } else {
                switch (end - start) {
                    case 0:
                        sb.append(arr[start]).append(",");
                        break;
                    case 1:
                        sb.append(arr[start]).append(",");
                        sb.append(arr[start + 1]).append(",");
                        break;
                    default:
                        sb.append(arr[start]).append("-").append(arr[end]).append(",");
                        break;
                }

                end++;
                start = end;
            }
        }

        switch (end - start) {
            case 0:
                sb.append(arr[start]);
                break;
            case 1:
                sb.append(arr[start]);
                sb.append(arr[start + 1]);
                break;
            default:
                sb.append(arr[start]).append("-").append(arr[end]);
                break;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        System.out.println(Solution.rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
    }
}
