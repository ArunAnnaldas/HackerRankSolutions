import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result1 {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
      
        List<Integer> result= new ArrayList<>();
        int lastAnswer =0;
        int count=0;

        List<List<Integer>> generalList = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> myGroup = new ArrayList<>();
            generalList.add(myGroup);
        }
      
        int temp;
        int arrayIndex=0;
        for(int i =0;i<queries.size();i++){
            if(queries.get(i).get(0)==1){
                temp = (queries.get(i).get(1)^lastAnswer)%n;
                generalList.get(temp).add(queries.get(i).get(2));
            }
            else{
                temp = (queries.get(i).get(1)^lastAnswer)%n;
                lastAnswer=generalList.get(temp).get(queries.get(i).get(2)%generalList.get(temp).size());
                System.out.println(lastAnswer);
                result.add(lastAnswer);
            }
        }
        return result;
    }
}

public class DynamicArray_HR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result1.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
