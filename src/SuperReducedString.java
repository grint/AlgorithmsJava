/**
 * https://www.hackerrank.com/challenges/reduced-string
 */

import java.util.*;

public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        char[] chars = new char[word.length()];
        chars = word.toCharArray();
        Stack<Character> st = new Stack<>();

        for(Character ch : chars) {
            if(st.empty()) {
                st.push(ch);
            }
            else {
                char prevCh = st.peek();
                if(ch == prevCh) {
                    st.pop();
                }
                else {
                    st.push(ch);
                }
            }
        }

        StringBuilder result = new StringBuilder(st.size());
        for(Character ch : st) {
            result.append(ch);
        }

        System.out.println(result.length() == 0 ? "Empty String" : result);
    }
}