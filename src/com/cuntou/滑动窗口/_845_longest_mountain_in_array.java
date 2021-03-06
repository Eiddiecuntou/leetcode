package com.cuntou.滑动窗口;

/**
 * @ClassName : _845_longest_mountain_in_array  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/1  16:40
 */

public class _845_longest_mountain_in_array {
     /* leetcode 845. 数组中的最长山脉
    我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

    B.length >= 3
    存在 0 < i < B.length - 1
    使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    （注意：B 可以是 A 的任意子数组，包括整个数组 A。）

    给出一个整数数组 A，返回最长 “山脉” 的长度。

    如果不含有 “山脉” 则返回 0。

    示例 1：
    输入：[2,1,4,7,3,2,5]
    输出：5
    解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。

    示例 2：
    输入：[2,2,2]
    输出：0
    解释：不含 “山脉”。
     
    提示：
    0 <= A.length <= 10000
    0 <= A[i] <= 10000

     */
    //山脉的先增先后下降的
    //把他转换成更多的这个
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            //找到最高点
            int right = left + 1;
            if(arr[left] < arr[right]) {
                //找到最高点
                while (right + 1 < n && arr[right] < arr[right + 1]) {
                    right++;
                }
                if (right + 1 < n && arr[right] > arr[right + 1]) {
                    //找到最低点
                    while (right + 1 < n && arr[right] > arr[right + 1] ) {
                        right++;
                    }
                } else {
                    //没有最低点就开始继续增加，说明没有，把所有的数组都遍历完。
                    right++;
                }

            }
            left = right;
        }
        return ans;
    }


}
