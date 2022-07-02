package com.cuntou.queueAndStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : _973_k_closest_points_to_origin  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/27  15:04
 */

public class _973_k_closest_points_to_origin {
    //找到最接近原点的k个点
    //我们有一个在平面上的点组成的列表points
    //需要从中找到k个距离远点(0,0)最近的点
    //说到底这个还是一个排序问题
    /* leetcode 973 号算法题：最接近原点的 K 个点
        我们有一个由平面上的点组成的列表 points。
        需要从中找出 K 个距离原点 (0, 0) 最近的点。
        （这里，平面上两点之间的距离是欧几里德距离。）
        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

        输入：points = [[3,3],[5,-1],[-2,4]], K = 2
            3*3 + 3*3 = 18
            5*5 + -1*(-1) = 26
            -2*(-2) + 4 * 4 = 20
        输出：[[-2,4], [3,3]]

        1 <= K <= points.length <= 10000
        -10000 < points[i][0] < 10000
        -10000 < points[i][1] < 10000
     */
    public int[][] kCloset(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1])
                        - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });

        return Arrays.copyOfRange(points,0, k);
    }

    //使用大顶堆
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, (a,b) -> (b[0] * b[0] + b[1] * b[1])
                - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.remove();
        }

        //小顶堆中存储的就是前k个高频的元素
        int[][] res = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.remove();
        }
        return res;

    }

}
