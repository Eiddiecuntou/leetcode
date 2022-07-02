package com.cuntou.bs;

/**
 * @ClassName : _1539_kth_missing_positive_number  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/16  20:01
 */

public class _1539_kth_missing_positive_number {
    //O(n + k)
    public int findKthPositive(int[] arr, int k) {
        int currNum = 1;
        int missCnt = 0;
        int lastMissNum = -1;

        int i = 0;
        while (missCnt < k) {
            if (currNum == arr[i]) {
                if (i < arr.length)  i++;
            } else {
                missCnt++;
                lastMissNum = currNum;
            }
            currNum++;
        }
        return lastMissNum;
    }

}
