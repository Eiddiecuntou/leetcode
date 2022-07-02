package com.cuntou.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName : _84_largest_rectangle_in_histogram  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:39
 */

public class _84_largest_rectangle_in_histogram {
    //柱状图中得最大矩形
    // 宽和高 之间的变量 ,枚举宽和枚举高
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int left = 0; left < heights.length ; left++) {
            int minHeight = heights[left];
            for (int right = left; right < heights.length ; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                //[left,right]
                int currWidth = right - left + 1;
                ans = Math.max(ans, minHeight * currWidth);
            }
        }
        return ans;
    }

    //枚举高.宽度就可以确定,找到比中间值小的左右的两个边界值
    // 然后就可以找到 right - left - 1 这些东西来进行计算,算出面积
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n ; mid++) {
            int height = heights[mid];

            //确定左右边界
            int left = mid ,right = mid;
            while (left >= 0 && heights[left] >= height) left--;
            while (right < n && heights[right] >= height) right++;

            ans = Math.max(ans, height * (right - left + 1));
        }
        return ans;
    }
    //枚举高,来进行优化
    //找到第一个比我小的元素,是不是可以考虑到一件事,我们可以使用栈
    public int largestRectangleArea3 (int[] height) {
        int n = height.length;
        //1.计算没跟柱子左边第一个小于这个柱子的柱子每根柱子的左边界
        int[] left = new int[n];
        Arrays.fill(left,-1);
        //-1 的意思就是没有左边界设置的,所以均使用-1 来进行填充的
        ArrayDeque<Integer> stacks = new ArrayDeque<>();
        for (int i = n -1 ; i >= 0 ; i++) {
            while (!stacks.isEmpty() && height[i] < height[stacks.peek()]) {
                left[stacks.peek()] = i;
                stacks.pop();
            }
            stacks.push(i);
        }
        // 如果没有没有比右边得值大的话，直接将右边界的值设置为数组的长度
        // 2. 计算每根柱子右边第一个小于这根柱子的柱子(每根柱子的右边界)
        int[] right = new int[n];
        Arrays.fill(right, n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        int ans = 0;
        for (int mid = 0; mid < n; mid++) {
            int heights = height[mid];
            ans = Math.max(ans, heights * (right[mid] - left[mid] - 1));
        }
        return ans;
    }

    //方案二
    //左边界,从左往右遍历
    //右边界,从右往左遍历
    //这个方法的想法就是如果是栈顶的元素比他小的话就可以直接进行压栈操作
    public int largestRectangleArea4 (int[] height) {
        int n = height.length;
        //1. 计算每根柱子左边第一个小于这根柱子的柱子(每根柱子的左边界)
        int[] left = new int[n];
        //-1 的意思就是没有左边界设置的,所以均使用-1 来进行填充的
        ArrayDeque<Integer> stacks = new ArrayDeque<>();
        for (int i = 0; i < n ; i++) {
            //变成了小于等于来进行pop 因为不需要你来等于
            //找到第一个比他小的,不能等于
            while (!stacks.isEmpty() && height[i] <= height[stacks.peek()]) {
                stacks.pop();
            }
            left[i] = (stacks.isEmpty() ? -1 : stacks.peek());
            stacks.push(i);
        }
        // 如果没有没有比右边得值大的话，直接将右边界的值设置为数组的长度
        //2. 计算每根柱子右边第一个小于这根柱子的柱子(每根柱子的右边界)
        int[] right = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1  ; i >= 0 ; i-- ){
            //找右边界就是去找左边第一个值比右边小的
            while (!stack.isEmpty() && height[i] <= height[stacks.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int mid = 0; mid < n; mid++) {
            int heights = height[mid];
            ans = Math.max(ans, heights * (right[mid] - left[mid] - 1));
        }
        return ans;
    }
    //使用两个for循环都是左右两个方向去遍历的,如果只使用一次遍历的方法,导致了两个方向的变成了一个方向
    //单调栈的一次遍历,从左往右
    //相等的柱子的时候两个的面积是相等的,只用计算出一个的面积就可以了,因为两个柱子最终计算出来的值是总会找到一个有用的
    public int largestRectangleArea5(int[] heights) {
        int n = heights.length;
        //1.计算每根左边第一个小于这根柱子的柱子(每根柱子的左边界)
        int[] left = new int[n];
        int[] right = new int[n];
        //要将右边界所有的值都设为n,没有左边界的需要设置为n
        Arrays.fill(right,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n ; i++) {
            // 注意：如果出现 heights[i] == heights[stack.peek()] 的情况
            // 那么两个柱子计算出来的面试是一样大的，不管弹不弹出栈顶元素的话
            // 都会有一个柱子的面积计算小了，而另一个柱子面积计算正确
            // 因为我们求的是最大面积，所以这就够了
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                right[stack.peek()] = i ;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
            }
        int ans = 0;
        for (int mid = 0; mid < n ; mid++) {
            int height = heights[mid];
            ans = Math.max (ans,height * (right[mid] - left[mid] - 1));
        }
        return ans;

    }

}
