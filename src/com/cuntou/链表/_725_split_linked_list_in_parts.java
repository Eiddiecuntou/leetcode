package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _725_split_linked_list_in_parts  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/5  20:13
 */

public class _725_split_linked_list_in_parts {
/* 725. 分隔链表
        给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
    每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

    这 k 个部分应该按照在链表中出现的顺序进行输出，
    并且排在前面的部分的长度应该大于或等于后面的长度。

    返回一个符合上述规则的链表的列表。

    输入：root> = 1->2->3-4->5->6->7->8->9->10      k = 3
    输出：[
        1->2->3->4,
        5->6->7,
        8->9->10
    ]

    输入：root = 1->2->3         k = 5
    输出：[
        1,
        2,
        3,
        null,
        null
    ]

    提示：
    root 的长度范围： [0, 1000].
    输入的每个节点的大小范围：[0, 999].
    k 的取值范围： [1, 50].
     */
    public ListNode[] splitListToParts (ListNode root,int k) {
        int len = 0;
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;

        }
        int width = len / k;
        int remainder = len % k;

        ListNode[] res = new ListNode[k];
        curr = root;
        for (int i = 0; i < k ; i++) {
            ListNode dummyNode = new ListNode(-1);
            //找到一个节点来记住一些东西
            ListNode node = dummyNode;
            int realWidth = width + (i < remainder ? 1 : 0);
            for (int j = 0; j < realWidth ; j++) {
                node.next = new ListNode(curr.val);
                node = node.next;
                if (curr != null) curr = curr.next;
            }
            res[i] = dummyNode.next;
        }
        return res;

    }
}
