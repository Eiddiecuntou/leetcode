package com.cuntou.bs;

/**
 * @ClassName : _34_findLsatAndFirst  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  11:13
 */

public class _34_findLsatAndFirst {
    //查找元素, 数组是有序的,需要使用对数来解决问题那么就直接使用 二分查找
    //[firstTargetIndex,lastTargetIndex]
    // 思路一：在循环体内查找目标值
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{-1, -1};

        int firstTargetIndex = searchFirstTargetIndex(nums,target);
        if (firstTargetIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastTargetIndex = searchLastTargetIndex(nums,target);
        return new int[]{firstTargetIndex,lastTargetIndex};
    }

    private int searchLastTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                else left = mid + 1;
            } else if (target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    private int searchFirstTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid + 1;
            } else {
                left = mid - 1;
            }

        }
        return -1;

    }

    private int searchLastTargetIndex1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return -1;

    }

    private int searchFirstTargetIndex1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        if (nums[left] == target) return left;
        return -1;

    }

}
