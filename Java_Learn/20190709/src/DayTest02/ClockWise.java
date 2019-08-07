package DayTest02;

import java.util.Scanner;

/**
 * @Classname ClockWise
 * @Description TODO
 * @Date 2019/8/5 23:57
 * @Created by AppleTree
 */
public class ClockWise {

//    public ArrayList<Integer> printMatrix(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int circle = ((row < col ? row : col) - 1) >> 1 + 1;
//        for (int i = 0; i < circle; i++) {
//            for (int j = i; j < col - i; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            for (int j = i + 1; j < row - i; j++) {
//                System.out.print(matrix[j][col - 1 - i]);
//            }
//            for (int j = col - i - 2; (j >= i) && (row - i - 1 != i); j--) {
//                System.out.print(matrix[row - i - 1][j]);
//            }
//            for (int j = row - i - 2; (j > i) && (col - i - 1 != i); j++) {
//                System.out.print(matrix[j][i]);
//            }
//        }
//    }

    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int circle = (((row < col ? row : col) - 1) >> 1) + 1;
        for (int i = 0; i < circle; i++) {
            for (int j = i; j < col - i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            for (int j = i + 1; j < row - i; j++) {
                System.out.print(matrix[j][col - 1 - i] + " ");
            }
            for (int j = col - i - 2; (j >= i) && (row - i - 1 != i); j--) {
                System.out.print(matrix[row - i - 1][j] + " ");
            }
            for (int j = row - i - 2; (j > i) && (col - i - 1 != i); j--) {
                System.out.print(matrix[j][i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] ints = new int[4][4];
        int count = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = count;
                count += 1;
            }
        }
        printMatrix(ints);
    }

}
