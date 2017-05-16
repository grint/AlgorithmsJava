/**
 * http://practice.geeksforgeeks.org/problems/search-in-a-rotated-array/0
 */

import java.util.*;
import java.lang.*;

class SearchRotatedArray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int arraySize = sc.nextInt();
            int[] nums = new int[arraySize];
            for(int i = 0; i < arraySize; i++) {
                nums[i] = sc.nextInt();
            }
            int numToFind = sc.nextInt();

            findNum(nums, arraySize, numToFind);

            testsNum--;
        }
    }

    private static void findNum(int[] nums, int arraySize, int numToFind) {
        int pivot = findPivot(nums, 0, arraySize-1);
        int index;

        if(pivot == -1)
            index = binarySearch(nums, numToFind, 0, arraySize-1);
        if(numToFind == nums[pivot])
            index = pivot;
        else if(numToFind >= nums[0])
            index = binarySearch(nums, numToFind, 0, pivot-1);
        else
            index = binarySearch(nums, numToFind, pivot+1, arraySize-1);

        System.out.println(index);
    }

    private static int binarySearch(int[] a, int num, int left, int right) {
        while(left <= right) {
            int mid = (left+right)/2;
            if(num > a[mid]) left = mid+1;
            else if (num < a[mid]) right = mid-1;
            else return mid;
        }
        return -1;
    }

    private static int findPivot(int[] a, int left, int right) {
        if(left > right) return -1;
        if(left == right) return left;

        int mid = (left+right)/2;

        if(mid < right && a[mid] > a[mid+1]) return mid;
        else if(mid > left && a[mid] < a[mid-1]) return mid-1;
        else if(a[left] >= a[mid]) return findPivot(a, left, mid-1);
        return findPivot(a, mid+1, right);
    }
}