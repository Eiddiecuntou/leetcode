package com.cuntou.动态规划.打劫问题;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _337_house_robber_iii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/27  15:32
 */

public class _337_house_robber_iii {
    /* 337. 打家劫舍 III
    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
    这个地区只有一个入口，我们称之为“根”。
    除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
    一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
    如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

    示例 1:
    输入: [3,2,3,null,3,null,1]

         3
        / \
       2   3
        \   \
         3   1

    输出: 7
    解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

    示例 2:
    输入: [3,4,5,1,3,null,1]

         3
        / \
       4   5
      / \   \
     1   3   1

    输出: 9
    解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

     */
    //隔着偷，第一行能偷盗，第二行就不能偷了，
    // 所以我们要一个节点一个节点的去分析，如果不能偷这个只能偷儿子
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] res = new int[2];
        // 1. 选择不偷当前的节点，当前节点能偷到的最大钱数
        //          = 左孩子能偷到的最大钱 + 右孩子能偷到的最大钱
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 2. 选择偷当前的节点：当前节点能偷到的最大钱数
        //              = 左孩子选择自己不偷时能得到的最大钱 +
        //                  右孩子选择不偷时能得到的最大钱 + 当前节点的钱数
        res[1] = left[0] + right[0] + node.val;
        return res;
    }
}

