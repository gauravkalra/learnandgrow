package com.gaurav.learnandgrow.dp;

import java.util.HashMap;

public class GridTraveler {
    private static int numberOfRecursiveCalls = 0;

    public static void main(String[] args) {
        int numberOfWays = travelGrid(3, 3, new HashMap<>());
        System.out.println("Number of Ways: " + numberOfWays);
        System.out.println("Number of recursive Calls: " + numberOfRecursiveCalls);
    }

    public static int travelGrid(int i, int j, HashMap<String, Integer> memo) {
        numberOfRecursiveCalls++;
        int numberOfWays = 0;
        String key = i + "," + j;
        if (memo == null) {
            memo = new HashMap<>();
        }
        if (memo.containsKey(key)) {
            numberOfWays = memo.get(key);
        } else
            if (i == 0 || j == 0) {
            numberOfWays = 0;
        } else if (i == 1 && j == 1) {
            numberOfWays = 1;
        } else {
            numberOfWays = travelGrid(i - 1, j, memo) + travelGrid(i, j - 1, memo);
            memo.put(key, numberOfWays);
            String reverseKey = j+","+i;// travelGrid(m,n) is same as travelGrid(n,m). So memoize both m,n and n,m.
            memo.put(reverseKey, numberOfWays);
        }

        return numberOfWays;
    }
}
