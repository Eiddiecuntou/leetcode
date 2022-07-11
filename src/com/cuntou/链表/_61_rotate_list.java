package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _61_rotate_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/5  19:14
 */

public class _61_rotate_list {
    /* 61. 旋转链表
    给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

    输入：head = 1->2->3->4->5->NULL, k = 2
    输出：4->5->1->2->3->NULL

    提示：
    链表中节点的数目在范围 [0, 500] 内
    -100 <= Node.val <= 100
    0 <= k <= 2 * 10^9
     */
    //反转解法
    public ListNode rotateRight1 (ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        if (k % len == 0) return head;
        k = k % 10;

        ListNode newHead = reverse(head);
        ListNode kthNode = newHead;
        for (int i = 0; i < k - 1 ; i++) {
            kthNode = kthNode.next;
        }
        //找到K个节点
        ListNode nextHead = kthNode.next;
        kthNode.next = null;

        ListNode retHead = reverse(newHead);
        newHead.next = reverse(nextHead);

        return retHead;

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode rotateRight (ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        return head;
    }
}
