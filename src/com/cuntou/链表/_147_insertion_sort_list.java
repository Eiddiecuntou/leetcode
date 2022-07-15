package com.cuntou.链表;

/**
 * @ClassName : _147_insertion_sort_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  14:06
 */

public class _147_insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            } else {
                //找到小于curr.val 的最大节点
                ListNode p = dummyNode;
                while (p.next != null && p.next.val < curr.val) {
                    p = p.next;
                }
                //将curr插入到p和p.next中间
                prev.next = curr.next;
                curr.next = p.next;
                p.next = curr;

                curr = prev.next;
            }
        }
        return dummyNode.next;
    }
}
