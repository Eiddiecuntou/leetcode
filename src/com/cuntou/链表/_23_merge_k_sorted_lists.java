package com.cuntou.链表;

import java.util.List;

/**
 * @ClassName : _23_merge_k_sorted_lists  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/12  11:39
 */

public class _23_merge_k_sorted_lists {

    //顺序思想
    //挨个进行合并
    public ListNode mergeList1(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode outputList = lists[0];
        for (int i = 1; i < lists.length ; i++) {
            outputList = mergeTwoLists(outputList,lists[i]);

        }
        return outputList;
    }

    //使用分治的思想
    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        //只有一个链表，返回这个链表就可以了
        if (left == right) return lists[left];
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        ListNode mergedLeftList = merge(lists, left, mid);
        ListNode mergedRightList = merge(lists,mid + 1, right);

        return mergeTwoLists(mergedLeftList,mergedRightList);
    }

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
}
