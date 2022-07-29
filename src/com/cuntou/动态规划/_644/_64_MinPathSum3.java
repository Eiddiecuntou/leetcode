package com.cuntou.动态规划._644;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _64_MinPathSum2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  21:24
 */

public class _64_MinPathSum3 {
    //记忆化搜索
    private int[][] dirs = {{1,0},{-1,0}};
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return dfs(grid, 0, 0, memo);

    }
    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        int minPathSum = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextCol < 0 || nextRow < 0 ||
                    nextRow >= grid.length || nextCol >= grid[0].length) continue;
            int childMinPathSum = dfs(grid, nextRow, nextCol, memo);
            minPathSum = Math.min(minPathSum, childMinPathSum);
        }
        memo[row][col] = minPathSum + grid[row][col];
        return memo[row][col];
    }
}
