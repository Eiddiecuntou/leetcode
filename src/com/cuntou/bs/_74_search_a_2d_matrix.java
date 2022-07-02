package com.cuntou.bs;

/**
 * @ClassName : _74_search_a_2d_matrix  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  19:38
 */

public class _74_search_a_2d_matrix {
    //要么就进行暴力
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row =0; row < matrix.length;row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == target) return true;
            }
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        //是都可以转换为一维数组来进行解决
        //mid 对应的值 对应的索引 虚构的一维数组
        //N 指的是列数,使用的是一个公式 matrix[mid / n][mid % n]
        int m = matrix.length, n = matrix[0].length;
        int left = 0,right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) return true;
            else if (num < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;



    }


}
