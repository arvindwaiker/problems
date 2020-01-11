package io.awklabs.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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