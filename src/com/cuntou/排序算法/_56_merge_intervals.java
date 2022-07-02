package com.cuntou.排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : _56_merge_intervals  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/8  11:16
 */

public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];

        //1.按照区间的左边值进行升序排列
        Arrays.sort(intervals,((o1, o2) -> o1[0] - o2[0]));

        //2.初始化outputs,用于储存合之后的区间结果的动态数组
        List<int[]> outputs = new ArrayList<>();
        //3.遍历处理每一个区间
        outputs.add(intervals[0]);
        /**
         * 判断是不是第一个区间的话,
         * if (output.isempty()){
         *
         */
        for (int i = 0; i < intervals.length ; i++) {
            int[] lastInterval = outputs.get(outputs.size() - 1);
            int currLeft = intervals[i][0];
            int currRight = intervals[i][1];
            if (lastInterval[1] < currLeft) {
                outputs.add(intervals[i]);
            } else {
                lastInterval[1] = Math.max(lastInterval[1],currRight);
            }
        }
        return outputs.toArray(new int[outputs.size()][]);



    }
}
