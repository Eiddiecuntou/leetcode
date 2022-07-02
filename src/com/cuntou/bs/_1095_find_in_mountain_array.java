package com.cuntou.bs;

/**
 * @ClassName : _1095_find_in_mountain_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/16  17:05
 */

public class _1095_find_in_mountain_array {
    //完全可以使用线性扫描的方式，可能存在前半部分也有可能存在后半部分
    // peakIndex
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //1.首先要找到峰顶元素的索引
        int peakIndex = searchPeakIndex(mountainArr);
        //2.在前半部分应用二分查找算法来查找目标值
        int index = binarySearchFrontPart(mountainArr,0,peakIndex,target);
        if (index != -1) {
            return index;
        }
        //3.在后半部分使用二分查找算法查找目标值
        return binarySearchLatterPart(mountainArr,peakIndex,mountainArr.length() - 1,target);

    }
    // 1. 找到峰顶元素索引
    private int searchPeakIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    //2.在前半部分应用二分法查询目标值
    private int binarySearchFrontPart(MountainArray mountainArr, int left, int peakIndex, int target) {
        while (left < peakIndex) {
            int mid = left + (peakIndex - left) / 2;
            if (target > mountainArr.get(mid)) {
                left = mid + 1;
            } else {
                peakIndex = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        return -1;
    }
    // 3. 在后半部分应用二分查找算法查找目标值（思路 2 实现）
    private int binarySearchLatterPart(MountainArray mountainArr, int peakIndex, int right, int target) {
        while (peakIndex < right) {
            int mid = peakIndex + (right - peakIndex) / 2;
            if (target < mountainArr.get(mid)) {
                peakIndex = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(peakIndex) == target) return peakIndex;
        return -1;
    }

}
