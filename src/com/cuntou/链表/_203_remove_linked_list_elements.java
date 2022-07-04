package com.cuntou.链表;


import com.sun.deploy.net.proxy.ProxyUtils;
import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

/**
 * @ClassName : _203_remove_linked_list_elements  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  17:53
 */

public class _203_remove_linked_list_elements {
    //移除链表的元素，删除表头的元素
    public ListNode removeElements1 (ListNode head, int val) {
        //1.删除表头元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) return null;
        //2.删除非头结点的元素
        //curr =head.next;
        //prev = head;
        //cur
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
            } else {
                prev = curr;
            }
            curr = prev.next;
        }
        return head;
    }
    //使用虚拟节点统一删除头结点和非头结点的逻辑
    public ListNode removeElements (ListNode head, int val) {
        //使用一个虚拟节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curr = head;
        ListNode prev = dummyNode;
        while (curr != null) {
            if (curr.val == val) {
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
