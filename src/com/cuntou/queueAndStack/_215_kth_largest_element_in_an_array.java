package com.cuntou.queueAndStack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName : _215_kth_largest_element_in_an_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/27  11:09
 */

public class _215_kth_largest_element_in_an_array {
    /* leetcode 215 号算法题：数组中的第 K 个最大元素

    在未排序的数组中找到第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5

    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4

    你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    //排序算法,使用的是api
    // 时间复杂度：O(nlogn)
    // 空间复杂度：快排 O(logn)，归并排序 O(n)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //其实目标就是找到第几个大的元素
    //优化的话,你需要知道可以瓶颈在哪里.就像这个题我们是对要找到第几个大的元素
    //而排序的话,我们需要对所有的元素进行排序

    public int findKthLargest1(int[] nums, int k) {
        //快速拿到K个元素中得最大值得最小值
        //去遍历整个最小值的时候,主要是要去维护小ding'du'yi
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    //小顶堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i = 0; i < nums.length ; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) pq.remove();
        }
        return pq.peek();
    }

    private Random random = new Random(System.currentTimeMillis());
    //快速排序
    public int findKthLargest3(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;
        while (true) {
            int pivotIndex = partition (nums,left,right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int pivotIndex = left + 1 + random.nextInt(right - left);
            swap(nums, pivotIndex, right);
        }
        int pivot = nums[right];
        int less = left, great = left;
        for (; great < right; great++) {
            if (nums[great] < pivot) {
                swap(nums, less, great);
                less++;
            }
        }
        swap(nums, less, right);
        return less;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
