package DataStructure_Algorithms.HackerRank;

public class SortDsc {
    public static void main(String[] args) {
        //Initialize array
        int[] arr = new int[]{8,12,5,7,15,9,4};
        //12,8,5,7..

        Sort(arr);
        Display(arr);
    }
    static void Display(int [] arr){
        //Display sum of even numbers
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j % 2 == 0) {
                sum += arr[j];
            }else{
                sum += 0;
            }
        }
            System.out.println("\nSum of even numbers is: "+sum);
    }
    static void Sort(int[]arr){
        int temp = 0;
        //Sort the array in descending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted descending array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}






