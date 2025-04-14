package com.luism.leetcode.algorithms.easy;

import java.util.HashMap;
import java.util.Set;

/**
 * LeetCode Problem 27: Remove Element
 * Difficulty: Easy
 * https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int valAppearancesInNums = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                valAppearancesInNums++;
            }
        }

        return nums.length;
    }
}
