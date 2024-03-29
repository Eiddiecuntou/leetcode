package com.cuntou.动态规划._509;

/**
 * @ClassName : Fibonacci1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  17:16
 */

public class Fibonacci1 {
    /* 509. 斐波那契数
    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
    该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

    F(0) = 0，F(1) = 1
    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    给你 n ，请计算 F(n) 。
    示例 1：
    输入：2
    输出：1
    解释：F(2) = F(1) + F(0) = 1 + 0 = 1
    示例 2：
    输入：3
    输出：2
    解释：F(3) = F(2) + F(1) = 1 + 1 = 2

    示例 3：
    输入：4
    输出：3
    解释：F(4) = F(3) + F(2) = 2 + 1 = 3  
    提示：
    0 <= n <= 30
     */
    //DFS


    //时间复杂度
    public int fib(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int leftFib = dfs(n - 1);
        int rightFib = dfs( n -2);

        return leftFib + rightFib;
    }
}
