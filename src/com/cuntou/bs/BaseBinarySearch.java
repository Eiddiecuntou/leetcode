package com.cuntou.bs;

/**
 * @ClassName : BaseBinarySearch  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/13  10:00
 */

public class BaseBinarySearch {
    //时间复杂度O(logn)
    //空间复杂度O(n)
    public boolean contains(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        //整个进行向上取整的操作
        int left = 0;
        int right = nums.length - 1;

        //
        while (left <= right) {
            // bug: 整型得最大值 2^31 - 1 = 2147483647
            // left + right 可能会溢出
            //整个进行向上取整的操作,int mid = left + (right - left + 1) / 2;
            int mid = left + (right - left) / 2;
            //整数相减得话不会溢出
            //使用位运算 >> 1 相等于除以2 ,右移操作跟这个是一样得
            // >>> 无符号右移 int mid = (left + right) >>> 1;使用这个来进行直接进行补码,右移操作, 1 是负数,0 是正数
            if (target == nums[mid]) {
                return true;
            } else if (target > nums[mid]) {
                left = mid + 1;
                //下一次的搜索区间就是为[mid + 1 ... right]
            } else {
                right = mid - 1;
                //下一次的搜索区间就是为[left ... mid - 1]
            }
        }

        //left > right : 就可以结束循环了
        return false;
    }
    public boolean containsR(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return contains(nums, 0,nums.length - 1,target);
    }

    private boolean contains(int[] nums, int left, int right, int target){
        if (left > right) return false;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return true;

        if (target < nums[mid]) {
            return contains(nums,left,mid - 1,target);
        } else {
            return contains(nums,mid + 1, right,target);
        }
    }

    //思路2 判断在循环体中一定不存在的目标元素的区间
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;

        int left = 0;
        int right = nums.length - 1;
        //搜索区间是[left... right] 中的每个元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            //小于这个的全部舍弃
            if (target > nums[mid]) left = mid + 1;
            //大于这个的话 有可能跟这个有关系
            else right = mid;
        }
        //循环结束之后: left == right
        //需要后处理,因为在循环中,还有一个元素没有处理
        if (nums[left] == target) return left;
        return -1;
    }
 }
