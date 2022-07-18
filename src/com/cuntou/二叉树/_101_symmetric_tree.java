package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _101_symmetric_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/16  11:39
 */

public class _101_symmetric_tree {
    //对称的二叉树
    //左子树和右子树是一样的
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root,root);
    }
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }
}
