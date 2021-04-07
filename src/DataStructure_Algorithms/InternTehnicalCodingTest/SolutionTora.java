package DataStructure_Algorithms.InternTehnicalCodingTest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Problem One
public class SolutionTora {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\DataStructure_Algorithms\\src\\Algorithms\\LeetCode\\one_second_show_sample.in"));
        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine);
        int n_array = Integer.parseInt(br.readLine());
        Scanner s = new Scanner(new File("D:\\DataStructure_Algorithms\\src\\Algorithms\\LeetCode\\one_second_show_sample.in"));
        int[] array = new int[s.nextInt()];
        for (int i = 0; i < n_array; i++) {
            array[i] = s.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
//        System.out.println(n);
//        System.out.println(n_array);
        int[] array1 = {7, 6, 3, 4, 1};
        int[] array2 = {7, 6, 4, 3, 1};
        int[] array3 = {7, 1, 5, 3, 6, 4};
        int result1 = fireWorks(array1);
        int result2 = fireWorks(array2);
        int result3 = fireWorks(array3);
        System.out.println("SHOW #1: " + result1);
        System.out.println("SHOW #2: " + result2);
        System.out.println("SHOW #3: " + result3);

    }

    public static int fireWorks(int[] array) {
        int n = array.length;
        int result = 0;
        int i = 0, j = 1;
        int temp = 0;

        while (i < n - 1) {
            if (array[j] > array[i]) {
                temp = array[j];
                while (j < n - 1) {
                    if (temp < array[++j]) {
                        temp = array[j];
                    }
                }
                return temp - array[i];
            }
            i++;
            j++;
        }


        return result;
    }
}
