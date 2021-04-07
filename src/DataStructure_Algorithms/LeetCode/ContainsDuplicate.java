package DataStructure_Algorithms.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cont = new ContainsDuplicate();
        int [] arr = new int[]{3,2,1,4,5,8,5};
        System.out.println(cont.hasDuplicate(arr));
        System.out.println(cont.DuplicWithSort(arr));
        System.out.println(cont.containsDupWithHash(arr));

    }
    // O(n^2) time complexity4
    public boolean hasDuplicate(int [] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j< arr.length; j++){
                if(arr[i] == arr[j]){
                return true;
                }
            }
        }
        return false;
    }
   // O(n Log n) time complexity
    public boolean DuplicWithSort(int [] arr){
        Arrays.sort(arr);
//      QuickSort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]) return true;
        }
        return false;
    }
    public boolean containsDupWithHash(int [] arr){
        HashSet<Integer> myHash = new HashSet<>(arr.length);
        for(int i = 0; i< arr.length; i++){
            if(myHash.contains(arr[i])){
                return true;
            }
            myHash.add(arr[i]);
        }
        return false;
    }
    //QuickSort*************Start
//    public void QuickSort(int [] arr){
//        quicksort(arr,0, arr.length - 1);
//    }
//     public void quicksort(int[] arr, int from, int to){
//        if(from >= to) return;
//        int pivot = arr[to];
//        int current = from;
//
//        for(int i = from; i < to; i++){
//            if(arr[i] <= pivot){
//                swap(arr, i, current);
//                current++;
//            }
//        }
//        swap(arr, current, to);
//        quicksort(arr, from, current-1);
//        quicksort(arr, current + 1, to);
//     }
//     public void swap(int [] arr, int from, int to){
//        int temp = arr[from];
//        arr[from] = arr[to];
//        arr[to] = temp;
//     }
    //QuickSort*************End
}
