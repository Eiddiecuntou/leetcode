package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _22_GenerateParenthesis1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/20  17:41
 */
//标准的满二叉树
public class _22_GenerateParenthesis1 {
    public List<String> generateParenthesis(int n ) {
       List<String> res = new ArrayList<>();
       if (n <= 0) return res;
       dfs(n, "", res);
       return res;
    }

    private void dfs (int n, String path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }

        dfs (n, path + "(",res);
        dfs (n, path + ")",res);

    }

    public static void main(String[] args) {
        System.out.println(new _22_GenerateParenthesis1().generateParenthesis(2));
    }
}
