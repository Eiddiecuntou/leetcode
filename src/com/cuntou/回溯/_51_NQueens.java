package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _51_NQueens  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/20  19:29
 */

public class _51_NQueens {
  //将N个皇后放到n * n 的二维数组,是他们不会攻击
    // 4个皇后之间的关系
    //第一行的关系
    //穷举的过程
    private int n;
    //存储皇后的位置
    private int[] rows;
    // 标记是否被列方向的皇后攻击
    private int[] cols;
    // 标记是否被主对角线方向的皇后攻击
    private int[] mains;
    // 标记是否被次对角线方向的皇后攻击
    private int[] secondary;

    private List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.mains = new int[2 * n - 1];
        this.secondary = new int[2 * n - 1];

        this.output = new ArrayList<>();

        dfs(0);

        return output;
    }
    //回溯,每一行中放置一个皇后
    private void dfs(int row) {
        if (row >= n) return;
        for (int col = 0; col < n ; col++) {
            if (isNotUnderAttack(row, col)) {
                //选择,在当前的位置上放置皇后
                placeQueen(row, col);
                //当前行是最后一行,就说明找到了一个解决方案
                if (row == n -1) addSolution();
                dfs(row + 1);
                removeQueen(row, col);
            }
        }
    }

    private void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n ; i++) {
            int col = rows[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    private void removeQueen(int row, int col) {
        //移除 row行上的皇后
        //其实 row 行上的皇后可以不移除的，因为我们是一行一行存储皇后的，所以每一行肯定会有一个皇后的
        // 而且在 isNotUnderAttack 这个方法中都没有用到 rows[row] 这个值
        // 所以下面的代码可以注释掉的
        // rows[row] = 0;

        //当前位置的列方向没有皇后
        cols[col] = 0;
        //当前位置的主对角线方向没有皇后
        mains[row - col + n - 1] = 0;
        // 当前位置的次对角线方向没有皇后了
        secondary[row + col] = 0;

    }

    private void placeQueen(int row, int col) {
        //在row行,col列放置皇后
        rows[row] = col;
        //当前位置的列方向已经有皇后
        cols[col] = 1;
        //当前位置的主对角线方向已经有皇后
        // n - 1
        mains[ row - col + n - 1] = 1;
        //当前位置的次对角线方向已经有皇后
        secondary[row + col] = 1;
    }

    private boolean isNotUnderAttack(int row, int col) {
        // 判断的逻辑是：
        //      1. 当前位置的这一列方向没有皇后攻击
        //      2. 当前位置的主对角线方向没有皇后攻击
        //      3. 当前位置的次对角线方向没有皇后攻击
        int res = cols[col] + mains[row - col + n - 1] + secondary[row + col];
        // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
        return res == 0;
    }
}
