package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : _40_CombinationSum2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  11:19
 */

public class _40_CombinationSum2 {
    //如果说存在重复的数字的话，他的目标元素的数值和是什么
    //每个数字的话只能使用一次，结果中不能包含重复的数字
    public List<List<Integer>> combinationSum(int[] nums,int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    findCombination(nums, 0, target, new ArrayList<>(),res);
    return res;
    }

    public void findCombination (int[] nums,
                                 int startIndex,
                                 int target,
                                 List<Integer> combination,
                                 List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < nums.length ; i++) {
            //为了保证了访问的顺序，所以使用的是i > startIndex
            if(i > startIndex && nums[i] == nums[i - 1]) continue;
            combination.add(nums[i]);
            findCombination(nums,i + 1, target, combination, res);
            combination.remove(combination.size() - 1);
        }
    }

}
