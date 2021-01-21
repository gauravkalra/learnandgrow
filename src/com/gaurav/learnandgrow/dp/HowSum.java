package com.gaurav.learnandgrow.dp;


import java.util.Arrays;
import java.util.HashMap;

//Problem: How a targetSum (2100) may be achieved by combining numbers of given inputArray = {2, 3,2};
//Approach:
// 1. For target sum run through each number of array
// 2. subract each number from sum and get remainder
// 3. Now for remainder, call howSum along with initial input set of number.
public class HowSum {
    private static int loopCounter = 0;

    public static void main(String[] args) {
        Integer targetSum = 990;
        int[] inputArray = {10, 5};
        HashMap<Integer, int[]> memo = new HashMap<>();
        int[] possibleArray = howSum(targetSum, inputArray, memo);
        System.out.println(Arrays.toString(possibleArray));
        System.out.println("loop counter: " + loopCounter);
    }

    private static int[] howSum(Integer targetSum, int[] numbers, HashMap<Integer, int[]> memo) {
        int[] possibleArray = null;
        if (memo.containsKey(targetSum)) {
            possibleArray = memo.get(targetSum);
        } else {
            loopCounter++;
            if (targetSum == 0) {
                return new int[]{};
            }
            if (targetSum < 0) {
                return null;
            }
            System.out.println("target sum: " + targetSum);
            for (int number : numbers) {
                int remainder = targetSum - number;
                int[] array = howSum(remainder, numbers, memo);
                if (array != null) {
                    possibleArray = new int[array.length + 1];
                    System.arraycopy(array, 0, possibleArray, 0, array.length);
                    possibleArray[possibleArray.length - 1] = number;
                }
                memo.put(remainder, possibleArray);
            }
        }
        return possibleArray;
    }
}
