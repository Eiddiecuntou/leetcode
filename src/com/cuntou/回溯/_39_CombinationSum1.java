package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _39_CombinationSum1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  11:19
 */

//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
//对于给定的输入，保证和为 target 的不同组合数少于 150 个。
public class _39_CombinationSum1 {
    //首先进行全排列
    //小于父亲节点的问题，结果不重复
    //
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        findCombinationSum(nums, 0, target, new ArrayList<>(), res);
        return res;
     }

    public void findCombinationSum(int[] nums,
                                   int startIndex,
                                   int target,
                                   List<Integer> combination,
                                   List<List<Integer>> res) {

        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex ; i < nums.length ; i++) {
           combination.add(nums[i]);
           findCombinationSum(nums, i, target - nums[i], combination,res);
           combination.remove(combination.size() - 1);

        }
    }

}
