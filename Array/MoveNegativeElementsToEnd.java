package Array; /**
 * http://practice.geeksforgeeks.org/problem-page.php?pid=1540
 */

import java.util.*;
import java.lang.*;

class MoveNegativeElementsToEnd {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int arraySize = sc.nextInt();

            int[] nums = new int[arraySize];
            for(int i = 0; i < arraySize; i++) {
                nums[i] = sc.nextInt();
            }

            sortNegative(nums, arraySize);

            testsNum--;
        }
    }

    private static void sortNegative(int[] nums, int arraySize) {
        int[] temp = new int[arraySize];
        temp = Arrays.copyOf(nums, arraySize);
        int j = 0;

        for(int i = 0; i < arraySize; i++) {
            if(nums[i] >= 0) {
                temp[j] = nums[i];
                j++;
            }
        }

        if(j != arraySize-1 || j != 0) {
            for(int i = 0; i < arraySize; i++) {
                if(nums[i] < 0) {
                    temp[j] = nums[i];
                    j++;
                }
            }
        }

        for(int i = 0; i < arraySize; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}