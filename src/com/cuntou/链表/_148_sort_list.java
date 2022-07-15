package com.cuntou.链表;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

/**
 * @ClassName : _148_sort_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  14:54
 */

public class _148_sort_list {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //找到中间结点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergeTwoList(left,right);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr =dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 == null) curr.next = l2;
        if(l2 == null) curr.next = l1;

        return dummyNode.next;
    }

}
