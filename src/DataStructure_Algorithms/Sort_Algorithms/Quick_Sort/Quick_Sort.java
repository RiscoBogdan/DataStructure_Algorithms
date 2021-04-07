package DataStructure_Algorithms.Sort_Algorithms.Quick_Sort;

public class Quick_Sort {
    int [] array = {5,2,3,4,6,8,12,14,4};
    //5 2 3 4 6 8 3 12 14 4
    //5 3 4 3 c4 8 2 12 i14 6
    //quicksort(from, counter-1)
    //ci5 3 4 3 => from = 0, pivot = array[counter-1] = array[3] = 3 verify if to <= from index 3 <= 0 => false , if is true that means i have only 1 element left in array which is sorted
    //5<=3? false
    //c5 i3 4 3
    //3<=3? true => swap(counter, i), counter ++
    //3 c5 i4 3
    //4<=3? false
    //3 c5 i4 3 => i<to true => out of for loop and swap c with pivot
    //3 c3 4 5
    //again quicksort(from, counter - 1) => if(to <= from) => true pos 0 = pos 0 return;
    public static void main(String[] args) {

        Quick_Sort quickSortt = new Quick_Sort();
        quickSortt.sort(quickSortt.array);
        quickSortt.print(quickSortt.array);
    }

    public void sort(int [] array){
        quickSort(0, array.length - 1);
    }

    public void quickSort(int from, int to){
        if(to <= from) return;
        int value = array[to]; // take pivot
        int counter = from; // counter start from 0
        for(int i = from; i < to; i++){
            if(array[i] <= value){
                swap(counter, i);
                counter++;
            }
        }
        swap(counter, to); //swap last counter with last element from array
        quickSort(from, counter - 1);
        quickSort(counter + 1, to);
    }


    public void swap(int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public void print(int [] array){
        for(int i = 0; i< array.length; i++){
            System.out.print(" "+array[i]);
        }
    }

}
