package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _100_same_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/16  11:30
 */

public class _100_same_tree {

    //判断两棵树是否相同的
    //根节点,都子节点,
    //大问题.小问题
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
