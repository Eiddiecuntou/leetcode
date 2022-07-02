package com.cuntou.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName : _85_maximal_rectangle  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:40
 */

public class _85_maximal_rectangle {
    //最大的矩形
    //找出只包含1的最大矩形
    //对于每个元素只看左边和上边
    //计算左边的1的个数
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        //找出类似于前缀表的东西，就是左边1的个数
        int[][] left = new int[m][n];
        for (int row = 0; row < m ; row++) {
            for (int col = 0; col < n ; col++) {
                if (matrix[row][col] == '1') {
                    left[row][col] = (col == 0 ? 0 : left[row][col - 1]) + 1;
                }
            }
        }
        //将问题转换成每一列的最大矩形来做，找上边界和下边界
        int ans = 0;
        for (int col = 0; col < n ; col++) {
            int[] up = new int[m];
            int[] down = new int[m];
            //右边界,防止右边没有比这个数小的,所以使用这个m,来进行填充
            Arrays.fill(down,m);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int row = 0; row < m ; row++) {
                while (!stack.isEmpty() && left[row][col] <= left[stack.peek()][col]) {
                    down[stack.peek()] = row;
                    stack.pop();
                }
                up[row] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(row);
            }

            for (int row = 0; row < m; row++) {
                int height = left[row][col];
                int width = down[row] - up[row] -1;
                ans = Math.max(ans,height * width);

            }


        }
        return ans;


    }

}
