package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _93_RestoreIpAddresses  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  15:14
 */

public class _93_RestoreIpAddresses {
    //有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    //
    //例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    //给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

    //分割成有效的ip地址
    //组成一个多叉树
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.isEmpty())
            return res;
        restoreIp(s, 0, "", 0);
        return res;
    }
    private boolean isValidIpSegment(String segment) {
        //长度的话不能大于3
        int len = segment.length();
        if (len > 3) return false;

        return (segment.charAt(0) == '0') ? (len == 1) : (Integer.valueOf(segment) <= 255);
    }
    public void restoreIp(String s, int index, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
           res.add(restored);
           return;
        }
        for (int segmentLen = 0; segmentLen < 4; segmentLen++) {
            if (index + segmentLen > s.length()) break;
            String segment = s.substring(index, index + segmentLen );
            if (!isValidIpSegment(segment)) continue;
            String suffix = count == 3 ? "" : ".";
            restoreIp(s, index + segmentLen, restored + segment+ suffix, count + 1);
        }

    }
}
