package com.cuntou.贪心算法;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import javafx.application.Application;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

/**
 * @ClassName : _976_largest_perimeter_triangle  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  15:16
 */

public class _976_largest_perimeter_triangle {
    /* 976. 三角形的最大周长
    给定由一些正数（代表长度）组成的数组 A，
    返回由其中三个长度组成的、面积不为零的三角形的最大周长。

    如果不能形成任何面积不为零的三角形，返回 0。

    示例 1：
    输入：[2,1,2]
    输出：5

    示例 2：
    输入：[1,2,1]
    输出：0

    示例 3：
    输入：[3,2,3,4]
    输出：10

    示例 4：
    输入：[3,6,2,3]
    输出：8
     
    提示：
    3 <= A.length <= 10000
    1 <= A[i] <= 10^6
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length; i >= 0 ; i--) {
            if (nums[i -2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }


}
