import java.util.Stack;

public class MinStringAfterRemovingSubstrings {

    /**
     * Given a String s, return the length of the String after removing every occurrence of "AB" and "AC".
     * Example: "ABFCACDB" => 2
     * Explanation: "ABFCACDB" -> "FCACDB" -> "FCAB" -> "FC" which has length 2.
     * Solution: We use a Stack to find and remove every pair of ('A', 'B') and ('C', 'D'). When the Stack is empty,
     *           or we encounter any character but 'B' and 'D', we push it onto the Stack. If we see a 'B' or 'D'
     *           we check the top element of the Stack. If they form an aforementioned pair we remove the top element.
     *           In the end, the stack contains a character sequence without "AB" or "CD".
     * **/

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'B' && stack.peek() == 'A' || c == 'D' && stack.peek() == 'C')
                stack.pop();
            else
                stack.push(c);
        }
        return stack.size();
    }

}
