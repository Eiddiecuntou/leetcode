package com.cuntou.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/23  22:43
 */

public class tree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        PreOrder(t1);

    }

        /**
         * 前序遍历
         * @param root
         */
        public static void PreOrder(TreeNode root) {  //先序遍历
            if (root==null)
                return;

            System.out.print(root.val+" ");
            //使用递归进行遍历左孩子
            PreOrder(root.left);

            //递归遍历右孩子
            PreOrder(root.right);
        }
    }










