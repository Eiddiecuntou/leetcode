package com.cuntou.排序算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _57_insert_intervals  //类名
 * @Description :保证有序,不是有序的就不要,有序的就直接加进去,有必要的还是要进行合并
 *
 * @Author : 村头 //作者
 * @Date: 2022/6/8  21:13
 */

public class _57_insert_intervals {
    //先排列,再去看有没有重叠,看看是不是可以插入新的区间,区间的最大值和最小值来进行对比
    public int[][] insert (int[][] intervals, int[] newIntervals) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        //遍历所有的区间

        //1.将区间结束小于新区间开始的区间放入到结果集
        while (i < intervals.length && intervals[i][1] < newIntervals[0]) {
            res.add(intervals[i]);
            i++;
        }
        //2.将区间开始小于等于新区间结束的区间和新区间合并
        while (intervals[i][0] <= newIntervals[1]){
            newIntervals[0] = Math.min(intervals[i][0],newIntervals[0]);
            newIntervals[1] = Math.max(intervals[i][1],newIntervals[1]);
            i++;

        }
        //3.将合并后的区间放进结果集
        res.add(newIntervals);
        //4.将剩余的区间也放入结果集
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
