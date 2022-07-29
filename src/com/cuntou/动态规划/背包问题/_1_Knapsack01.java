package com.cuntou.动态规划.背包问题;

/**
 * @ClassName : _1_Knapsack01  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/28  14:42
 */

//现在有一个背包，他的容量为c，现在有n种不同的物品，
// 他们的编号为0....n-1，在物品中，
// 第i个物品的重量是w[i]，他的价值是v[i];
    //可以放多少个物品使得其总价值最大



public class _1_Knapsack01 {
    private int[] w;
    private int[] v;

    private int maxValue = 0;

    public int knapsack01(int[] w, int[] v, int c) {
        this.w = w;
        this.v = v;

        dfs(-1,c,0);
        return maxValue;
    }

    private void dfs(int index, int c, int currValue) {
        //处理当前的结点的
        maxValue = Math.max(maxValue, currValue);

        //从index来控制这个遍历的顺序
        for (int i = index; i < w.length ; i++) {
            //处理子节点
            int childIndex = i + 1;

            if (childIndex == w.length) continue;
            if (c < w[childIndex]) continue;

            dfs(childIndex, c - w[childIndex] , currValue + v[childIndex]);

        }

    }

    public static void main(String[] args) {
        _1_Knapsack01 k = new _1_Knapsack01();
        int w[] = {3, 4, 5};
        int v[] = {15, 10, 12};

        System.out.println(k.knapsack01(w, v, 10));
    }

}
