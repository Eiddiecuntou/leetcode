package com.cuntou.链表;

/**
 * @ClassName : ListNode  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  18:14
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){};
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
