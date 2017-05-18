package Array; /**
 * http://practice.geeksforgeeks.org/problems/string-manipulation/0
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class RemovePairwiseDuplicates {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int arraySize = sc.nextInt();

            String[] words = new String[arraySize];

            for(int i = 0; i < arraySize; i++) {
                words[i] = sc.next();
            }

            removeDuplicates(words);

            testsNum--;
        }
    }

    private static void removeDuplicates(String[] words) {
        Stack<String> st = new Stack<>();

        for(String word : words) {
            if(!st.empty() && st.peek().equals(word)) {
                st.pop();
            }
            else {
                st.push(word);
            }
        }

        System.out.println(st.size());
    }
}