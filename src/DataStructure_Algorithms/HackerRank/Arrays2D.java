package DataStructure_Algorithms.HackerRank;

import java.io.*;
import java.util.*;

public class Arrays2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int bigger = -63; // -9 * 7 = -63
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
               int top = arr[i][j] + arr[i][j+1] + arr[i][j+2] ;
               int mid = arr[i+1][j+1];
               int bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
               if(top+mid+bottom > bigger){
                   bigger = top+mid+bottom;
               }
            }

        }
        return bigger;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

       int result =  hourglassSum(arr);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}