package com.cuntou.stack.单调栈;

import java.util.ArrayDeque;

/**
 * @ClassName : LeftLastLarger  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  10:08
 */

public class LeftLastLarger {
    //单调栈，指的就是必须按照升序排列或者降序排列的栈
    //找出数组中右边第一个比我小的元素
    // 初始化一个结果数组 升序的每一个元素
    /*
        题目：找出数组中左边离我最近比我大的元素
        一个整数数组 nums，找到每个元素：左边第一个比我小的下标位置，没有则用 -1 表示。
        输入：[1, 2]
        输出：[-1, 0]

        解释：
            因为元素 2 的左边离我最近且比我小的位置应该是 nums[0]，
            第一个元素 1 左边没有比 1 小的元素，所以应该输出 -1。
     */
    public int[] findLeftLastLarge (int[] nums) {
        int[] ans = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 时间复杂度 O(n)
        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            int x = nums[i];
            //单调递减的
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;


    }



}
