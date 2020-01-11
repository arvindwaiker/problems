package io.awklabs.dailycodingproblem;

/**
 * Daily Coding Problem #7
 * <p>
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */


public class CountPossibleDecodings {

    public static int countPossibleDecoding(char[] input, int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (input[0] == '0') {
            return 0;
        }

        int count = 0;

        if (input[n - 1] > '0') {
            count = countPossibleDecoding(input, n - 1);
        }

        if ((input[n - 2] == '1') || (input[n - 2] == '2' && input[n - 1] < '7')) {
            count += countPossibleDecoding(input, n - 2);
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "111";
        System.out.println(countPossibleDecoding(input.toCharArray(), input.length()));

    }
}
