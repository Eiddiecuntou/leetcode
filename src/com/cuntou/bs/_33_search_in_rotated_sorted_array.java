package com.cuntou.bs;

/**
 * @ClassName : _33_search_in_rotated_sorted_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  19:35
 */
//旋转之前都是有序的,旋转的话是不一定的.可能是旋转的多个点
    //旋转数组的话,前半部分数组有序的值都大于后半部分有序的值.
    //
public class _33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[left] <= nums[mid]) {
                //左边有序,将搜索区间缩小
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;

                }
            } else {
                //右边有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

}
