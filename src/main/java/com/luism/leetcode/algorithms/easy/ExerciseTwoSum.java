package com.luism.leetcode.algorithms.easy;

import java.util.Arrays;

/**
 * LeetCode problem 1: Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */
public class ExerciseTwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * @param nums array of integers
     * @param target sum target
     * @return array of 2 integers that the sum is equal to the target
     */
    public static int[] twoSum(int[] nums, int target) {

        if (!isValidArrayLength(nums.length)) {
            return new int[0];
        }

        if (!Arrays.stream(nums).allMatch(ExerciseTwoSum::isValidValue) && isValidValue(target)) {
            return new int[0];
        }

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j < nums.length; j++) {
                if((i != j) && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    private static boolean isValidArrayLength(final int length) {

        return length >= 2 && length <= Math.pow(10, 4);
    }

    private static boolean isValidValue(final int num) {

        return num <= Math.pow(10, 9) && num >= -Math.pow(10, 9);
    }
}
