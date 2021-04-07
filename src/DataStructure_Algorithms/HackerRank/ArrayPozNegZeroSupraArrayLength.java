package DataStructure_Algorithms.HackerRank;

import java.util.Scanner;

//arr [-4,2,0,-5,-8]
//length = n
public class ArrayPozNegZeroSupraArrayLength {
    public static void PlusMinus(int[] arr) {
        double countPos = 0, countNeg = 0, countZero = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                countPos +=1f;
            }else if(arr[i]<0){
                countNeg +=1f;
            }else if(arr[i] == 0){
                countZero +=1f;
            }
        }
        countPos /= arr.length;
        countNeg /= arr.length;
        countZero /= arr.length;
        System.out.format("%.6f\n", countPos);
        System.out.format("%.6f\n", countNeg);
        System.out.format("%.6f", countZero);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i<arr.length;i++){
            System.out.print("Number "+ i+ " -> ");
            arr[i] = scanner.nextInt();
        }
        PlusMinus(arr);
        scanner.close();
    }
}
