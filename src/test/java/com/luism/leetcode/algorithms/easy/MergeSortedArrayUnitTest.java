package com.luism.leetcode.algorithms.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class MergeSortedArrayUnitTest {

    private MergeSortedArray merger = new MergeSortedArray();

    @Test
    void givenTwoNonEmptySortedArrays_whenMerged_thenResultIsSortedMergedArray() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 2, 3, 5, 6};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums1IsEmpty_whenMergedWithNonEmptyNums2_thenResultIsNums2() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums2IsEmpty_whenMergedWithNonEmptyNums1_thenResultIsNums1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {};
        int n = 0;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 3, 0, 0, 0};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenOneElementInNums1AndOneInNums2_whenMerged_thenResultIsSortedTwoElements() {
        int[] nums1 = {1, 0};
        int m = 1;
        int[] nums2 = {2};
        int n = 1;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenArraysWithDuplicateElements_whenMerged_thenResultContainsAllDuplicatesSorted() {
        int[] nums1 = {1, 2, 2, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3};
        int n = 2;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 2, 2, 3};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums1LongerThanNums2_whenMerged_thenResultIsSortedMergedArray() {
        int[] nums1 = {1, 3, 5, 0, 0};
        int m = 3;
        int[] nums2 = {2, 4};
        int n = 2;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums2LongerThanNums1_whenMerged_thenResultIsSortedMergedArray() {
        int[] nums1 = {1, 2, 0, 0, 0};
        int m = 2;
        int[] nums2 = {3, 4, 5};
        int n = 3;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums1ContainsOnlyZerosAndMIsZero_whenMergedWithNonEmptyNums2_thenResultIsNums2() {
        int[] nums1 = {0, 0, 0};
        int m = 0;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenNums2ContainsZeros_whenMergedWithNonEmptyNums1_thenResultIsSortedMergedArrayIncludingZeros() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {0, 0};
        int n = 2;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {0, 0, 1, 2, 3};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void givenBothArraysAreEmpty_whenMerged_thenResultIsAnEmptyArrayOrOriginalNums1WithZero() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {};
        int n = 0;
        merger.merge(nums1, m, nums2, n);
        int[] expected = {0};
        assertArrayEquals(expected, nums1);
    }

    // Pruebas para clearArray siguiendo la convención given_when_then
    @Test
    void givenArrayAndSameLength_whenCleared_thenResultIsSameArray() {
        int[] nums = {1, 2, 3, 0, 0};
        int m = 3;
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, merger.clearArray(Arrays.copyOf(nums, nums.length), m));
    }

    @Test
    void givenArrayAndShorterLength_whenCleared_thenResultIsSubArray() {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, merger.clearArray(Arrays.copyOf(nums, nums.length), m));
    }

    @Test
    void givenArrayAndZeroLength_whenCleared_thenResultIsEmptyArray() {
        int[] nums = {0, 0, 0};
        int m = 0;
        int[] expected = {};
        assertArrayEquals(expected, merger.clearArray(Arrays.copyOf(nums, nums.length), m));
    }
}