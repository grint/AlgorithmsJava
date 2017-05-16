/**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=297
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class RemoveBandACfromString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            String str = sc.next();
            char[] string = str.toCharArray();

            removeLetters(string);

            testsNum--;
        }
    }

    private static void removeLetters(char[] string) {
        int state = 1, j = 0;

        for (int i = 0; i < string.length; i++) {
            if(state == 1 && string[i] != 'a' && string[i] != 'b') {
                string[j] = string [i];
                j++;
            }

            if(state == 2 && string[i] != 'c') {
                string[j] = 'a';
                j++;

                if(string[i] != 'a' && string[i] != 'b') {
                    string[j] = string [i];
                    j++;
                }
            }

            state = (string[i] == 'a') ? 2 : 1;
        }

        if(state == 2) {
            string[j] = 'a';
            j++;
        }

        for(int i = 0; i < j; i++) {
            System.out.print(string[i]);
        }
        System.out.println();
    }
}