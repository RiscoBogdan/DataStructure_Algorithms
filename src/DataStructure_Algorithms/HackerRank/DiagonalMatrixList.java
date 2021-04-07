package DataStructure_Algorithms.HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;



public class DiagonalMatrixList {
    public static int diagonalDifference(List<List<Integer>> arr) {
//        int leftDiag = 0, rightDiag = 0;
        int diagonal = 0;

        for(int i = 0; i < arr.size(); i++){
            //reading each row and column
            diagonal += arr.get(i).get(i);
            diagonal -= arr.get(i).get(arr.size() -(i+1));
        }

//        for(int i = 0; i < arr.size(); i++) {
//            //             get each row     get(size - i + 1)
//            rightDiag += arr.get(i).get(arr.size() - (i+1));
//            //i=0; row 0 , column: 3 - 0+1 = 2, column 2
//            //i=1; row 1 , column: 3 - 1+1 = 1, column 1
//            //i=2; row 2 , column: 3 - 2+1 = 0, column 0
//        }
//        return Math.abs(leftDiag-rightDiag);
        return Math.abs(diagonal);
    }
        public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\DataStructure_Algorithms\\src\\Algho\\HackerRank\\output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalMatrixList.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
