/**
 * Problem: 3Sum
 *
 * Approaches:
 *
 * 1. Brute Force:
 *    - Use three nested loops to find all triplets.
 *    - Store results in a Set to avoid duplicates.
 *    - Time Complexity: O(n^3)
 *    - Space Complexity: O(size of triplets)
 *
 * 2. Better (Hashing-based):
 *    - Fix one element and use a HashMap/HashSet for the remaining two-sum.
 *    - Time Complexity: O(n^2)
 *    - Space Complexity: O(n) for the hash set
 *
 * 3. Optimal (Used here):
 *    - Sort the array and use two pointers.
 *    - Fix one element and move two pointers to find the remaining pair.
 *    - Time Complexity: O(n log n) for sort + O(n^2) traversal
 *    - Space Complexity: O(1) auxiliary space (ignoring output list)
 */
class Solution {

    public List<List<Integer>> threeSum(int[] arr) {

        // Sort the array to enable two-pointer technique
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        // Fix the first element one by one
        for (int i = 0; i < arr.length - 2; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;              // Left pointer
            int k = arr.length - 1;     // Right pointer

            // Use two pointers to find pairs that sum with arr[i] to zero
            while (j < k) {

                int csum = arr[i] + arr[j] + arr[k];

                if (csum < 0) {
                    // Sum is too small → move left pointer right
                    j++;
                } else if (csum > 0) {
                    // Sum is too large → move right pointer left
                    k--;
                } else {
                    // Found a valid triplet
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));

                    // Move both pointers to look for next potential triplet
                    j++;
                    k--;

                    // Skip duplicate values for second element
                    while (j < k && arr[j] == arr[j - 1]) j++;

                    // Skip duplicate values for third element
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}

// Time Complexity: O(n^2) after sorting
// Space Complexity: O(1) auxiliary space (output list not counted)
