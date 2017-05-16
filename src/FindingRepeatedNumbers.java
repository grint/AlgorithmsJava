/**
 * http://practice.geeksforgeeks.org/problems/finding-the-numbers/0
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class FindingRepeatedNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testsNum = sc.nextInt();

        while(testsNum > 0) {
            int repNums = sc.nextInt();

            int[] array = new int[2*repNums+2];
            for(int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }

            findNums(array);

            testsNum--;
        }
    }

    static void findNums(int[] a) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(res.contains(a[i])) {
                res.remove(res.indexOf(a[i]));
            }
            else {
                res.add(a[i]);
            }
        }
        for(int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}