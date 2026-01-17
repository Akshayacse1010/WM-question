class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Final answer list
        List<List<Integer>> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return ans;

        // Deque to allow insertion/removal from both ends
        Deque<TreeNode> dq = new ArrayDeque<>();

        // Start with root in deque
        dq.offerFirst(root);

        // true  -> left to right
        // false -> right to left
        boolean flag = true;

        // BFS traversal
        while (!dq.isEmpty()) {

            int size = dq.size();              // number of nodes at current level
            List<Integer> temp = new ArrayList<>();

            // Process one level
            for (int i = 0; i < size; i++) {

                // Left to Right traversal
                if (flag) {
                    TreeNode node = dq.pollFirst();   // take from front
                    temp.add(node.val);

                    // Add children to back in normal order
                    if (node.left != null) dq.offerLast(node.left);
                    if (node.right != null) dq.offerLast(node.right);
                }

                // Right to Left traversal
                else {
                    TreeNode node = dq.pollLast();    // take from back
                    temp.add(node.val);

                    // Add children to front in reverse order
                    if (node.right != null) dq.offerFirst(node.right);
                    if (node.left != null) dq.offerFirst(node.left);
                }
            }

            // Add current level result
            ans.add(temp);

            // Toggle direction for next level
            flag = !flag;
        }

        return ans;
    }
}
