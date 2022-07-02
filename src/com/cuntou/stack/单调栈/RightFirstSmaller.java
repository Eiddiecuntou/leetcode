package com.cuntou.stack.单调栈;

import java.util.ArrayDeque;

/**
 * @ClassName : RightFirstSmaller  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  11:01
 */

public class RightFirstSmaller {
    /*
        题目：找出数组中右边第一个比我小的元素
        一个整数数组 nums，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
        输入：[5, 2]
        输出：[1, -1]

        解释：
            因为元素 5 的右边离我最近且比我小的位置应该是 nums[1]，
            最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
     */
    // 首先分析题目，我们是要进行找索引。暴力解法的话，挨个进行遍历，时间复杂度太大了
    // 空间复杂度是O（n)
    // 时间复杂度是O(n) 最多会遍历两次数组
    public int[] findRightSmall (int[] nums) {
        //首先建立一个最中的数组
        int[] ans = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length ; i++) {
            int x = nums[i];
            //单调递增栈
            while (!stack.isEmpty() && x < nums[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            //先压进去
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;
    }
}
