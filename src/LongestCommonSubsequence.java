/*
*
*
*
 */

public class LongestCommonSubsequence {
    private int[][] memo;
    int L;
    private char[] word1;
    private char[] word2;
    private int l1;
    private int l2;

    LongestCommonSubsequence(char[] word1, char[] word2, int l1, int l2) {
        this.memo = new int[l1+1][l2+1];
        this.word1 = word1;
        this.word2 = word2;
        this.l1 = l1;
        this.l2 = l2;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    int LCS() {
        for (int i=0; i<= l1; i++)
        {
            for (int j=0; j<= l2; j++)
            {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;

                else if (word1[i-1] == word2[j-1])
                    memo[i][j] = memo[i-1][j-1] + 1;

                else
                    memo[i][j] = max(memo[i-1][j], memo[i][j-1]);
            }
        }

        L = memo[l1][l2];
        return memo[l1][l2];
    }

    void printMemo() {
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printLCS() {
        int i = l1, j = l2, k = memo[l1][l2];
        char[] lcs = new char[k];

        while (i > 0 && j > 0) {
            if (word1[i-1] == word2[j-1]) {
                lcs[k-1] = word1[i-1];
                i--; j--; k--;
            }
            else if (memo[i-1][j] > memo[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }

        System.out.println("LCS is " + new String(lcs));
    }

    int minInsertionsToPalindrom() {
        char[] revWord = new char[word1.length];
        for(int i = word1.length - 1, j = 0; i >= 0; i--, j ++) {
            revWord[i] = word1[j];
        }
        int minIns = word1.length - LCS();
        System.out.println("Min insertions = " + minIns);
        return minIns;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence seq1 = new LongestCommonSubsequence("geeks".toCharArray(), "skeeg".toCharArray(),5, 5);
        seq1.LCS();
        System.out.println(seq1.L);
        seq1.printLCS();
        seq1.printMemo();
        seq1.minInsertionsToPalindrom();
        System.out.println("-------------------------");

        LongestCommonSubsequence seq2 = new LongestCommonSubsequence("ABCDGH".toCharArray(), "AEDFHR".toCharArray(), 6, 6);
        seq2.LCS();
        System.out.println(seq2.L);
        seq2.printLCS();
        seq2.printMemo();
        seq2.minInsertionsToPalindrom();
        System.out.println("-------------------------");

        LongestCommonSubsequence seq3 = new LongestCommonSubsequence("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(),6, 7);
        seq3.LCS();
        System.out.println(seq3.L);
        seq3.printLCS();
        seq3.minInsertionsToPalindrom();
        seq3.printMemo();
    }
}
