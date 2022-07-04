package com.cuntou.链表;

/**
 * @ClassName : _19_remove_nth_node_from_end_of_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/4  10:17
 */

public class _19_remove_nth_node_from_end_of_list {
    //删除结点找到前一个节点
    public ListNode removeNthFromEnd1(ListNode head,int i) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //1.计算链表长度
        int length = 0;
        ListNode curr = dummyNode;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        //2.找到倒数第n个节点的前一个节点，将他们的指针指向下一个标记的出来
        ListNode prev = dummyNode;
        for (int j = 0; j < length - i; j++) {
            prev = prev.next;
        }
        //3.删除倒数第n个节点
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        return dummyNode.next;

    }
}
