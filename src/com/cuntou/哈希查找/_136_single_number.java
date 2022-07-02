package com.cuntou.哈希查找;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : _136_single_number  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/18  14:12
 */

public class _136_single_number {
    /* leetcode 136 号算法题：只出现一次的数字
        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
        找出那个只出现了一次的元素。

        输入: [2,2,1]
        输出: 1

        输入: [4,1,2,1,2]
        输出: 4

        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    // 暴力
    // 因为使用的这个可以考虑数组中的想法要么是正负数,要么使用boolean
    public int singleNumber (int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < nums.length ; j++) {
                if (i != j && nums[i] == nums[j]) isExist = true;
            }
            if (!isExist) return nums[i];
        }
        return -1;
    }

    //使用哈希查找
    //哈希set来做
    public int singleNumber1(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
