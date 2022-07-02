package com.cuntou.哈希查找;

import java.util.*;

/**
 * @ClassName : _1122_relative_sort_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/20  10:11
 */

public class _1122_relative_sort_array {
    /* leetcode 1122 号算法题：数组的相对排序
    给你两个数组，arr1 和 arr2，
        1. arr2 中的元素各不相同
        2. arr2 中的每个元素都出现在 arr1 中

    对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
    未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

    输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19,8], arr2 = [2,1,4,3,9,6]
    输出：[2,2,2,1,4,3,3,9,6,7,8,19]

    - 1 <= arr1.length, arr2.length <= 1000
    - 0 <= arr1[i], arr2[i] <= 1000
    - arr2 中的元素 arr2[i] 各不相同
    - arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     */
    //使用自定义排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 在java中只有转换成动态数组，才可以使用这个collection
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length ; i++) {
            map.put(arr2[i],i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr1) list.add(num);

        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (map.containsKey(x)) {
                    //按照索引来进行排序升序排列，否则的话，x 在第二个数组里面，y 不在第二个数组里面
                    //因为我想让x 在前面，所以返回负数就可以了
                    return map.containsKey(y) ? map.get(x) - map.get(y) : -1;
                } else {
                    // x和Y都不存在，按照 x- y 的升序排列
                    return map.containsKey(y) ? 1 : x - y;
                }
            }
        });
        for (int i = 0; i < arr1.length - 1; i++ ) arr1[i] = list.get(i);
        return arr1;

    }

    //记数排序
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num : arr1) count[num]++;

        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < count[num]; i++) {
                arr1[index++] = num;
            }
            // 清 0 的原因：
            // 在 arr1 中等于 num 的所有的元素都放在一起了
            // 也就是 num 排好序了，为了可以区分出已经排好序，和还没排序的元素
            // 我们将排好序的元素出现的次数清 0
            count[num] = 0;
            // 清 0 后，在下面的循环中就不用处理了，下面的循环只要处理在 arr2 中没出现的元素了
        }

        for (int num = 0; num < 1001; num++) {
            for (int i = 0; i < count[num]; i++) {
                arr1[index++] = num;
            }
        }

        return arr1;
    }
}
