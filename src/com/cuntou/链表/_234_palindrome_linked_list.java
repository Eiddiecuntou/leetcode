package com.cuntou.链表;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.List;

/**
 * @ClassName : _234_palindrome_linked_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/11  20:32
 */

public class _234_palindrome_linked_list {
    /* 234. 回文链表

    请判断一个链表是否为回文链表。

    输入: 1->2->2->1
    输出: true

    输入: 1->2->3->2->1
    输出: true

    进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    //找到中间结点，之后开始使用了对撞指针，就是为了这个，是不是一个回文
    //想一下在数组之中使用的就是对撞指针来做，但是链表的话方向是固定的，所以考虑的就是断开中间的
    //变成两个链表来进行搞，一起遍历值
    //我想的是转换之后，看看是不是一样
    public boolean isPalindrome (ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        ListNode left = head;
        ListNode right = reverse(newHead);

        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
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
