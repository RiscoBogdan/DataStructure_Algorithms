package DataStructure_Algorithms.InternTehnicalCodingTest;

import static java.util.stream.Collectors.joining;
//Not Working

class Result {

    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encoded as parameter.
     */

    public static String decode(String encoded) {
        int asciicode = 0;
        int reversed =0;
        String s = "";
        String space = "^\\s*$";
        char [] ch = new char[encoded.length()];
        for(int i = 0; i < encoded.length(); i++){
            ch[i] = encoded.charAt(i);


        }
        for(int i = 0; i < ch.length; i++){
            asciicode = encoded.charAt(i);
            s += String.valueOf(asciicode);
        }

        String result = "";
        for(int i = s.length() -1 ; i>=0; i--){
            result += s.charAt(i);
        }
        System.out.println(result);
        return result;
    }

}

public class TehnicalTest {
    public static void main(String[] args)  {
       String x = "code";
       Result.decode(x);

    }
}

