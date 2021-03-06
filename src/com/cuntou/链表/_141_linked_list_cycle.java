package com.cuntou.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : _141_linked_list_cycle  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/4  13:38
 */

public class _141_linked_list_cycle {
    /* 141. 环形链表
    给定一个链表，判断链表中是否有环。

    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。

    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。
    注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

    如果链表中存在环，则返回 true 。 否则，返回 false 。

    提示：
    链表中节点的数目范围是 [0, 10^4]
    -10^5 <= Node.val <= 10^5
    pos 为 -1 或者链表中的一个 有效索引 。

    进阶：
    你能用 O(1)（即，常量）内存解决此问题吗？
     */
    //主要去判断一个节点在这个表格里是否会存在，存在环的链表
    public boolean hasCycle(ListNode head) {
        Set<ListNode>  set = new HashSet<>();
        ListNode curr =head;
        while (curr != null) {
            if (set.contains(curr)) return true;
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    //主要就是空间复杂度的降低，快慢指针，看看谁快
    //当链表汇总不存在环的时候，快指针会比满指针更快的到达链表尾部，所以链表中的每个节点至多会被访问两次
    //当链表中存在环的时候，每一轮移动后，快慢指针的相差的距离会减少，所以他们最终会相遇
    public boolean hasCycles (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
