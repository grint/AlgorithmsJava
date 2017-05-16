/**
 * https://www.hackerrank.com/challenges/alternating-characters/
 */

import java.util.*;

public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numWords = in.nextInt(); in.nextLine();

        for(int i = 0; i < numWords; i++) {
            String word = in.nextLine();
            Stack<Character> st = new Stack<>();
            int deletions = 0;
            for(char ch : word.toCharArray()) {
                if(!st.empty()) {
                    if(ch != st.peek()) {
                        st.push(ch);
                    }
                    else {
                        deletions++;
                    }
                }
                else {
                    st.push(ch);
                }
            }
            System.out.println(deletions);
        }
    }
}