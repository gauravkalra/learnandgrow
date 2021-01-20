package com.gaurav.learnandgrow.dp.draft;

public class LongestIntSequenceBruteForce {
    static int counter;

    public static void main(String[] args) {
        int[] input = {1, 10};
        int length = lengthOfLIS(input);
        System.out.println("length is: " + length);
        System.out.println("Total Number of Calls: "+ counter);
    }

    public static int lengthOfLIS(int[] input) {
        return lengthOfLIS(input, Integer.MIN_VALUE, 0);
    }

    public static int lengthOfLIS(int[] input, int prev, int curpos) {
        counter ++;
        int length = 0;
        if (input.length == curpos) {
            length = 0;
        } else {
            if (input[curpos] > prev) {
                length = 1 + lengthOfLIS(input, input[curpos], curpos + 1);
            } else {
                length = 0 + lengthOfLIS(input, input[curpos], curpos + 1);
            }

        }
        return length;
    }
}