package com.cuntou.排序算法;

/**
 * @ClassName : _179_Max_num  //类名
 * @Description :
 * 使用一个非负整数 Nums ,重新排列每个数的顺序,使其重新组成一个最大的数字
 * 使用的字符串来进行排列,每个数字来进行排序
 * 怎么样进行排序,降序排列,数字都是放在后面,使用快排,比较两个至三个
 * 使用就是
 * x y xy > yx --> 所以y应该在x后面
 * @Author : 村头 //作者
 * @Date: 2022/6/8  9:58
 */

public class _179_Max_num {
    //自定义排序
    public String largestNumbers(int[] nums) {
        sort(nums, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int str : nums) {
            sb.append(str);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    //三路快排
    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        //分区
        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;
        while (i <= great) {
            if ((data[i] + "" + pivot).compareTo(pivot + "" + data[i]) > 0) {
                swap(data, i, less);
                less++;
                i++;
            } else if ((data[i] + "" + pivot).compareTo(pivot + "" +data[i]) < 0) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }

        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }

    private void swap(int[] strs, int i, int j) {
        int tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

}
