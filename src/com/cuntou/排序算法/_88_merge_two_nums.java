package com.cuntou.排序算法;

/**
 * @ClassName : _88_merge_two_nums
给你两个按非递减顺序 排列的整数数组nums1 和nums2，
另有两个整数m和n分别表示nums1 和 nums2 中的元素数目。
请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * @Author : 村头 //作者
 * @Date: 2022/5/31  15:45
 */

public class _88_merge_two_nums {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j > 0)  {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
