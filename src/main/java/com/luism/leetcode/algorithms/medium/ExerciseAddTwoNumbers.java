package com.luism.leetcode.algorithms;

import com.luism.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseAddTwoNumbers {

//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    List<Integer> integerList1 = new ArrayList<>();
    List<Integer> integerList2 = new ArrayList<>();

    ListNode finalValue;
    ListNode reverseSumListNode;

    public static int combinarDigitosStream(List<Integer> integers) {
        if (integers == null || integers.isEmpty()) {
            return 0;
        }
        final String integerAsString = integers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        try {
            return Integer.parseInt(integerAsString);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir la cadena a número: " + integerAsString);
            return 0;
        }
    }

    public static List<Integer> intToDigitList(int integer) {

        return String.valueOf(Math.abs(integer))
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    /**
     * @param l1
     * @param l2
     * @return ListNode that represent the reverse sum of l1 + l2
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.getNext() == null && l2.getNext() == null) {

            integerList1.add(l1.getVal());
            integerList2.add(l2.getVal());

            //TODO
            Collections.reverse(integerList1);
            Collections.reverse(integerList2);

            this.finalValue = buildListNote(integerList1, integerList2);

            return this.finalValue;
        }

        integerList1.add(l1.getVal());
        integerList2.add(l2.getVal());

        return addTwoNumbers(l1.getNext(), l2.getNext());
    }

    /**
     * @param integerList
     * @param integerList1
     * @return
     */
    private ListNode buildListNote(final List<Integer> integerList, final List<Integer> integerList1) {

        int i = combinarDigitosStream(integerList);
        int j = combinarDigitosStream(integerList1);

        int sum = i + j;

        List<Integer> sumList = intToDigitList(sum);

        ListNode node = new ListNode();

        //TODO
        sumList.forEach(integer -> {
            node.setVal(integer);
            node.setNext(new ListNode());
        });

        return node;
    }

    public ListNode buildListNote(final List<Integer> value) {

        List<Integer> list = value;

        this.reverseSumListNode.setVal(list.get(0));
        list.remove(0);
        this.reverseSumListNode.setNext(buildListNote(list));

        return null;
    }

}
