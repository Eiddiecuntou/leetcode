package com.cuntou.stack;

import java.util.ArrayDeque;

/**
 * @ClassName : _321_create_maximum_number  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:40
 */

public class _321_create_maximum_number {
    /* leetcode 321 号算法题：拼接最大数
        给定长度分别为 m 和 n 的两个数组，其元素由 0 - 9 构成，表示两个自然数各位上的数字。
        现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
        要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
        求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
        说明: 请尽可能地优化你算法的时间和空间复杂度。

        输入:
            nums1 = [3, 4, 6, 5]    --> 6, 5
            nums2 = [9, 1, 2, 5, 8, 3]   --> 9, 8, 3
            k = 5
       输出：[9,8,6,5,3]
     */
    // 拼接的最大数,有的时候可能是最大的,有的时候不是最大的
    // m [2,3,4,6]
    // n [9,1,2]  k = 5
    //最小的情况, 0 , k - n = 2
    //max(0, k -n )
    //最大的情况, m k
    //min(m,k)

    public int[] maxNumber(int[] nums1,int[] nums2,int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxSubSeq = new int[k];
        //1.将第一个数组中的可以取最多和最少的元素定下来
        int start = Math.max(0,k - n);
        int end = Math.min(m,k);

        //找出最大的序列
        for (int i = start; i < end ; i++) {
            int[] subSeq1 = maxSubSequence(nums1,i);
            int[] subSeq2 = maxSubSequence(nums2,i);
            int[] currMaxSubSeq = merge(subSeq1,subSeq2);
            if (compare(currMaxSubSeq,0,maxSubSeq,0) > 0) {
                System.arraycopy(currMaxSubSeq,0,maxSubSeq,0,k);
            }
    }
        return maxSubSeq;

 }
    //进栈这些东西的稳定
    private int[] maxSubSequence(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //判断是否剩余
        int remain = nums.length - k;
        for (int i = 0; i < nums.length ; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && num > stack.peek() && remain > 0 ) {
                stack.pop();
                remain--;
            }
            if (stack.size() < k) {
                stack.push(num);
            } else {
                remain--;
            }
        }
        int[] res = new int[k];
        int index = k - 1;
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index--;
        }
        return new int[0];
    }

    //合并的时候也要考虑一件事,排序的问题,谁在前谁在后
    private int[] merge(int[] subSeq1, int[] subSeq2) {
        int x = subSeq1.length;
        int y = subSeq2.length;
        if (x == 0) return subSeq2;
        if (y == 0) return subSeq1;
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int index1 = 0,index2 = 0;
        for (int i = 0; i < mergeLen ; i++) {
            if (compare(subSeq1,index1,subSeq2,index2) > 0) {
                merged[i] = subSeq1[index1++];
            } else {
                merged[i] = subSeq2[index2++];
            }
        }
        return merged;
    }
    //我们要考虑这个compare了
    private int compare(int[] subSeq1, int index1,
                        int[] subSeq2, int index2) {
        int x = subSeq1.length;
        int y = subSeq2.length;
        while (index1 < x && index2 < y) {
            int diff = subSeq1[index1] - subSeq2[index2];
            if (diff != 0) return diff;
            index1++;
            index2++;
        }
        //这个就是为了比较剩下的,如果一个已经结束了,一个还有的话使用这个比较好,可以返回.
        return (x - index1) - (y - index2);

    }


}


