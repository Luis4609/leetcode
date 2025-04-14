package com.luism.leetcode.algorithms.easy;

import com.luism.leetcode.entity.ListNode;

public class MergeSortedList {

//    You are given the heads of two sorted linked lists list1 and list2.
//    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//    Return the head of the merged linked list.

//    Input: list1 = [1,2,4], list2 = [1,3,4]
//    Output: [1,1,2,3,4,4]

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        int minValue = 0;
        ListNode node = new ListNode();
        ListNode tail = new ListNode();

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
