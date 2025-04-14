package com.luism.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Puntero al último elemento de nums1
        int j = n - 1; // Puntero al último elemento de nums2
        int k = m + n - 1; // Puntero al último índice de nums1 (donde se colocará el elemento fusionado)

        //mientras que ninguno de los arrays llegue a la posicion 0
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

        // Si quedan elementos en nums2, copiarlos al principio de nums1
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

    public boolean isAnagram(String s, String t) {

        String.
        if (s == t.)

        return false;
    }
}
