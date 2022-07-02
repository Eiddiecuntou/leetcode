package com.cuntou.stack;

import java.util.ArrayDeque;

/**
 * @ClassName : _42_trapping_rain_water  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:39
 */

public class _42_trapping_rain_water {


    //装雨水
    //柱子之间是永远接不到水的
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int ans = 0;
        for (int i = 0; i < height.length - 1  ; i++) {
            //求左边的最大值
            int leftMax = 0;
            for (int j = i - 1; j >= 0 ; j++) {
                leftMax = Math.max (leftMax, height[j]);
            }

            //求右边的最大值
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax,height[j]);
            }

            int maxHeight = Math.min(leftMax, rightMax);
            if (maxHeight > height[i])
                ans += maxHeight - height[i];
        }
        return ans;
    }
    // 递减的时候,只有当他大的时候才会需要计算
    public int trap1(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n ; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) break;

                int leftIndex = stack.peek();
                int currWidth = i - leftIndex - 1;
                int currHeight = Math.min(height[leftIndex], height[i] - height[top]);
                ans += currHeight * currWidth;
            }
            stack.push(i);
        }
        return ans;
    }


}
