package io.awklabs.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {

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

