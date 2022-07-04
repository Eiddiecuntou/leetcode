package com.cuntou.链表;

/**
 * @ClassName : _237_delete_node_in_a_linked_list  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/3  19:45
 */

public class _237_delete_node_in_a_linked_list {
    /* 237. 删除链表中的节点

        请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
        传入函数的唯一参数为 要被删除的节点 。

        输入：4 -> 5 -> 1 -> 9 -> null
            node = 5
        输出：4 -> 1 -> 9 -> null

        提示：
            链表至少包含两个节点。
            链表中所有节点的值都是唯一的。
            给定的节点为非末尾节点并且一定是链表中的一个有效节点。
            不要从你的函数中返回任何结果。
     */
    //找不到前一个节点
    //使用下一个节点的值覆盖一下

    public void deleteNode1 (ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next != null) {
                node.val = next.val;
            } else {
                prev.next = null;
            }
            prev = node;
            node = node.next;
        }
    }
}
