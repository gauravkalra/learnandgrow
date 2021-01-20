package com.gaurav.learnandgrow.dp;


import java.util.HashMap;

public class CanSum {
    public static void main(String[] args) {
        int targetSum = 7;
        int[] numbers = { 2, 8, 3};
        boolean canSum = canSum(targetSum, numbers, new HashMap<>());
        System.out.println("canSum: " + canSum);
    }

    private static boolean canSum(Integer targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        boolean canSum = false;
        if (memo.containsKey(targetSum)) {
            canSum = memo.get(targetSum);
        }
        if (targetSum == 0) {
            canSum = true;
        } else if ( targetSum<0) {
            canSum = false;
        } else {
            for (int index = 0; index < numbers.length; index++) {
                Integer remainder = targetSum - numbers[index];
                canSum = canSum(remainder, numbers, memo);
                memo.put(remainder, canSum);
                if(canSum) {
                    break;
                }
            }
        }
        return canSum;
    }
}
