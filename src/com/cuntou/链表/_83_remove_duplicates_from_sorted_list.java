package com.cuntou.链表;

/**
 * @ClassName : _83_remove_duplicates_from_sorted_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  19:59
 */

public class _83_remove_duplicates_from_sorted_list {
    /*  83. 删除排序链表中的重复元素
    存在一个按升序排列的链表，给你这个链表的头节点 head ，
    请你删除所有重复的元素，使每个元素 只出现一次 。

    返回同样按升序排列的结果链表。

    输入：head = 1 -> 1 -> 2 -> 3 -> 3  -> null
    输出：1 -> 2 -> 3 -> null

    提示：
    链表中节点数目在范围 [0, 300] 内
    -100 <= Node.val <= 100
    题目数据保证链表已经按升序排列
     */
    //curr 和 prev head 之间的值 设置为空
    //删除重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr.next;
                curr.next = null;
            } else {
                prev = curr;
            }
            curr = prev.next;
        }
        return head;
    }
}
