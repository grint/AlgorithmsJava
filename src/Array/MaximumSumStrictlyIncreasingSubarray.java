package Array; /**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=1482
 */

import java.util.*;
import java.lang.*;

class MaximumSumStrictlyIncreasingSubarray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int arraySize = sc.nextInt();
            int[] nums = new int[arraySize];

            for(int i = 0; i < arraySize; i++) {
                nums[i] = sc.nextInt();
            }

            findMaxSum(nums, arraySize);

            testsNum--;
        }
    }

    private static void findMaxSum(int[] nums, int arraySize) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < arraySize; i++) {
            if(i != 0 && nums[i] <= nums[i-1]) sum = 0;
            sum += nums[i];
            max = (sum > max) ? sum : max;
        }
        System.out.println(max);
    }
}