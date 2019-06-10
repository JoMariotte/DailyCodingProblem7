package com.dailycodingproblems.jo;

public class Main {

    public static void main(String[] args) {
        System.out.println(numWaysToDecodeWrapper("111"));
    }

    public static int numWaysToDecode(char[] toDecodeStr,int k,int[] memo) {
        if(k == 0 || k == 1)
            return 1;
        int numberOfWays = 0;
        if(memo[k] > 0)
            return memo[k];
        numberOfWays = numWaysToDecode(toDecodeStr,k-1,memo);
        if (toDecodeStr[k - 2] == '1' || (toDecodeStr[k - 2] == '2' && toDecodeStr[k - 1] < '7'))
            numberOfWays += numWaysToDecode(toDecodeStr,k-2,memo);
        memo[k] = numberOfWays;
        return numberOfWays;
    }

    public static int numWaysToDecodeWrapper(String data) {
        int[] memo = new int[data.length() + 1];
        return numWaysToDecode(data.toCharArray(),data.length(), memo);
    }
}
