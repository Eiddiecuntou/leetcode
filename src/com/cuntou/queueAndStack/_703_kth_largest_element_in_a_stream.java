package com.cuntou.queueAndStack;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @ClassName : _703_kth_largest_element_in_a_stream  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/29  19:01
 */

public class _703_kth_largest_element_in_a_stream {
      /*  leetcode 703 号算法题：数据流中的第 K 大元素
    设计一个找到数据流中第 k 大元素的类（class）。
    注意是排序后的第 k 大元素，不是第 k 个不同的元素。

    请实现 KthLargest 类：
        1. KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
        2. int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

    输入：
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   输出：
        [null, 4, 5, 5, 8, 8]

   解释：
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

    1 <= k <= 10^4
    0 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    -10^4 <= val <= 10^4
    最多调用 add 方法 10^4 次
    题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
     */
    class KthLargest {
        //我们并不知道最终的数组是多大,使用一个动态数组
          private List<Integer> data;
          private int k;

          //O(n)
          public KthLargest (int k, int[] nums) {
              this.data = new ArrayList<>();
              this.k = k;
              for (int num : nums) data.add(num);
          }

          //sort O(nlogn)
          public int add(int val) {
              data.add(val);
              Collections.sort(data);
              return data.get(data.size() - k);
          }

      }
      class KthLargest1 {
        private List<Integer> data;
        private int k;

        //时间复杂度
        public KthLargest1 (int k, int[] nums) {
            this.data = new ArrayList<>();
            this.k = k;
            for (int num : nums) {
                data.add(num);
            }
            Collections.sort(data);
        }

        public int add(int val) {
            if (data.isEmpty()) {
                data.add(val);
            } else {
                //插入排序
                int n = data.size();
                data.add(Integer.MIN_VALUE);
                int j = n;
                for (; j > 0 ; j--) {
                    if(val < data.get(j - 1)) {
                        data.set(j,data.get(j - 1));
                    } else {
                        break;
                    }
                }
                data.set(j,val);

            }
            return data.get(data.size() - k);
        }
      }

      //使用小顶栈
      class KthLargest2{
        private PriorityQueue<Integer> data;
        private int k;

        //时间复杂度
        public KthLargest2(int k, int[] nums) {
            this.data = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                data.add(num);
            }
        }

        public int add(int val) {
            if (data.size() < k) {
                data.add(val);
            } else if (val > data.peek()) {
                data.remove();
                data.add(val);
            }
            return data.peek();
        }




      }
}
