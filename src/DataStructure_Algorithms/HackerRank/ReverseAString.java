package DataStructure_Algorithms.HackerRank;
//String Builder
//Manually
public class ReverseAString {
    public static void main(String[] args) {
        //String Builder
//        StringBuilder str = new StringBuilder("New String to Reverse");
//        System.out.println(str);
//        StringBuilder reversed = str.reverse();
//        System.out.println(reversed);
        String str = "Hello World!";
       // System.out.println(MethodsToReverseStr(str));
        //Manually
        System.out.println(ReverseManually(str));
    }
    public static String MethodsToReverseStr(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static String ReverseManually(String str){
        StringBuilder sb = new StringBuilder();//create a StringBuilder to store every character reversed
        //if i use a normal String it will create a instance every time we return a character to the current string
        //With StringBuilder we create only 1 instance and we can modify there and in final will create one instance to return toString();
        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));

        }
       return sb.toString();
    }
}
