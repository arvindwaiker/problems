package io.awklabs.leetcode;

import java.util.Stack;

public class NumberOfIslands200 {


    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) { //find the starting point and navigate
                    navigateIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void navigateIsland(char[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(i, j));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            visited[pair.x][pair.y] = true;

            if (pair.x + 1 < m && grid[pair.x + 1][pair.y] == '1' && !visited[pair.x + 1][pair.y]) {
                stack.push(new Pair(pair.x + 1, pair.y));
            }
            if (pair.y + 1 < n && grid[pair.x][pair.y + 1] == '1' && !visited[pair.x][pair.y + 1]) {
                stack.push(new Pair(pair.x, pair.y + 1));
            }
            if (pair.x - 1 >= 0 && grid[pair.x - 1][pair.y] == '1' && !visited[pair.x - 1][pair.y]) {
                stack.push(new Pair(pair.x - 1, pair.y));
            }
            if (pair.y - 1 >= 0 && grid[pair.x][pair.y - 1] == '1' && !visited[pair.x][pair.y - 1]) {
                stack.push(new Pair(pair.x, pair.y - 1));
            }
        }
    }

    private static class Pair {
        int x, y;

        Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
