package com.cuntou.queueAndStack;

import com.sun.deploy.security.BadCertificateDialog;

import java.lang.reflect.Proxy;
import java.util.PriorityQueue;

/**
 * @ClassName : _4_median_of_two_sorted_arrays  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/29  19:53
 */

public class _4_median_of_two_sorted_arrays {
    /* leetcode 4 号算法题：寻找两个正序数组的中位数

    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    请你找出并返回这两个正序数组的 中位数 。

    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2

    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

    1. nums1.length == m
    2. nums2.length == n
    3. 0 <= m <= 1000、0 <= n <= 1000、1 <= m + n <= 2000
    4. -10^6 <= nums1[i], nums2[i] <= 10^6
    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     */
    //大顶堆用存储较小的一半元素
    private PriorityQueue<Integer> maxHeap;
    //小顶堆用来存储较大的一半元素
    private PriorityQueue<Integer> minHeap;

    public double findMedianSortedArrays (int[] nums1, int[] nums2) {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();

        for (int num : nums1) addNum(num);
        for (int num : nums2) addNum(num);

        if (maxHeap.size() > minHeap.size()) {
            //说明有奇数个元素,那么大顶堆的堆顶元素就是中位数
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }



}

