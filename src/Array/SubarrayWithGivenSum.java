package Array;/*
 * http://practice.geeksforgeeks.org/problem-page.php?pid=590
 */

import java.util.*;
        import java.lang.*;

class SubarrayWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            // Input the size of the array and the sum
            int[] params = new int[2];
            for(int i = 0; i < 2; i++) {
                params[i] = sc.nextInt();
            }

            int[] array = new int[params[0]];
            for(int i = 0; i < params[0]; i++) {
                array[i] = sc.nextInt();
            }

            findSum(array, params[0], params[1]);

            testsNum--;
        }
    }

    static void findSum(int[] a, int length, int sum) {
        int cur_sum = a[0];
        int start = 0;

        for(int i = 1; i <= length; i++) {
            if(cur_sum == sum) {
                System.out.println((start+1) + " " + i);
                break;
            }
            if (i < length) {
                cur_sum += a[i];
                while (cur_sum > sum && start < i-1) {
                    cur_sum -= a[start++];
                }
            }
            else {
                System.out.println("-1");
                break;
            }
        }
    }
}