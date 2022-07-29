package com.cuntou.动态规划._322;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName : _322_CoinChange4  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  20:15
 */

public class _322_CoinChange4 {
    //DP
    public int coinChange(int[] c, int k) {
        if (k < 0) return -1;
        if (k == 0) return 0;

        //1.状态定义：dp[i]表示凑齐总金额为i的时候需要最小的硬币数
        int[] dp = new int[k + 1];

        //2.状态的初始化
        //注意：因为要比较的是最小值，所以不可能得值就赋值为一个最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 3. 状态转移
        for (int target = 1; target <= k; target++) {
            for (int coin : c) {
                if (target >= coin && dp[target - coin] != Integer.MAX_VALUE) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }

        // 4. 返回最终需要的状态值
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }
}
