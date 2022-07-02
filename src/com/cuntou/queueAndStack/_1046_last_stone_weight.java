package com.cuntou.queueAndStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName : _1046_last_stone_weight  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/27  10:15
 */

public class _1046_last_stone_weight {
    //选出最重的重量来进行粉碎
    //有一堆石头来进行粉碎,每一回合都要从中选出最重的两个石头来进行粉碎一下
    //有相等的话就可以直接进行粉碎,两者相等的话就可以粉碎全部的石头了
    /* leetcode 1046 号算法题：最后一块石头的重量
    有一堆石头，每块石头的重量都是正整数。
    每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
    假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
        1. 如果 x == y，那么两块石头都会被完全粉碎；
        2. 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

    输入：[2,7,4,1,8,1]
    x = 7, y = 8  --> [2,0,4,1,1,1]
    x = 2, y = 4  --> [0,0,2,1,1,1]
    x = 1, y = 2  --> [0,0,1,0,1,1]
    x = 1, y = 1  --> [0,0,0,0,0,1]
    输出： 1

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
     */
    // 排序解法
    // 时间复杂度
    // O (n) Array 的时间复杂度是O(n log n)
    public int lastStoneWeight (int[] weight) {
        int n = weight.length;
        if (n == 1) return weight[0];
        //这个循环体只是为了能够多做几次这个操作
        for (int i = 0; i < weight.length - 1 ; i++) {
            Arrays.sort(weight);
            int y = weight[n - 1];
            int x = weight[n - 2];
            if (x == 0) break;
            //如果说倒数第二大的元素已经为0了就可以提前结束这个操作了
            weight[n - 1] = y - x;
            weight[n - 2] = 0;
        }
        return weight[n -1];

    }
    //时间复杂度的最低的,瓶颈在时间复杂度,就是这个sort
    //使用的就是最大值和最小值的动作
    //维护大顶堆的性质
    // O (n) 顶堆的使用的是O(logN)
    //最终的使用的时间复杂度是O(n log n)
    public int lastStoneWeight1 (int[] stones) {
        int n = stones.length;
        if (n == 1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int stone : stones) pq.add(stone);

        while (pq.size() > 1) {
            int y = pq.remove();
            int x = pq.remove();
            int diff = y - x;
            if (diff > 0) pq.add(diff);
        }
        return pq.isEmpty() ? 0 : pq.peek();


    }



}
