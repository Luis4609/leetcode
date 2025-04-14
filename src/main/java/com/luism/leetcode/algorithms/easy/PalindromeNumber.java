package com.luism.leetcode.algorithms.easy;

public class PalindromeNumber {

    private static boolean isValidInput(final int x) {

        return (-231 <= x) && (x <= 231 - 1);
    }

    /**
     * An integer is palindrome if reads the same from left to right than from right to left.
     *
     * @param x
     * @return return true if x is a palindrome, and false otherwise.
     */
    public boolean isPalindrome(final int x) {

        if (!isValidInput(x)) {
            return false;
        }

        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i = 0; i < n / 2; i++) {
            // We check whether the elements at the same distance from
            // beginning and from ending are same, if not we return false
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        // if no flaws are found we return true
        return true;
    }
}
