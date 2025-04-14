package com.luism.leetcode.algorithms.easy;

import com.luism.leetcode.entity.ListNode;

/**
 * LeetCode problem 21: Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 
 */
public class MergeSortedList {

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list. If both input lists are
     *         null,
     *         an empty ListNode is returned.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node = new ListNode();

        while (list1 != null && list2 != null) {

            if (list1.getVal() <= list2.getVal()) {
                node.setVal(list1.getVal());
                list1 = list1.getNext();
            } else {
                node.setVal(list2.getVal());
                list2 = list2.getNext();
            }

            return node;
        }

        return new ListNode();

    }

}