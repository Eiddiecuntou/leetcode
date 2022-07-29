package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName : _45_JumpGame1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  14:33
 */

public class _45_JumpGame3 {
    //给定一个整数数组，你最初位于数组的第一个位置
    //数组中的每个元素代表在该位置上可以旋转跳跃
    //你的目标就是使用最少的跳跃次数达到数组的最候一个位置
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps = 0;
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            int maxPos = 0;
            //每次有个最远的距离
            for (int i = start; i <= end ; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end + 1;
            end = maxPos;
            steps++;
        }
        return steps;

    }

}
