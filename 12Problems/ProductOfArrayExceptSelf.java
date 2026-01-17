class Solution {

    // Idea:
    // For each index i, the result is:
    // (product of all elements to the left of i)
    // ×
    // (product of all elements to the right of i)
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        // Base case:
        // There are no elements to the left of index 0
        left[0] = 1;

        // There are no elements to the right of the last index
        right[nums.length - 1] = 1;

        int curr = 1;

        // Build left product array
        // left[i] = product of all elements before index i
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * curr;
            curr = left[i];
        }

        curr = 1;

        // Build right product array
        // right[i] = product of all elements after index i
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * curr;
            curr = right[i];
        }

        // Final result:
        // Multiply left and right products for each index
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) (left + right arrays)
