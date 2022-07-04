package com.cuntou.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : _142_linked_list_cycle_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/4  14:38
 */

public class _142_linked_list_cycle_ii {
    /* 142. 环形链表 II
    给定一个链表，返回链表开始入环的第一个节点。
    如果链表无环，则返回 null。
     */
    //只要找到第一个存在两次的表就可以了
    public ListNode hasCycle (ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    //使用快慢指针来进行解决这个问题
    //slow指针走了：a + b
    //fast指针： a + (n + 1 )b + nc
    //转换之后可以考虑到这个a == b
    //fast 指针走的距离永远是这个slow走的距离的两倍
    public ListNode detectCycle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //定义一个P从head开始走的话，这样子就slow可能会跟这个p相遇，因为在只跑一圈的情况下，就可以了
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }


}
