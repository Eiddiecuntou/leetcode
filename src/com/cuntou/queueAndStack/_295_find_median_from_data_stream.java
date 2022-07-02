package com.cuntou.queueAndStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName : _295_find_median_from_data_stream  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/29  20:03
 */

public class _295_find_median_from_data_stream {
     /* leetcode 295 号算法题：数据流的中位数

    中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
    例如，
    [2,3,4] 的中位数是 3
    [2,3] 的中位数是 (2 + 3) / 2 = 2.5
    设计一个支持以下两种操作的数据结构：
         void addNum(int num) - 从数据流中添加一个整数到数据结构中。
         double findMedian() - 返回目前所有元素的中位数。

    进阶：
    1. 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
    2. 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
     */
}
//1.普通排序
class MedianFinder1 {
    private List<Integer> data;
    public MedianFinder1() {
        this.data = new ArrayList<>();
    }
    public void addNum (int num) {
        data.add(num);
    }
    //返回目前元素中的中位数
    //需要看这个返回值是double类型的
    public double findMedian() {
        Collections.sort(data);
        int n = data.size();
        if (n % 2 == 1) {
            return data.get(n / 2);
        } else {
            return (data.get((n -1) / 2) + data.get(n) / 2) * 0.5;
        }


    }
}
//2.插入排序
class MedianFinder2 {
    private List<Integer> data;
    public MedianFinder2 () {
        this.data = new ArrayList<>();
    }

    //将数据流添加一个整数到数据结构中
    public void addNum (int num) {
        if (data.isEmpty()) {
            data.add(num);
        } else {
            int n = data.size();
            data.add(Integer.MIN_VALUE);
            int j = n;
            for (; j > 0 ; j--) {
                if (num < data.get(j - 1)) {
                    data.set(j,data.get(j -1));
                } else {
                    break;
                }
            }
            data.set(j,num);
        }
    }

}

class MedianFinder3 {
    //小顶堆中最小的元素,都要比大顶堆中最大的元素大

    //大顶堆中存储较小的一半元素
    private PriorityQueue<Integer> maxHeap;
    //小顶堆用来储存较大的一半元素
    private PriorityQueue<Integer> minHeap;
    //要注意元素的个数,看是不是奇数,

    public MedianFinder3 (){
        maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        minHeap = new PriorityQueue<>();

    }

    //从数据流中添加一个整数到数据结构中
    //时间复杂度
    public void addNum (int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove());
        }

    }
    //返回目前所有元素的中位数
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }

}
