package com.cuntou.动态规划._644;

import com.cuntou.链表.Node;

/**
 * @ClassName : _64_MinPathSum2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  21:24
 */

public class _64_MinPathSum2 {
    private int[][] dirs = {{1,0},{-1,0}};
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);

    }
    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1 ) {
            return grid[row][col];
        }
        int minPathSum = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextCol < 0 || nextRow < 0 ||
             nextRow >= grid.length || nextCol >= grid[0].length) continue;
            int childMinPathSum = dfs(grid, nextRow, nextCol);
            minPathSum = Math.min(minPathSum, childMinPathSum);
        }
        return minPathSum + grid[row][col];



    }
}
