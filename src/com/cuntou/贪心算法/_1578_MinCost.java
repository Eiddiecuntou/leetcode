package com.cuntou.贪心算法;

/**
 * @ClassName : _1578_MinCost  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/22  19:22
 */
//maxCost = 0, sumCost = 0
public class _1578_MinCost {
    //贪心的策略的定好
    //贪心的策略:碰到相同的字母的时候,我们贪心的策略就是每次删除成本最小的字符,也可以说保留删除成本最大的字符
    public int minCost(String s, int[] cost) {
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            int maxCost = 0;
            int sumCost = 0;
            while (i < len && s.charAt(i) == c) {
                maxCost = Math.max(maxCost, cost[i]);
                sumCost = sumCost + cost[i];
                i++;
            }
            res += (sumCost - maxCost);
        }
        return res;
    }
}
