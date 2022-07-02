package com.cuntou.bs;

/**
 * @ClassName : _278_firstError  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/14  15:44
 */

public class _278_firstError {
    //找出第一个错误的版本
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : -1;
    }

    private boolean isBadVersion(int left) {
        return false;
    }

    public int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

