package io.awklabs.leetcode;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int i = 0;
        int j = i + k;
        int m = 0;

        while (j != nums.length + 1) {
            int max = nums[i];
            if (m != 0 && nums[j - 1] > result[m - 1]) {
                max = nums[j - 1];
            } else {
                for (int n = i; n < j; n++) {
                    if (max < nums[n]) {
                        max = nums[n];
                    }
                }
            }
            result[m++] = max;
            j++;
            i++;
        }
        return result;

    }
}
