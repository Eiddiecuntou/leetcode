package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _92_reverse_linked_list_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/4  15:57
 */

public class _92_reverse_linked_list_ii {
    /* 92. 反转链表 II
    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

    输入：head = 1->2->3->4->5, left = 2, right = 4
    输出： 1->4->3->2->5

    提示：
        链表中节点数目为 n
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n

    进阶： 你可以使用一趟扫描完成反转吗？
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        //因为头结点也有可能变化，为了统一逻辑，这里设置虚拟节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //1.从虚拟节点走left - 1步，来到left节点的前一个节点
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1 ; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;

        //2.从leftNode 节点开始走right - left 步，来到right节点
        ListNode rightNode = leftNode;
        for (int i = 0; i < right - left ; i++) {
            rightNode = rightNode.next;
        }
        ListNode postRight = rightNode.next;

        //来切断
        prev.next = null;
        rightNode.next = null;

        //反转leftNode的rightNode
        reverseList(leftNode);

        prev.next = rightNode;
        leftNode.next = postRight;

        return dummyNode.next;

    }

    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (head != null ) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }


}
