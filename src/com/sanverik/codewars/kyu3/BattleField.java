package com.sanverik.codewars.kyu3;

/**
 * Task: "Battleship field validator"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7">CodeWars</a>
 */
public class BattleField {

    // 1x 4 cells
    // 2x 3 cells
    // 3x 2 cells
    // 4x 1 cell


    private static int battleship = 1;
    private static int cruisers = 2;
    private static int destroyers = 3;
    private static int submarines = 4;
    private static boolean wrongShip = false;

    public static boolean fieldValidator(int[][] field) {

        int countCells = 0;

        // valid positions
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
                    countCells++;
                    if (!checkNeighbors(field, i, j)) {
                        return false;
                    }
                }
            }
        }

        // fast test
        if (countCells != 20) return false;


        // count each type of ships
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {

                if (field[i][j] == 1) {
                    int count = 1;
                    field[i][j] = 0;

                    if (j < field.length - 1 && field[i][j + 1] == 1) {
                        // move left
                        int tmpJ = j;
                        while (true) {
                            if (tmpJ < field.length - 1 && field[i][tmpJ + 1] == 1) {
                                field[i][tmpJ + 1] = 0;
                                count++;
                                tmpJ++;
                            } else {
                                break;
                            }
                        }
                    } else if (i < field.length - 1 && field[i + 1][j] == 1) {
                        // move down
                        int tmpI = i;
                        while (true) {
                            if (tmpI < field.length - 1 && field[tmpI + 1][j] == 1) {
                                field[tmpI + 1][j] = 0;
                                count++;
                                tmpI++;
                            } else {
                                break;
                            }
                        }
                    }

                    changeShipCount(count);
                }
            }
        }

        if (!wrongShip && submarines == 0 && destroyers == 0 && cruisers == 0 && battleship == 0) {
            return true;
        } else {
            return false;
        }

    }


    public static void changeShipCount(int nCells) {
        switch (nCells) {
            case 1:
                submarines--;
                break;
            case 2:
                destroyers--;
                break;
            case 3:
                cruisers--;
                break;
            case 4:
                battleship--;
                break;
            default:
                wrongShip = true;
                break;
        }
    }

    public static boolean checkNeighbors(int[][] field, int x, int y) {

        int count = 0;

        // check bottom
        if (x < field.length - 1) {
            count += field[x + 1][y];
        }

        // left bottom
        if (x < field.length - 1 && y > 1) {
            count += 2 * field[x + 1][y - 1];
        }

        //check right bottom
        if (x < field.length - 1 && y < field.length - 1) {
            count += 2 * field[x + 1][y + 1];
        }

        // check left
        if (y < field.length - 1) {
            count += field[x][y + 1];
        }

        // if only right or bottom
        if (count > 1) {
            return false;
        } else return true;

    }

    public static void main(String[] args) {
        System.out.println(BattleField.fieldValidator(new int[][]
                {{1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
