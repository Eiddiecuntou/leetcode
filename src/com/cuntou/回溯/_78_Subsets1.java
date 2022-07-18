package com.cuntou.回溯;

import sun.rmi.runtime.NewThreadAction;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _78_Subsets1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  14:08
 */

public class _78_Subsets1 {
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    //抽象成一个树形结构
    //首先做题是先全排列，全排列就是考虑每个数字只能使用一次，结果不是不能重复的
    //开始剪枝策略，每个数字只能使用一次，结果是不能重复的
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        findSubset(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void findSubset(int[] nums,
                            int startIndex,
                            List<Integer> subset,
                            List<List<Integer>> res) {
        //不需要考虑是否满足达标了，只要是加上去就可以都是子集
        res.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length ; i++) {
            subset.add(nums[i]);
            findSubset(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
