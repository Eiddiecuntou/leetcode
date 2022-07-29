package com.cuntou.动态规划._131;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _131_PalindromeSubstring00  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  15:22
 */

public class _131_PalindromeSubstring00 {
    //分割回文子串，如果这个是子串就放进这个数组中，如果不是就不放进去
    //可以直接考虑。回溯，将其转换为树状图，树状图之后就可以开始考动态规划了
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length() ; i++) {
           //[start,i]
            String subStr = s.substring(start,i + 1);
            //找到所有的子节点
            if (!isPalindrome(subStr)) continue;
            path.add(subStr);
            dfs(s, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    //判断子串是否是回文
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length();
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
