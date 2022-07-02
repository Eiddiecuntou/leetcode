package com.cuntou.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : TreeNode  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/23  22:32
 */

public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
        this.left = left;
        this.right = right;}

}


