package com.cuntou.哈希查找;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : _128_longest_consecutive_sequence  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/19  9:56
 */

public class _128_longest_consecutive_sequence {
     /*  leetcode 128 号算法题：最长连续序列

        给定一个未排序的整数数组 nums ，
        找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

        输入：nums = [100,4,200,1,3,2]
        输出：4

        输入：nums = [0,3,7,2,5,8,4,6,0,1]
        输出：9


        0 <= nums.length <= 10^4
        -10^9 <= nums[i] <= 10^9

        进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     */

    // 排序解法
    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(n)
    // 使用这个前期应该可以先排序一下
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        Arrays.sort(nums);

        int ans = 1;
        int count = 1;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                ans = Math.max(ans,count);
            }
        }
        //考虑的就最后一个也是连续的，那么这个ans 就不一定能够加上去
        return Math.max(ans,count);
    }
    //当前的数字 应该就是下一个元素，后面的一个元素，后面的值就是1，
    // 处理下个元素的同时，考虑的就是每个元素的索引之间的关系
    // 哈希查找解法
    // 时间复杂度是O(n)
    // 空间复杂度是O(n)
    public int longestConsecutive1(int[] nums) {
        if (nums.length < 2) return nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int ans = 1;
        for (int num : nums) {
            //存在的重复计算,如果说不进行计算的话,他们就会进行不停的累加
            if (set.contains(num - 1)) continue;

            int currNum = num;
            int count = 1;
            while (set.contains(currNum + 1)) {
                currNum  += 1;
                count += 1;
            }

            ans = Math.max(ans,count);
        }

        return ans;
    }
}
