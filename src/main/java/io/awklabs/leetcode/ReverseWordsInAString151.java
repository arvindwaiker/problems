package io.awklabs.leetcode;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].length() > 0) {
                sb.append(tokens[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}