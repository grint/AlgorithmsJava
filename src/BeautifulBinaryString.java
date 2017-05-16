/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 */

import java.util.*;

public class BeautifulBinaryString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] word = in.next().toCharArray();
        int rep = 0;

        char ch1 = word[0];
        char ch2 = word[1];
        for(int i = 2; i < word.length; i++) {
            char ch3 = word[i];
            if(ch3 == '0' && ch2 == '1' && ch1 == '0') {
                ch3 = '1';
                rep++;
            }
            ch1 = ch2;
            ch2 = ch3;
        }

        System.out.println(rep);
    }
}
