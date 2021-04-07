package DataStructure_Algorithms.HackerRank;

import java.util.Scanner;


public class DiagonalMatrixReturnAbsoluteValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] Matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix dimension " + m + " * " + n);

        for (int[] Show : Matrix) {
            for (int i : Show) {
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }

      int left =  LeftDiag(Matrix,m,n);
      int right =  RightDiag(Matrix,m,n);
      System.out.println("The difference is: "+Difference(left,right));

    }


    public static int LeftDiag(int[][] Matrix, int m, int n) {
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Matrix[i] == Matrix[j]) {
                    result += Matrix[i][j];
                }
            }
        }
        System.out.println("First diagonal sum is: " + result);
        return result;
    }

    public static int RightDiag(int[][] Matrix, int m, int n) {
        int resultLeft = 0;
        int holder = n - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= holder; j++) {
                if (j == holder) {
                    resultLeft += Matrix[i][j];
                }
            }
            holder--;
        }
        System.out.println("Other Diagonal sum is: " + resultLeft);
        return resultLeft;
    }
    public static int Difference(int left, int right){
        return Math.abs(left-right);
    }


}
