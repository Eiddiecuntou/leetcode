package com.cuntou.动态规划._509;

/**
 * @ClassName : Fibonacci6  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  13:37
 */

public class Fibonacci6 {
    //状态数组的压缩
    public int fib(int n) {
        if (n <= 1) return n;

        int prev = 0;
        int curr = 1;

        for (int i = 2; i < n ; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
