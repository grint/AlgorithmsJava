package Array;

/**
 * http://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array/0
 *
 * Given a sorted array of integers, every element appears twice except for one.
 * Find that single one in linear time complexity and without using extra memory.
 *
 * Input: 1 1 2 2 3 3 4 50 50 65 65
 * Output: 4
 */

public class ElementAppearsOnceSortedArray {

    public static void main(String[] args) {

        // Answer: 4
        System.out.println(findUniqueNumber(11, new int[] {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}));
        // Answer: 1
        System.out.println(findUniqueNumber(11, new int[] {1, 2, 2, 3, 3, 4, 4, 50, 50, 65, 65}));
        // Answer: 65
        System.out.println(findUniqueNumber(11, new int[] {1, 1, 2, 2, 3, 3, 4, 4, 50, 50, 65}));

        // Answer: 4
        System.out.println(findUniqueNumberLinear(11, new int[] {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}));
        // Answer: 1
        System.out.println(findUniqueNumberLinear(11, new int[] {1, 2, 2, 3, 3, 4, 4, 50, 50, 65, 65}));
        // Answer: 65
        System.out.println(findUniqueNumberLinear(11, new int[] {1, 1, 2, 2, 3, 3, 4, 4, 50, 50, 65}));
    }

    /*
     * Time complexity O(log n)
     * Pairs start index is even (0, 2, 4, ...) before the unique number = pair(even, even+1)
     * Pairs start index is odd (1, 3, 5, ...) after the unique number = pair(odd-1, odd)
     * If mid is even --> compare with even+1. Equal ? the unique number on the right
     * If mid is odd --> compare with odd-1. Equal ? the unique number on the right
     */
    private static int findUniqueNumber(int len, int[] arr) {
        int min = 0, max = len-1;

        while(min <= max) {
            if(min > max) return -1;

            // found the number
            if(min == max) return arr[min];

            int mid = min + (max - min) / 2;

            // mid index is even
            if(mid % 2 == 0) {
                if(arr[mid] == arr[mid+1])
                    min = mid+2;
                else
                    max = mid;
            }
            // mid index is odd
            else {
                if(arr[mid] == arr[mid-1])
                    min = mid+1;
                else
                    max = mid-1;
            }
        }

        return -1;
    }

    /*
     * Time complexity O(n)
     * Go through the array with 2 pointers and compare.
     * If equal - move 2 steps
     * Else break, return the first number.
     */
    private static int findUniqueNumberLinear(int len, int[] arr) {
        int res = -1;

        for (int i = 0, j = 1; i < len-1;) {
            if(arr[i] == arr[j]) {
                i += 2;
                j += 2;
            }
            else {
                res = arr[i];
                break;
            }
        }

        if(res == -1) res = arr[len-1];

        return res;
    }
}