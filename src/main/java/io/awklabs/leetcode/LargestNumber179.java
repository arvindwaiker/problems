package io.awklabs.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            String ret = new Solution().largestNumber(nums);

            String out = (ret);

            System.out.print(out);
        }
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsAsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsAsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsAsStr, new LargerNumberComparator());

        if (numsAsStr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : numsAsStr) {
            sb.append(s);
        }
        return sb.toString();
    }

    private class LargerNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }
}
