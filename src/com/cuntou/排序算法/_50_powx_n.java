package com.cuntou.排序算法;

/**
 * @ClassName : _50_powx_n  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/1  21:09
 */

public class _50_powx_n {

    //快速幂 就是不停的将数据分开 时间复杂度就是logn，先分解再合并

    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return quickPow(x , n);

    }

    private double quickPow(double x, int n) {

        if (n == 0) return 1.0;
        if (n == 1) return x;
        int mid = n / 2;
        double y = quickPow(x , mid);
        return n % 2 == 0 ?  y * y : x * y * y;

    }



    public double myPow1(double x, int n) {
        //考虑特殊的情况，如果是底数是负数，指数是负数
        long b = n ;
        if (b < 0) {
            x = 1 / x;
            b = - b;
        }
        //定义一个结果集来直接存储这个数据
        double res = 1;
        //求相乘的结果就是初始值为1
        for (int i = 0; i < b ; i++) {
            res *= x;
        }
        return res;
    }

}
