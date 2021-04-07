package DataStructure_Algorithms.HackerRank;

import java.io.IOException;
import java.util.Scanner;

public class ArrayLeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the rotLeft function below.
    static void rotLeft(int[] a, int d) {
        int [] arr = new int[a.length];
        for(int i = 0; i < a.length; i++){
            arr[i] = a[i];
        }
        int temp = 0;
        for (int rot = 0; rot < d; rot++) {
            for (int i = 0; i < arr.length-1; i++) {
                if(i == 0) {
                    temp = arr[i]; // 1
                }
                arr[i] = arr[i+1];
            }
            arr[arr.length - 1] = temp;
        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(" " + arr[i]);
        }


    }
    static int[] rotateLeftWithArrCopy(int[] a, int d) {
        int [] arr = new int[a.length];

        System.arraycopy(a, d, arr, 0, a.length - d);
        System.arraycopy(a, 0, arr,a.length -d , d);
        return arr;

    }


    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] a = new int[n];
//
//        String[] aItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a[i] = aItem;
//        }
        int[] ad = {1,2,3,4,5};
       rotLeft(ad, 3);
      int[] arrr = rotateLeftWithArrCopy(ad,3);
        System.out.println();
      for(int i = 0; i<arrr.length; i++){
          System.out.print(" " + arrr[i]);
      }
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
