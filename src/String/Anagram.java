package String; /**
 * https://www.hackerrank.com/challenges/anagram
 */

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numWords = in.nextInt(); in.nextLine();

        for(int i = 0; i < numWords; i++) {
            String word = in.nextLine();
            int len = word.length();
            int answer = 0;

            if(len % 2 == 0) {
                String word1 = word.substring(0, len/2);
                String word2 = word.substring(len/2);
                for(Character ch : word1.toCharArray()) {
                    int index = word2.indexOf(Character.toString(ch));
                    if(index == -1) {
                        answer++;
                    }
                    else {
                        word2 = word2.substring(0, index).concat(word2.substring(index+1));
                    }
                }
            }
            else answer = -1;

            System.out.println(answer);
        }
    }
}