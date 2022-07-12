package com.cuntou.链表;

/**
 * @ClassName : _2_add_two_numbers  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  9:26
 */

public class _2_add_two_numbers {
    /* 2. 两数相加
    给你两个 非空 的链表，表示两个非负的整数。
    它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

    请你将两个数相加，并以相同形式返回一个表示和的链表。
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) curr.next =new ListNode(carry);
        return dummy.next;
    }
}
