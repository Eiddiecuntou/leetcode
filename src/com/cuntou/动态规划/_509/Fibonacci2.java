package com.cuntou.动态规划._509;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Fibonacci2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/24  11:42
 */

public class Fibonacci2 {
    private Map<Integer, Integer> map;
    public int fib(int n) {
        map = new HashMap<>();
        return dfs(n);
    }
    //时间复杂度：O(n)
    private int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //先从Map中检索子问题的解
        //如果已经计算，直接返回即可
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int leftFib = dfs(n - 1);
        int rightFib = dfs(n - 2);
        //从计算好的结果放入到Map，编译后继续检索
        map.put(n, leftFib + rightFib);

        return leftFib + rightFib;
    }

}
