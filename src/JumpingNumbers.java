/**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=389
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class JumpingNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int num = sc.nextInt();
            jumpingNumbers(num);
            testsNum--;
        }
    }

    private static void jumpingNumbers(int num) {
        System.out.print(0 + " ");
        for(int i = 1; i <= 9 && i <= num; i++) {
            BFS(num, i);
        }
        System.out.println();
    }

    private static void BFS(int num, int i) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(i);

        while(queue.size() != 0) {
            i = queue.poll();

            if(i <= num) {
                System.out.print(i + " ");

                int lastDigit = i % 10;

                if(lastDigit == 0) {
                    queue.add((i*10) + (lastDigit+1));
                }
                else if(lastDigit == 9) {
                    queue.add((i*10) + (lastDigit-1));
                }
                else {
                    queue.add((i*10) + (lastDigit-1));
                    queue.add((i*10) + (lastDigit+1));
                }
            }
        }
    }
}