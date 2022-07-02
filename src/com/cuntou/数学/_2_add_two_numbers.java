package com.cuntou.数学;

/**
 * @ClassName : _2_add_two_numbers
 * @Author : 村头 //作者
 * @Date: 2022/5/26
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
public class _2_add_two_numbers {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (L1 != null || L2 != null) {
            int x = L1 == null ? 0 : L1.val;
            int y = L2 == null ? 0 : L2.val;

            int total= x + y + carry;
            curr.next = new ListNode(total % 10);
            curr = curr.next;
            carry = total / 10;

            if (L1 != null) L1 = L1.next;
            if (L2 != null) L2 = L2.next;
        }
        if (carry != 0) curr.next = new ListNode(carry);
        return dummy.next;
    }

}
