package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _82_remove_duplicates_from_sorted_list_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  20:42
 */

public class _82_remove_duplicates_from_sorted_list_ii {
    /* 82. 删除排序链表中的重复元素 II
    存在一个按升序排列的链表，给你这个链表的头节点 head ，
    请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

    返回同样按升序排列的结果链表

    输入：head = 1->2->3->3->4->4->5
    输出：1->2->5

    提示：
    链表中节点数目在范围 [0, 300] 内
    -100 <= Node.val <= 100
    题目数据保证链表已经按升序排列
     */
    public ListNode deleteDuplicates(ListNode head) {
        //头结点处理是不一样的
        // do while 循环和 while循环的区别主要是，do最少要执行一次，while不是
        //while先判断后执行，do while 先执行后判断


        if (head == null || head.next == null) return head;

        //虚拟节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                do {
                    curr = curr.next;
                } while (curr.next != null && curr.val == curr.next.val);
                prev.next = curr.next;
                curr.next = null;

            } else {
                prev = curr;
            }
            curr = prev.next;

        }
        return dummyNode.next;
    }
}
