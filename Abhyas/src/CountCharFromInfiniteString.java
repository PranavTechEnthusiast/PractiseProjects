import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result3 {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long noOfA = 0, size = s.length();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                ++noOfA;
            }
        }

        long multiplier = n / size;
        noOfA *= multiplier;
        long delta = n % size;

        if (size != 1 && delta != 0) {
            for (int i = 0; i < delta; i++) {
                if (chars[i] == 'a') {
                    ++noOfA;
                }
            }
        }

        return noOfA;
    }

}

public class CountCharFromInfiniteString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result3.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
