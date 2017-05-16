/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */

import java.util.*;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numWords = in.nextInt(); in.nextLine();

        for(int i = 0; i < numWords; i++) {
            int charIndex = -1;
            String word = in.nextLine();
            char[] letters = word.toCharArray();

            if(!isPalindrom(word)) {
                for(int k = 0, n = letters.length-1; k <= n; k++, n--) {
                    if(letters[k] != letters[n]) {
                        String removeLeftChar = word.substring(k+1, n+1);
                        String removeRightChar = word.substring(k, n);

                        if(isPalindrom(removeLeftChar)) {
                            charIndex = k;
                            break;
                        }
                        if(isPalindrom(removeRightChar)) {
                            charIndex = n;
                            break;
                        }
                    }
                }
            }
            System.out.println(charIndex);
        }
    }

    private static boolean isPalindrom(String word) {
        String reverse = new StringBuffer(word).reverse().toString();
        if(word.equals(reverse)) return true;
        return false;
    }
}
