package com.cuntou.bs;

import java.util.UUID;

/**
 * @ClassName : CutWood  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/16  20:17
 */
//给定一个数组nums,在每个元素代表一个木头的长度
//木头可以任意截断，在这堆木头中截出至少k个长度为m的木块，已知k，求m的最大值
public class CutWood {
    //暴力解法 将最大的元素作为木有的长度，针对每个长度，做下面的事情
    //计算所有的元素可以截取多少个这个长度的木头
    //如果截取的这个长度的木头数比k大，则去更新最大的k值
    public int cutWood (int k, int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int maxM = 0;
        for (int m = 1; m < maxValue; m++) {
            int cnt = 0;
            for (int i = 0; i < nums.length ; i++) {
                cnt += nums[i] / m;
            }
            if (cnt >= k) maxM = Math.max(maxM,m);

        }
        return maxM;
    }
    //优化思路:
}
