package DataStructure_Algorithms.InternTehnicalCodingTest;


class Winnow_Test {
    public static void main(String[] args) {
        String s = "cdeenetpi";
        int[] arr = {5,2,0,1,6,4,8,3,7};
        Winnow_Test t = new Winnow_Test();
        String s1 = "bytdag";
        int[] arr1 = {4,3,0,1,2,5};
        String s2 = "cdeo";
        int[] arr2 = {3,2,0,1};
        System.out.println("Thanks for reading:)");
        System.out.println(s2+" --> "+t.solution(s2, arr2));
        System.out.println(s+" --> "+t.solution(s, arr));
        System.out.println(s1+" --> "+t.solution(s1, arr1));


    }
    //Problem 1
    public String solution(String s, int[] A) {
        char[] ch = s.toCharArray();
        String result = "";
        int i = 0;
        result += ch[i];
        while (A[i] != 0) {
            int temp = A[i];
            result += ch[temp];
            i = temp;
        }
        return result;
    }

}


//
//    public static void main(String[] args) {
//        Test t = new Test();
//
//        System.out.println(t.solution(18, 10));
//    }
//
//    public int solution(int n, int k) {
//        int rounds = 0;
//        while (n > 1) {
//            if (n % 2 == 0 && k > 0) {
//                n = n / 2;
//                k--;
//            } else {
//                n--;
//            }

//            rounds++;
//        }
//        return rounds;
//    }