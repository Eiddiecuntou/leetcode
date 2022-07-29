package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _2_Knapsack01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  15:23
 */
//用的物品索引和剩余容量

public class _2_Knapsack01 {
    //消除重复计算
    private int[] w;
    private int[] v;

    public int knapsack01(int[] w, int[] v, int C) {
        this.w = w;
        this.v = v;
        return dfs(-1, C);
    }

    //在容量为c的背包里放入第index号物品，得到的最大的价值
    private int dfs(int index, int c) {
        //处理当前的节点（父节点）
        int maxValue = 0;

        //从index开始是为了控制顺序
        for (int i = index; i < w.length; i++) {
            //处理子节点
            int childIndex = i + 1;

            if (childIndex == w.length) continue;
            if (c < w[childIndex]) continue;

            int childMaxValue = dfs(childIndex, c - w[childIndex]);
            maxValue = Math.max(maxValue, childMaxValue);
        }

        return maxValue + (index == -1 ? 0 : v[index]);

    }
}
