package Graph; /**
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */

import java.io.*;

public class JourneyToTheMoon {
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
        }

        long combinations = 0;

        System.out.println(combinations);
    }
}