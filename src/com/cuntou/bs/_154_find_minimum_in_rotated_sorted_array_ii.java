package com.cuntou.bs;

/**
 * @ClassName : _154_find_minimum_in_rotated_sorted_array_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  20:38
 */

public class _154_find_minimum_in_rotated_sorted_array_ii {
    //存在有重复的元素
    //整个数组是有序的,定义两个指针的问题
    //又可能会错过那些值
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }else {
                right--;
            }
        }
        return nums[left];
    }
}
