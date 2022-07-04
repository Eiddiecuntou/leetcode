package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _206_reverse_linked_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/4  15:13
 */

public class _206_reverse_linked_list {
    //反转链表
    //迭代
    public ListNode reverseList (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while ( curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //递归条件
    //一个链表的话可以分成两个子问题
    //1.拆解成两个子问题，头结点和其他的问题
    //2.子问题的求解方式是一样的
    //先低的过程分解 再归的过程
    public ListNode reverseList1(ListNode head) {
        //1.递归终止条件
        if (head == null || head.next == null) return head;


        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
     }

}
