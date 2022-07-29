package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _6_KnapsackComplete  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  17:27
 */

/*
    完全背包：
        有 n 种物品和一个容量为 C 的背包
        第 i 种物品的重量是 w[i]，价值是 v[i]，件数是无限
        求将哪些物品装入背包可使得价值总和最大
 */
public class _6_KnapsackComplete {

    private int[] w;
    private int[] v;

    private int max = 0;

    public int knapsack01(int[] w, int[] v, int C) {
        this.w = w;
        this.v = v;
        return dfs(-1, C);
    }

    //在容量为c的背包里放入到第index号物品，得到的最大价值
    public int dfs(int index, int c) {
        //状态参数
        //处理当前节点(父节点）
        int maxValue = 0;

        //从index开始为了控制顺序
        for (int i = index; i < w.length ; i++) {
            //处理子节点
            int childIndex = i;

            if (childIndex == w.length) continue;
            if (childIndex == - 1 || c < w[childIndex]) continue;

            int childMaxValue = dfs(childIndex, c - w[childIndex]);
            maxValue = Math.max(maxValue, childMaxValue);

        }
        return maxValue + (index == -1 ? 0 : v[index]);
    }


}
