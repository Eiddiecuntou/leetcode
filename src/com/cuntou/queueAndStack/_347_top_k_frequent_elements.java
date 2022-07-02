package com.cuntou.queueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName : _347_top_k_frequent_elements  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/27  14:03
 */

public class _347_top_k_frequent_elements {
    /* leetcode 347 号算法题：前 K 个高频元素

    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
    你可以按 任意顺序 返回答案。

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [2, 1]

    输入: nums = [1], k = 1
    输出: [1]

    1 <= nums.length <= 10^5
    k 的取值范围是 [1, 数组中不相同的元素的个数]
    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

    进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     */

    //找出前K个频率最高的元素
    public int[] topKFrequent(int[] nums, int k) {
        //找出前k个频率最高的,那么就是得把每个元素出现几次得都放到一个表中找到他
        //找到一个一一对应得值,按照出现得次数来进行排列
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num,count.getOrDefault(num,0) + 1);
        }

        //在优先队列中,用元素出现得次数
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(k + 1,(a,b) -> (count.get(a)-count.get(b)));

        for (int num :count.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.remove();
        }

        //小顶堆中存储得就是前k个高频元素
        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.remove();
        }

        return res;

    }
}
