package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _22_GenerateParenthesis2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/20  17:41
 */

public class _22_GenerateParenthesis2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) return;

        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }

        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }

    public static void main(String[] args) {
        System.out.println(new _22_GenerateParenthesis2().generateParenthesis(3));
    }
}
