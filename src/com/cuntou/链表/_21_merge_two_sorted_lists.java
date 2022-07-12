package com.cuntou.链表;

/**
 * @ClassName : _21_merge_two_sorted_lists  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  11:03
 */

//链表解决问题的关键就是使用dummyNode
//不需要创建一个额外的空间直接使用dummyNode就可以使用了，dummyNode
public class _21_merge_two_sorted_lists {

    //迭代解法
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;

        return dummyNode.next;
    }

    //递归解答
    public ListNode mergeTwoList2(ListNode l1,ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoList2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoList2(l1,l2.next);
            return l2;
        }
    }
}
