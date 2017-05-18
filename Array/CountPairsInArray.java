package Array; /**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=1515
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class CountPairsInArray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int arraySize = sc.nextInt();
            int[] nums = new int[arraySize];

            for(int i = 0; i < arraySize; i++) {
                nums[i] = sc.nextInt();
            }

            coutPairs(nums, arraySize);

            testsNum--;
        }
    }

    private static void coutPairs(int[] nums, int arraySize) {
        for(int i = 0; i < arraySize; i++) {
            nums[i] = nums[i] * i;
        }

        int[] temp = new int[arraySize];

        System.out.println(mergeSort(nums, temp, 0, arraySize-1));
    }

    private static int mergeSort(int[] nums, int[] temp, int left, int right) {
        int invCount = 0;
        if(left >= right) return invCount;
        int mid = (left + right) / 2;
        invCount = mergeSort(nums, temp, left, mid);
        invCount += mergeSort(nums, temp, mid+1, right);
        invCount += merge(nums, temp, left, mid+1, right);
        return invCount;
    }

    private static int merge(int[] nums, int[] temp, int left, int mid, int right) {
        int invCount = 0;
        int i = left, j = mid;

        for(int m = left; m <= right; m++) {
            temp[m] = nums[m];
        }

        for(int k = left; k <= right; k++) {
            if(i >= mid)
                nums[k] = temp[j++];
            else if(j > right)
                nums[k] = temp[i++];
            else if (temp[i] <= temp[j])
                nums[k] = temp[i++];
            else  {
                nums[k] = temp[j++];
                invCount = invCount + (mid - i);
            }
        }

        return invCount;
    }
}