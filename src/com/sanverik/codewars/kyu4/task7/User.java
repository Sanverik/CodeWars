package com.sanverik.codewars.kyu4.task7;

import java.util.List;

/**
 * Task: "Codewars style ranking system"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/51fda2d95d6efda45e00004e">CodeWars</a>
 */
public class User {

    private static List<Integer> validRanks = List.of(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);
    public int rank = -8;
    public int progress = 0;

    public User() {
    }

    public void incProgress(int activityRank) {

        if (!validRanks.contains(activityRank)) {
            throw new IllegalArgumentException();
        }

        int i = validRanks.indexOf(rank);
        int j = validRanks.indexOf(activityRank);

        int d = j - i;

        if (d > -2) {
            switch (d) {
                case -1:
                    progress = progress + 1;
                    break;
                case 0:
                    progress = progress + 3;
                    break;
                default:
                    progress = progress + 10 * d * d;
                    break;
            }
        }
        // maximum rank do nothing
        if (rank == 8 || 8 == validRanks.get(i + progress / 100)) {

        } else {
            // rank up
            try {
                rank = validRanks.get(i + progress / 100);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }

            progress %= 100;
        }
    }
}