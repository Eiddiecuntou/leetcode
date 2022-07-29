package com.cuntou.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _322_CoinChange2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  13:38
 */
//在Java界,size和length都代表长度的意思,但是size在list集合里面用,length多用于数组里面(简略)
    //bug 贪心 + 回溯
    //bug：
    //贪心的局限：并不是所有的问题都可以通过局部最优解得到整体最优解的
    //前面的选择会影响后面的选择，具备后效性
    //前面的选择不会影响后面的选择的时候，这样是最好的。
public class _322_CoinChange2 {
    //回溯
    public int coinChange(int[] c, int k) {
        //1.回溯穷举所有的硬币组合
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> coins = new ArrayList<>();
        dfs(k, c, coins, res);

        //2.没有任何硬币组合，返回-1
        if (res.isEmpty()) return -1;

        //3.找到最合适的
        int min = 0;
        for (int i = 1; i < res.size() ; i++) {
            if (res.get(i).size() < res.get(min).size()) {
                min = i;
            }
        }
        return res.get(min).size();

    }

    private void dfs(int target, int[] c,
                     List<Integer> coins,
                     List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(coins));
            return;
        }

        for (int i = 0; i < c.length ; i++) {
            coins.add(c[i]);
            dfs(target - c[i], c, coins,res);
            coins.remove(coins.size() - 1);
        }
     }
}
