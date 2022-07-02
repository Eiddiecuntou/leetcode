package com.cuntou.滑动窗口;

/**
 * @ClassName : _76_minimum_window_substring  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/30  22:42
 */

public class _76_minimum_window_substring {
    /* 76. 最小覆盖子串
    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

    注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"

    示例 2：
    输入：s = "a", t = "a"
    输出："a"

    提示：
    1 <= s.length, t.length <= 10^5
    s 和 t 由英文字母组成
    小写字母和大写字母中间还是有8个空闲的

     
    进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

     */
    //left 剔除的时候 尝试再一次缩短这个窗口
    //理解一下只要包含这个几个字符串就可以了
    public String minWindow1 (String s, String t) {
        //统计字符串t中的每个字符出现的次数
        int[] cntT = new int[60];
        //统计 t 中的不同的字符数
        int uniqueCharsInT = 0;
        for (char c : t.toCharArray()) {
            if (cntT[c - 'A'] == 0) uniqueCharsInT++;
            cntT[c - 'A']++;

        }

        int left = 0, right = 0;
        //窗口中每个字符出现的次数
        int[] windowCntS = new int[60];
        //记录当前窗口中字符出现的次数和t中字符出现的次数相等的字符数
        int matchedChars = 0;
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            int rightCharIndex = rightChar - 'A';
            windowCntS[rightCharIndex]++;

            if (windowCntS[rightCharIndex] == cntT[rightCharIndex]) {
                matchedChars++;
            }
            //当匹配的数据都一样的时候，就可以使用这个
            while (matchedChars == uniqueCharsInT) {
                //当匹配数相等的时候，因为我们想找到最适合最短的条件的子串
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char leftChar = s.charAt(left);
                int leftCharIndex = leftChar - 'A';
                windowCntS[leftCharIndex]--;
                if (windowCntS[leftCharIndex] < cntT[leftCharIndex]) {
                    matchedChars--;
                }
                left--;
            }
            right++;
            //处理左边

        }
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2] + 1);

    }
}


