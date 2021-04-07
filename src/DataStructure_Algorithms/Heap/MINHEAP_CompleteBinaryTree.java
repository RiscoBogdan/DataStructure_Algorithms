package DataStructure_Algorithms.Heap;

public class MINHEAP_CompleteBinaryTree {
    int[] array;
    int lastposition;
    public MINHEAP_CompleteBinaryTree(int size){
        array = new int[size];
    }

    public void add(int obj){
        if(lastposition == array.length){
            throw new IndexOutOfBoundsException("Heap is full!" + " And has " +array.length +" elements.");
        }
        array[lastposition] = obj;
        heapify(lastposition); //trickleDown
        lastposition++;
    }
    public void swap(int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
    public void heapify(int position){
        if(position == 0) return;
        int parent = (position - 1) / 2;
        if(array[position] < array[parent]){
            swap(position, parent);
            heapify(parent);//vreau sa tot fac asta cu fiecare parinte;
        }
    }
    public void traverse(){
        for(int i = 0 ; i< array.length;i++ ){
//            if(array[i] == 0)return;
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MINHEAP_CompleteBinaryTree bh = new MINHEAP_CompleteBinaryTree(11);
        bh.add(7);
        bh.add(43);
        bh.add(56);
        bh.add(34);
        bh.add(58);
        bh.add(23);
        bh.add(5);
        bh.add(6);
        bh.add(30);
        bh.add(3);
        bh.add(14);

        bh.traverse();
        System.out.println("-----------------");
        bh.sort();
        bh.traverse();
    }

    public void sort(){
        for(int i = 0 ; i < array.length; i++) {
            lastposition--;
            swap(0, lastposition);
            trickleDownForSort(0);
        }

    }
    private void trickleDownForSort(int parent) {
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        if(lastposition == 1 && array[parent] > array[left]){
            swap(parent, left);
        }
//        if(left == lastposition && array[parent] <= array[left]){
//            swap(parent,left);
//            return;
//        }
//        if(right == lastposition && array[parent] <= array[right]){
//            swap(parent,right);
//            return;
//        }
        if(left >= lastposition || right >= lastposition) return;

        if (array[left] <= array[right] && array[parent] <= array[left]){
            swap(parent,left);
            trickleDownForSort(left);
            return;
        }
        else if(array[left] >= array[right]&& array[parent] <= array[left]){
            swap(parent,right);
            trickleDownForSort(right);
            return;
        }

    }
}
