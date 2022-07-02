package com.cuntou.bs;

/**
 * @ClassName : BinarySearch  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  9:47
 */

public class BinarySearch {
    // 查找第一个等于目标元素的下标
    public int firstTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                /*
               符合条件得就返回Mid
               1.mid 是数组的第一个元素
               2.mid 前面的元素不等于target
                 */
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else right = mid -1;
            } else if (nums[mid] < target) {
                left = mid -1;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }
    //查找第一个大于等于目标元素的下标
    public int firstTargetElement1(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }
    //查找最后一个等于8的位置,最后一个等于这个值一定是在右半边,
    public int lastTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                /*
               符合条件得就返回Mid
               1.mid 是数组的最后一个个元素
               2.mid 后面的元素不等于target
                 */
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid -1;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }
    //查找最后一个小于等于目标元素的下标
    public int LastTargetElement1(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) return mid;
                else left = mid + 1;
            } else {
                //target < nums[mid]
                right = mid - 1;
            }
        }
        return -1;

    }
}
