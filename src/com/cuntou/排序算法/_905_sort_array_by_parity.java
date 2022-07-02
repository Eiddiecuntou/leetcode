package com.cuntou.排序算法;

import com.sun.scenario.effect.Brightpass;

/**
 * @ClassName : _905_sort_array_by_parity  //类名
 * @Description :将偶数放到前面，奇数放到后面
 * @Author : 村头 //作者
 * @Date: 2022/6/1  20:20
 */

public class _905_sort_array_by_parity {
    //创建出一个数组用来装配一些东西
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];

        int count = 0;
        for (int i = 0; i < A.length ; i++) {
            if (A[i] % 2 == 0) {
                ans[count] = A[i];
                count++;
            }
        }
        for (int i = 0; i < A.length ; i++) {
            if (A[i] % 2 == 1) {
                ans[count] = A[i];
                count++;
            }

        }
        return ans;
    }
    public int[] sortArrayByParity1(int[] A) {
        int[] ans = new int[A.length];

        int left = 0;
        int right = A.length - 1;
        for (int i = 0; i < A.length ; i++) {
            if (A[i] % 2 == 0) {
                ans[left] = A[i];
                left++;
            } else {
                ans[right] = A[i];
                right--;
            }
        }
        return ans;
    }
}
