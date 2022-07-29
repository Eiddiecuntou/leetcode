package com.cuntou.动态规划._509;

/**
 * @ClassName : Fibonacci4  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  13:24
 */

public class Fibonacci4 {
    public int fib(int n) {
        if (n <= 1) return n;
        //1.定义数组，arr[i]表示的是数字i的斐波那契数
        int[] arr = new int[n + 1];

        //2.初始化数组元素
        arr[0] = 0;
        arr[1] = 1;

        //3.计算数组的元素
        for (int i = 2; i <= n ; i++) {
            arr[i] = arr[i - 1] + arr[i-2];
        }

        //4.返回最终结果
        return arr[n];
     }

}
