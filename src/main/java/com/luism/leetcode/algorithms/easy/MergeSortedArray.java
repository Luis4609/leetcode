package com.luism.leetcode.algorithms.easy;

/**
 * Link to LeetCode:
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1; // Puntero al último índice de nums1 (donde se colocará el elemento fusionado)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to the beginning of nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public int[] clearArray(int[] nums, int n) {
        if (nums.length == n) {
            return nums;
        }
        int[] arrayWithOutZeros = new int[n];
        System.arraycopy(nums, 0, arrayWithOutZeros, 0, n);
        return arrayWithOutZeros;
    }

}
