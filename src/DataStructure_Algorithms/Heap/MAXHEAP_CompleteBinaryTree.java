package DataStructure_Algorithms.Heap;

public class MAXHEAP_CompleteBinaryTree {
    int lastposition;
    int[] array;

    public MAXHEAP_CompleteBinaryTree(int size) {
        array = new int[size];
    }

    public static void main(String[] args) {
        MAXHEAP_CompleteBinaryTree bh = new MAXHEAP_CompleteBinaryTree(8);
        bh.add(16);
        bh.add(10);
        bh.add(5);
        bh.add(15);
        bh.add(12);
        bh.add(7);
        bh.add(25);
        bh.add(32);

        bh.traverse();

        System.out.println("-----------------");
//        bh.sort();
        bh.remove();
        bh.remove();
        bh.remove();
        bh.remove();
        bh.remove();
        bh.remove();
        bh.remove();
        bh.remove();

        bh.remove();
        bh.traverse();

    }

    public void remove(){

        int temp = array[0];
        lastposition--;
        if(lastposition == -1){
            throw new ArrayIndexOutOfBoundsException("Empty Array! Nothing to remove!");
        }
       swap(0,lastposition);
       trickleDown(0);

       array[lastposition] = 0;
        System.out.println("removed item is: " + temp);

    }

    public void sort(){
        for(int i = 0 ; i < array.length; i++) {
            lastposition--;
            swap(0, lastposition);
            trickleDownForSort(0);
        }

    }
    public boolean contains(int data){
        for(int i = 0; i<array.length;i++){
            if(array[i] == data){
                System.out.println("True");
                return true;
            }
        }
        System.out.println("False");
        return false;
    }
    private void trickleDownForSort(int parent) {
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        if(lastposition == 1 && array[parent] > array[left]){
            swap(parent, lastposition);
        }
        if(left == lastposition){
//            swap(parent,left);
            return;
        }
        if(right == lastposition){
//            swap(parent,right);
            return;
        }
        if(left >= lastposition || right >= lastposition) return;

        if (array[left] >= array[right] && array[parent] <= array[left]){
            swap(parent,left);
            trickleDownForSort(left);
            return;
        }
        else if(array[left] <= array[right]&& array[parent] <= array[left]){
            swap(parent,right);
            trickleDownForSort(right);
            return;
        }

    }
    public void trickleDown(int parent){
        int left = 2*parent + 1;
        int right = 2*parent + 2;

        if(left == lastposition){
            return;
        }
        if(right == lastposition ){
            return;
        }
        if(right >= lastposition || left >= lastposition){
            return;
        }
        if(array[left] > array[right] && array[parent] < array[left]){
            swap(parent, left);
            trickleDown(left);

        }
        if(array[left] < array[right] && array[parent] < array[right]){
            swap(parent, right);
            trickleDown(right);

        }
    }

    public void add(int obj) {
        if (isfull()) {
            throw new IndexOutOfBoundsException("Heap is full!" + " And has " + array.length + " elements.");
        }
        array[lastposition] = obj;
        trickleUp(lastposition);
        lastposition++;
    }

    private boolean isfull() {
        return lastposition == array.length;
    }

    public void swap(int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public void trickleUp(int position) {
        if (position == 0) return;
        int parent = (position - 1) / 2;
        if (array[position] > array[parent]) {
            swap(position, parent);
            trickleUp(parent);
        }
    }


    public void traverse() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) return;
            System.out.println(array[i]);
        }

    }
}
