package com.cuntou.链表;

/**
 * @ClassName : _86_partition_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/11  22:09
 */

public class _86_partition_list {
    /* 86. 分隔链表
    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
    使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

    你应当 保留 两个分区中每个节点的初始相对位置。

    输入：head = 1->4->3->2->5->2->NULL, x = 3
    输出：1->2->2->4->3->5->NULL
     */
    //相对位置的话需要考虑一下
    //画图考虑一下，为什么直接可以使用这个next ，直接是用大的next就可以得出
    //主要还是考虑很多
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode LargeHead = new ListNode(-1);
        ListNode large = LargeHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = LargeHead.next;

        return smallHead.next;
    }
}
