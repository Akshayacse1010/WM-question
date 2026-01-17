class Solution {

    /**
     * Problem: Longest Substring Without Repeating Characters
     *
     * Approaches:
     *
     * 1. Brute Force:
     *    - Generate all substrings and check for duplicates using a hash.
     *    - Time Complexity: O(n^2)
     *    - Space Complexity: O(256)
     *
     * 2. Optimal (Used here):
     *    - Sliding window with last seen index of characters.
     *    - Expand window with j, shrink from i when duplicate is found.
     *    - Time Complexity: O(n)
     *    - Space Complexity: O(256)
     */
    public int lengthOfLongestSubstring(String s) {

        int maxlen = 0;   // Stores maximum length found
        int len = 0;      // Length of current window
        int i = 0;        // Left pointer of sliding window
        int j = 0;        // Right pointer of sliding window

        // Array to store last seen index of each character
        // Initialized to -1 (character not seen yet)
        int[] nums = new int[256];
        Arrays.fill(nums, -1);

        // Sliding window traversal
        while (j < s.length()) {

            char c = s.charAt(j);

            // If character was seen inside the current window,
            // move the left pointer to one position after its last occurrence
            if (nums[c] >= i) {
                i = nums[c] + 1;
            }

            // Update current window length
            len = j - i + 1;

            // Update maximum length if needed
            maxlen = Math.max(len, maxlen);

            // Update last seen index of current character
            nums[c] = j;

            // Move right pointer
            j++;
        }

        return maxlen;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(256) -> constant
