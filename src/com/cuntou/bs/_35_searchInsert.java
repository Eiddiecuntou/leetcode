package com.cuntou.bs;

/**
 * @ClassName : _35_searchInsert  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  15:14
 */
//题目的意思就是去了解其实只要找到第一个比他大的元素就可以解决这些
    // 题目换算成第一个大于都等于这个目标值的位置
public class _35_searchInsert {
    //思路一 在循环体中解决这些事情
    public int searchInsertTarget(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        //需要进行插入的想法,分别去考虑的都是在前面和后面
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    //思路2: 在循环体外解决
    public int searchInsertTarget1(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        //需要进行插入的想法,分别去考虑的都是在前面和后面
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
        return left;
    }
}
