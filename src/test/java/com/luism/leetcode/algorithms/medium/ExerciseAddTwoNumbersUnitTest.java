package com.luism.leetcode.algorithms;

import com.luism.leetcode.algorithms.medium.ExerciseAddTwoNumbers;
import com.luism.leetcode.entity.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseAddTwoNumbersUnitTest {

    private static ListNode builder(int[] values) {

        return new ListNode(values[0], new ListNode(values[1], new ListNode(values[2], null)));
    }

    @Test
    void givenValidInputs_whenAddTwoNumbers_thenReturnSum() {

        // Given
        final ListNode listNode = builder(new int[]{2, 5, 5});
        final ListNode listNode2 = builder(new int[]{2, 5, 1});

        ExerciseAddTwoNumbers exerciseAddTwoNumbers = new ExerciseAddTwoNumbers();
        // When
        final ListNode result = exerciseAddTwoNumbers.addTwoNumbers(listNode, listNode2);

        // 552 + 152 = 704
        final ListNode expected = builder(new int[]{4, 0, 7});

        // Assert
        assertEquals(expected, result);

    }
}
