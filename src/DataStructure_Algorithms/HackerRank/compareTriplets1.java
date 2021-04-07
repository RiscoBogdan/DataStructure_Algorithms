package DataStructure_Algorithms.HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class compareTriplets1 {
     //Compare and if they are the same, add
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List <Integer> result = new ArrayList<>();
        int aliceScore = 0;
        int bobScore = 0;
        for(int i = 0; i< a.size(); i++){
            if(a.get(i) > b.get(i)){
                aliceScore += 1;
            }else if(a.get(i) < b.get(i)){
                bobScore += 1;
            }
        }
       result.add(0, aliceScore);
        result.add(1,bobScore);
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);
        try {
            FileWriter myWriter = new FileWriter("D:\\DataStructure_Algorithms\\src\\Algho\\HackerRank\\output.txt");
            myWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
            bufferedReader.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}
