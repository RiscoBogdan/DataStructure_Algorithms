package DataStructure_Algorithms.Test;
class House{
    String color;
    public House(String color){
        this.color = color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }

}
class Test {
    public static void main(String[] args) {
//        Test t = new Test();
//        int[] arr = {-4, -2, -1, 2, 3, 6, 6, 7};
//
//        t.BinaryS(arr, 3);

        House bluehouse = new House("blue");
        House greenhouse;
        greenhouse = bluehouse;
        greenhouse.setColor("Green");
        System.out.println(bluehouse.getColor());
        System.out.println(greenhouse.getColor());
    }

    public void BinaryS(int[] arr, int x) {
        int result = binarySearch(arr, 0, arr.length - 1, x);
        int result2 = IterativeBinarySearch(arr, x);
        if (result2 == -1 && result == -1) {
            System.out.println(x + " was not found in array!");
        } else {
            System.out.println("was found!");
        }
    }

    public int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) return mid;

            if (x < arr[mid]) { // to left
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
            //otherwise go right
        }
        return -1;
    }

    public int IterativeBinarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int mid = (l + r) / 2;

            if (arr[mid] == x) {//found at mid
                return mid;
            }

            if (x < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;


    }

}