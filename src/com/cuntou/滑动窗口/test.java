package com.cuntou.滑动窗口;

/**
 * @ClassName : test  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/2  14:26
 */

public class test {
    //1、++i是先改i变的值即加1后再使用i的值；而i++是先使用i的值在改变它的值即加。
    //
    //2、for循环内部仅形式不同：当i++循环和++i循环在for循环内部，虽然形式上明显不同，但输出结果可以一样。如下图所示：
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n ; i++) {
            System.out.println(i);
        }
        System.out.println("-----------");
        for (int i = 0; i < n; ++i) {
            System.out.println(i);
        }
    }
}
