package DataStructure_Algorithms.HackerRank;

import java.util.Scanner;

public class MinMaxInteger {
    private static final Scanner scanner = new Scanner(System.in);

    //make big sum when lower element is deleted/ignored
    //make small sum when biggest element is deleted/ignored
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long maxValue = 0;
        long minValue = arr[0];
        long sumOfArray = 0;
        for (int max : arr) {
            if (max > maxValue) {
                maxValue = max;
            }
        }
        for (int min : arr) {
            if (min < minValue) {
                minValue = min;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sumOfArray += arr[i];
        }

        System.out.println((sumOfArray - maxValue) +" "+ (sumOfArray - minValue));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Number " + i + " -> ");
            arr[i] = scanner.nextInt();
        }
        miniMaxSum(arr);
        scanner.close();


    }
}

