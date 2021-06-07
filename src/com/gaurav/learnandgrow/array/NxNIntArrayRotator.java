package com.gaurav.learnandgrow.array;

public class NxNIntArrayRotator {

    private static double min = 1;
    private static double max = 100;

    public static void main(String[] args) {
        int[][] twoDArray = prepareArray(4);
        printArray(twoDArray);
        rotate(twoDArray);
        printArray(twoDArray);
    }
    private static void rotate(int[][] twoDArray){
        int maxIndex = twoDArray.length-1;
        for(int i=0; i<twoDArray.length/2;i++) {
            for(int j=i;j<maxIndex-i;j++) {
                //Top Row
                int v1 = twoDArray[i][j];

                //Right Column
                int v2 = twoDArray[j][maxIndex-i];

                //Bottom Row
                int v3 = twoDArray[maxIndex-i][maxIndex-j];

                //Left Column
                int v4 = twoDArray[maxIndex-j][i];

                int[]p1 = {i,j};
                int[]p2 = {j,maxIndex-i};
                int[]p3 = {maxIndex-i,maxIndex-j};
                int[]p4 = {maxIndex-j,i};

                //Top Row
                twoDArray[p1[0]][p1[1]] = v4;

                //Right Column
                twoDArray[p2[0]][p2[1]] = v1;

                //Bottom Row
                twoDArray[p3[0]][p3[1]] = v2;

                //Left Column
                twoDArray[p4[0]][p4[1]] = v3;
            }
        }
    }

    private static int[][]  prepareArray(int size) {
        int[][] twoDArray = new int[size][size];
        for(int i =0;i<twoDArray.length;i++) {
            for (int j=0;j<twoDArray.length;j++) {
                int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
                twoDArray[i][j] = randomInt;
            }
        }
        return twoDArray;
    }

    private static void printArray(int[][] twoDArray) {
        System.out.println("-------------------------");
        for(int i =0;i<twoDArray.length;i++) {
            for (int j=0;j<twoDArray.length;j++) {
                System.out.print(" "+twoDArray[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("-------------------------");
    }
}
