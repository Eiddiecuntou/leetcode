package com.cuntou.链表;

/**
 * @ClassName : _24_swap_nodes_in_pairs  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/9  10:27
 */

public class _24_swap_nodes_in_pairs {
    /* 24. 两两交换链表中的节点
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    输入：head = 1->2->3->4->5->NULL
    输出：2->1->4->3->5->NULL
     */
    //需要进行真的交换这个链表
    //如果是定义的两个值
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            ListNode next = second.next;
            prev.next = second;
            second.next = first;
            first.next = next;

            prev = first;
            first = next;
            if (first == null) break;
            second = first.next;
        }
        return dummyNode.next;

    }
}
