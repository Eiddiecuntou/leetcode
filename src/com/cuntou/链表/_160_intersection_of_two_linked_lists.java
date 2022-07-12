package com.cuntou.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : _160_intersection_of_two_linked_lists  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/11  22:26
 */

public class _160_intersection_of_two_linked_lists {
    /* 160. 相交链表
        给你两个单链表的头节点 headA 和 headB ，
        请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

        题目数据 保证 整个链式结构中不存在环。

        注意，函数返回结果后，链表必须 保持其原始结构 。

        进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
    //使用的双指针的方法，只要a和b相等的时候就需要退出循环，两个指针把两个都走一遍
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ) return null;

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
