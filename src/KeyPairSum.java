/**
 * http://practice.geeksforgeeks.org/problems/key-pair/0
 */

import java.util.*;
import java.lang.*;

class KeyPairSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int[] params = new int[2];
            for(int i = 0; i < 2; i++) {
                params[i] = sc.nextInt();
            }

            LinkedList<Integer> array = new LinkedList<>();
            for(int i = 0; i < params[0]; i++) {
                array.add(sc.nextInt());
            }

            findSum(array, params[0], params[1]);

            testsNum--;
        }
    }

    private static void findSum(LinkedList<Integer> nums, int arraySize, int sum) {
        HashMap<Integer, Boolean> map = new HashMap<Integer,Boolean>();
        String answer = "No";
        for(Integer num : nums) {
            if(map.containsKey(sum-num) && map.get(sum-num)) {
                answer = "Yes";
            }
            map.put(num, true);
        }
        System.out.println(answer);
    }
}