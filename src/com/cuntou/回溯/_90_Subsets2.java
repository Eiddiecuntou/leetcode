package com.cuntou.回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : _90_Subsets2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  14:23
 */

public class _90_Subsets2 {
    //我们bu需要重复的元素
    //我们将重复的元素全部去掉的
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        findSubSet(nums,0, new ArrayList<>(), res);
        return res;
     }

    public void findSubSet(int[] nums,
                           int startIndex,
                           List<Integer> combination,
                           List<List<Integer>> res) {
        res.add(new ArrayList<>(combination));
        for (int i = startIndex; i < nums.length ; i++) {
            // i > startIndex 的目的就是为了排除 i == startIndex 的情况，也就是保证 i 不是第一个子节点
            // 因为第一个子节点前面没有节点的，那么 nums[i] == nums[i - 1] 就没有意义的
            if (i > startIndex && nums[i - 1] == nums[i]) continue;
            combination.add(nums[i]);
            findSubSet(nums, i + 1, combination,res);
            combination.remove(combination.size() - 1);
        }
    }
}
