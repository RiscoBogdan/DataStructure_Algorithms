package DataStructure_Algorithms.Sort_Algorithms.Insertion_Sort;
//Worst case: O(n^2)
//Average case: O(n^2)
//Best case: O(n) - if list is already sorted!!!

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort Insertion = new InsertionSort();
        int [] array = {7,8,6,3,9};
        Insertion.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    public void sort(int [] array){
        int n = array.length;
        for(int i = 0; i<n; i++){
            int v = array[i];
            int j;
            for(j = i-1; j>=0; j--){
                if( array[j] <= v) break;
                array[j+1] = array[j];

            }
            array[j+1] = v;
        }
    }
}
