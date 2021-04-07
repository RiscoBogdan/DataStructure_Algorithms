package DataStructure_Algorithms.HackerRank;

import java.util.Scanner;

public class StairCase {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n - i ; j++) {
                System.out.print(" ");
            }
            for(int k = 1; k<=i-1;k++ ) {
                System.out.print("#");
            }
                System.out.println("#");
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("#");
            }
            System.out.println(" ");
        }

        String str= "#";
        for(int i =0;i<n;i++){
            System.out.printf("%"+n+"s\n",str);
            str+="#";
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }

}


