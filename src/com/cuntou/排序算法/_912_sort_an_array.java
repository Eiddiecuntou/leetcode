package com.cuntou.排序算法;

import sun.security.util.DerEncoder;

import java.util.Random;

/**
 * @ClassName : _912_sort_an_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/5/30  21:34
 */

public class _912_sort_an_array {
    //归并排序
    public int[] sortArray1(int[] nums) {
        mergeSort(nums,0,nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi, int[] tmp) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) /2;

        mergeSort(nums, lo, mid, tmp);
        mergeSort(nums, mid + 1, hi, tmp);

        merge(nums, lo, mid, hi, tmp);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] tmp) {
        for (int i = lo; i <= hi ; i++) {
            tmp[i] = nums[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi ; k++) {
            //左边遍历完了,就把所有的元素都放到左边当中去
            if (i == mid + 1) nums[k] = tmp[j++];
            //右边遍历完了,就把所有的元素都放到右边当中去
            else if (j == hi + 1) nums[k] = tmp[i++];
            else if (tmp[i] <= tmp[j]) nums[k] = tmp[i++];
            else nums[k] = tmp[j++];
        }
    }

    //快速排序
    //快速排序做的就是使用一个点来进行
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int index = partition(nums, lo, hi);
        quickSort(nums, lo, index - 1);
        quickSort(nums, index + 1, hi);
    }

    //二分切分
    private int partition(int[] nums, int lo, int hi) {
        int i = new Random().nextInt(hi - lo + 1) + lo;
        swap(nums,i,hi);
        //保证了极限情况,防止这个数组是一个有序数组
        int pivot = nums[hi];
        int less = lo, great = lo;
        for (;great <= hi - 1; great++) {
            if (nums[great] < pivot) {
                swap(nums,less,great);
                less++;
            }
        }
        swap(nums, less , hi);
        return less;

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 三路快排，分成三部分 <pivot =pivot >pivot
     * 保证循环不变量
     * [lo...less) < pivot
     * [less...li) = pivot
     * [li...great} 指的是中间未处理的部分
     * [great...hi] > pivot
     */

    //三路快排
    private void quickSort1(int[] nums, int lo ,int hi) {
        if (lo >= hi) return;

        int j = new Random().nextInt(hi - lo + 1) + lo;
        //随机选一个作为pivot
        swap(nums, j, hi);
        int pivot = nums[hi];
        int less = lo, great = hi;
        int i = lo;
        while (i <= great) {
            if (nums[i] < pivot) {
                swap(nums, i, less);
                less++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, great);
                great--;
            } else {
                //等于就不变
                i++;
            }
        }

        quickSort1(nums,lo,less - 1);
        quickSort(nums,great + 1, hi);


    }

}
