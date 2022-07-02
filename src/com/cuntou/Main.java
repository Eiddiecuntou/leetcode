package com.cuntou;

/**
 * @ClassName : Main  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  11:31
 */

public class Main {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
