class Solution {

    // Idea:
    // Count the frequency of each character first,
    // then find the first character with frequency 1.
    public int firstUniqChar(String s) {

        // Frequency array for lowercase English letters (a–z)
        // Java initializes array values to 0 by default
        int[] hash = new int[26];

        // First pass:
        // Count occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 97]++;
        }

        // Second pass:
        // Find the first character whose frequency is exactly 1
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 97] == 1) {
                return i;
            }
        }

        // If no unique character exists, return -1
        return -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1) (constant space of size 26)
