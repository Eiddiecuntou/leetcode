package com.cuntou.链表;

/**
 * @ClassName : Node  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/11  21:13
 */

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node (int val) {
        this.val = val;
        this.next = null;
        this.random = null;

    }
}
