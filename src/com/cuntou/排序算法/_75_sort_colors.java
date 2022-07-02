package com.cuntou.排序算法;

import java.util.UUID;

/**
 * @ClassName : _75_sort_colors  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/1  22:02
 */

public class _75_sort_colors {
    // 0 1 2 这样的话要返回三个阶段
    // 计数排序
    public void sortColors(int[] nums) {
        //计数，因为只有三个元素
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        //排序
        int k = 0;
        for (int i = 0; i < 3 ; i++) {
            int iCnt = count[i];
            for (int j = 0; j < iCnt ; j++) {
                nums[k++] = i;
            }
        }

    }
    //三路快排
    public void sortColors1(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, i ,zero);
                i++;
                zero++;
            } else if (nums[i] == 2) {
                swap(nums, i ,two);
                two--;
            } else {
                i++;
            }
        }
     }

     private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
     }


}
