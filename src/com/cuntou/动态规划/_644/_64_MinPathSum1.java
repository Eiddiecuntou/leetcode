package com.cuntou.动态规划._644;

/**
 * @ClassName : _64_MinPathSum1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  20:24
 */

public class _64_MinPathSum1 {
    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    //输出：7
    //解释：因为路径 1→3→1→1→1 的总和最小。
    private int minPathSum = Integer.MAX_VALUE;
    private int[][] dirs = {{1, 0}, {0, 1}};
    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return minPathSum;

    }

    private void dfs(int[][] grid, int row, int col, int sum ){
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            minPathSum = Math.min(minPathSum, sum);
            return;
        }

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0
                || nextRow >= grid.length
                || nextCol >= grid[0].length) continue;
            sum += grid[nextRow][nextCol];
            dfs(grid, nextRow, nextCol, sum);
            sum -= grid[nextRow][nextCol];
        }
    }
}
