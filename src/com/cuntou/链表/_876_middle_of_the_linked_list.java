package com.cuntou.链表;

import javax.swing.*;

/**
 * @ClassName : _876_middle_of_the_linked_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  21:57
 */

public class _876_middle_of_the_linked_list {
    //返回中间的这个结点
    //偶数返回中间的第二个结点
    //奇数返回中间的结点
     public ListNode middleNode (ListNode head) {
         if (head == null) return null;

         //1.计算链表的长度
         int length = 0;
         ListNode curr = head;
         while (curr != null) {
             length++;
             curr = curr.next;
         }
         //2.找到链表的中间结点
         for (int i = 0; i < length / 2 ; i++) {
             head = head.next;
         }

         return head;
     }
     //快慢指针
    public ListNode middleNode1 (ListNode head) {
         if (head == null ||head.next == null) return head;

         ListNode slow = head;
         ListNode fast = head;

         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }


}
