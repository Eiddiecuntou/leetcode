package com.cuntou.贪心算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : _45_JumpGame1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  14:33
 */

public class _45_JumpGame2 {
    //给定一个整数数组，你最初位于数组的第一个位置
    //数组中的每个元素代表在该位置上可以旋转跳跃
    //你的目标就是使用最少的跳跃次数达到数组的最候一个位置
    public int jump(int[] nums) {
      if (nums.length == 1) return 0;
      Queue<Integer> queue = new ArrayDeque<>();
      queue.offer(0);
      int level = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size ; i++) {
              int jumpIndex = queue.poll();
              if (jumpIndex == nums.length - 1) return level;
              for (int j = 1; j < nums[jumpIndex] ; j++) {
                  queue.offer(j + jumpIndex);
              }
          }
          level++;
      }
      return 0;

    }

}
