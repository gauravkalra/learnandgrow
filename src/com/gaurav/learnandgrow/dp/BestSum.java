package com.gaurav.learnandgrow.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Find out the minimum number of elements required from a given array to get the targetSum.
public class BestSum {
    public static void main(String[] args) {
        Integer targetSum = 48;
        Integer[] numbers = {13,15,6};
        Map<Integer, Integer[]> memo = new HashMap<>();
        Integer [] bestCombination = bestSum(targetSum, numbers, memo);
        System.out.println("Best Combination: "+ Arrays.toString(bestCombination));
    }

    private static Integer[] bestSum(Integer targetSum, Integer[] numbers, Map<Integer, Integer[]> memo) {
        Integer[] bestCombination = null;
        if (memo.containsKey(targetSum)) {
            bestCombination = memo.get(targetSum);
        } else if (targetSum == 0) {
            bestCombination = new Integer[]{};
        } else if (targetSum > 0) {
            for(Integer number: numbers) {
                Integer remainder = targetSum - number;
                Integer[] combination = bestSum(remainder, numbers, memo);
                if(combination!=null) {
                    if(bestCombination ==null || combination.length < bestCombination.length-1 ) {
                        Integer[] newArrayWithThisNumber = new Integer[combination.length+1];
                        System.arraycopy(combination, 0, newArrayWithThisNumber, 0, combination.length);
                        newArrayWithThisNumber[newArrayWithThisNumber.length-1] = number;
                        bestCombination = newArrayWithThisNumber;
                    }
                    memo.put(targetSum, bestCombination);
                }
            }
        }
        return bestCombination;
    }
}
