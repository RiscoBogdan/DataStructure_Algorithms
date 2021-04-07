package DataStructure_Algorithms.HackerRank;

public class Factorial_Recursion {
    public static void main(String[] args) {
        int x = Recursion(5);
        System.out.println(x);

        //using for loop
        int result = 1;
        int number = 5;
        for (int i = 1; i<= number; i++){
            result *= i;
        }
        System.out.println(result);
    }
    static int Recursion(int n){
             if(n == 0 || n == 1){
                 return 1;
             }else return (n*(Recursion(n-1)));
    }
}
