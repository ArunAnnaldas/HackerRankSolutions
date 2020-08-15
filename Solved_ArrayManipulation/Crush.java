import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Crush {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        int[] res = new int[n];

        for(int i=0; i<n; i++){
            res[i]=0;
        }

        int a, b;
        long k;
                
            for(int i = 0; i < queries.length; i++) {
                a=queries[i][0];
                b=queries[i][1];
                k=queries[i][2];
                res[a-1] += k;
                if(b < n) {
                    res[b] -= k;
                }
            }

            long answer=0, updatedValue=0;
            for(int i=0; i<n; i++){
                updatedValue+=res[i];
                if(updatedValue>answer){
                    answer=updatedValue;
                }
            }

        return answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
