package com.luism.leetcode.algorithms.medium;

import com.luism.leetcode.entity.ListNode;

/**
 * LeetCode Problem 2: Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class ExerciseAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.getVal() : 0;
            int val2 = (l2 != null) ? l2.getVal() : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.setNext(new ListNode(sum % 10));
            current = current.getNext();

            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }

        return dummyHead.getNext();
    }

}
