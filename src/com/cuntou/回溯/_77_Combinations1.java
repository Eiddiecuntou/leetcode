package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _77_Combinations1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  10:34
 */

public class _77_Combinations1 {
    //组合的意思，选择两个选择k个
    //剪枝的策略：每个数字只能用一次，而且不能重复
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return res;
        dfs(n, k,1, combination, res);
        return res;
    }

    private void dfs(int n,int k,
                     int start,
                     List<Integer> combination,
                     List<List<Integer>> res) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n ; i++) {
            combination.add(i);
            //
            dfs(n, k, i + 1,combination, res);
            combination.remove(combination.size() - 1);

        }
    }

    public static void main(String[] args) {
        System.out.println(new _77_Combinations1().combine(4,2));
    }
}
