package com.cuntou.链表;

/**
 * @ClassName : _445_add_two_numbers_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  10:03
 */

public class _445_add_two_numbers_ii {
    /* 445. 两数相加 II
    给你两个 非空 链表来代表两个非负整数。
    数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
    将这两数相加会返回一个新的链表。

    你可以假设除了数字 0 之外，这两个数字都不会以零开头。

    进阶：

    如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     */
    //反转链表
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode retNode = addTwoNumbersHelp(l1,l2);

        return reverse(retNode);
    }

    public ListNode addTwoNumbersHelp(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y +carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) curr.next = new ListNode(carry);
        return dummy.next;
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
}
