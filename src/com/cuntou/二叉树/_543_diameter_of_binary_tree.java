package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _543_diameter_of_binary_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/14  21:43
 */

public class _543_diameter_of_binary_tree {
    /* 543. 二叉树的直径
        给定一棵二叉树，你需要计算它的直径长度。
        一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
        这条路径可能穿过也可能不穿过根结点。

        输入：
              1
             / \
            2   3
           / \
          4   5

         输出：3

         注意：两结点之间的路径长度是以它们之间边的数目表示。

              1
             / \
            2   3
           / \
          4   5
         /     \
        9       7
       /         \
      6           8
     */
    //找出左右两边的最大深度，然就加起来再加1就好了，用后序遍历
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
    // 左右中，后序遍历
    // 找出以root为节点的最大的深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        ans = Math.max(ans,maxLeftDepth + maxRightDepth);

        //处理根节点
        //处理根节点的返回值
        return Math.max(maxLeftDepth,maxRightDepth) + 1;
    }
}
