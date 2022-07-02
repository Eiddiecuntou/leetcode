package com.cuntou.bs;

/**
 * @ClassName : _240_search_a_2d_matrix_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/15  21:14
 */

public class _240_search_a_2d_matrix_ii {
    //二分查找 每一行和每一列都在进行换算
    //运用多少次的二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int shortDim = Math.min(m, n);
        for (int i = 0; i < shortDim; i++) {
            boolean rowFound = binarySearchRow(matrix, i, target);
            boolean colFount = binarySearchCol(matrix, i, target);

            if (rowFound || colFount) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchRow(int[][] matrix,
                                    int row, int target) {
        int lo = row;
        int hi = matrix[0].length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    private boolean binarySearchCol(int[][] matrix,
                                    int col, int target) {
        int le = col;
        int hi = matrix.length - 1;

        while (le <= hi) {
            int mid = le + (hi - le) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] < target) {
                le = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }



}
