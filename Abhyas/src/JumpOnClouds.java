import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;
/*
 * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on
 * any cumulus cloud having a number that is equal to the number of the current cloud plus or . The player must avoid the thunderheads. Determine the minimum
 * number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.
 * 
 * For each game, you will get an array of clouds numbered if they are safe or if they must be avoided.
 * 
 * Example
 * 
 * Index the array from . The number on each cloud is its index in the list so the player must avoid the clouds at indices and . They could follow these two
 * paths: or . The first path takes jumps while the second takes . Return .
 * 
 * Function Description
 * 
 * Complete the jumpingOnClouds function in the editor below.
 * 
 * jumpingOnClouds has the following parameter(s):
 * 
 * int c[n]: an array of binary integers
 * Returns
 * 
 * int: the minimum number of jumps required
 * Input Format
 * 
 * The first line contains an integer , the total number of clouds. The second line contains space-separated binary integers describing clouds where .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print the minimum number of jumps needed to win the game.
 * 
 * Sample Input 0
 * 
 * 7
 * 0 0 1 0 0 1 0
 * Sample Output 0
 * 
 * 4
 * Explanation 0:
 * The player must avoid c[2] and c[5]. The game can be won with a minimum of jumps:
 * 
 * jump(2).png
 * 
 * Sample Input 1
 * 
 * 6
 * 0 0 0 0 1 0
 * Sample Output 1
 * 
 * 3
 */

class Result2 {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int shortestJumps = 0, size = c.size();
        for (int i = 0; i < size; i++) {
            if (c.get(i) == 1) {
                continue;
            }
            if (i < size - 2 && c.get(i + 2) == 0) {
                ++shortestJumps;
                i++;
            }
            else if (i < size - 1 && c.get(i + 1) == 0) {
                ++shortestJumps;
            }
        }
        /*
         * int j=0;
         * do{
         * if(j<size-2 && c.get(j+2)==0){
         * ++shortestJumps;
         * j+=2;
         * }
         * else if(j< size-1 && c.get(j+1)==0){
         * ++shortestJumps;
         * j+=1;
         * }
         * else if(c.get(j)==1)
         * continue;
         * }
         * while(j<size);
         */
        return shortestJumps;

    }

}

public class JumpOnClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
