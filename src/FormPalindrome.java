/**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=557
 */

import java.util.*;
import java.lang.*;

class FormPalindrome {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            String str = sc.next();
            char[] word = str.toCharArray();

            minInsertions(word);

            testsNum--;
        }
    }

    static void minInsertions(char[] word) {
        int wordLength = word.length;
        char[] revWord = new char[wordLength];
        for(int i = wordLength - 1, j = 0; i >= 0; i--, j ++) {
            revWord[i] = word[j];
        }
        int minIns = wordLength - LCS(word, revWord, wordLength);
        System.out.println(minIns);
    }

    private static int LCS(char[] word1, char[] word2, int l) {
        int[][] memo = new int[l+1][l+1];

        for (int i=0; i<= l; i++)
        {
            for (int j=0; j<= l; j++)
            {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;

                else if (word1[i-1] == word2[j-1])
                    memo[i][j] = memo[i-1][j-1] + 1;

                else
                    memo[i][j] = max(memo[i-1][j], memo[i][j-1]);
            }
        }

        return memo[l][l];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

}