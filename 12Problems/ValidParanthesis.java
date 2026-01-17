class Solution {

    // Idea:
    // Use a stack (LIFO) to track opening brackets.
    // Every closing bracket must match the most recent opening bracket.
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        // Invariant:
        // Stack always contains unmatched opening brackets in correct order.
        // The top of the stack is the most recent opening bracket.
        for (int i = 0; i < s.length(); i++) {

            char letter = s.charAt(i);

            // If opening bracket, push it to stack
            if (letter == '(' || letter == '[' || letter == '{') {
                stack.push(letter);
            } else {

                // If we encounter a closing bracket but stack is empty,
                // there is no matching opening bracket → invalid
                if (stack.isEmpty()) return false;

                // Pop the most recent opening bracket
                // and check if it matches the current closing bracket
                char stackLetter = stack.pop();

                if (stackLetter == '(' && letter != ')') return false;
                if (stackLetter == '{' && letter != '}') return false;
                if (stackLetter == '[' && letter != ']') return false;
            }
        }

        // If stack is empty, all opening brackets were matched correctly
        return stack.isEmpty();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) in worst case (all opening brackets)
