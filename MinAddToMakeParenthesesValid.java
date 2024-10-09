import java.util.Stack;

public class MinAddToMakeParenthesesValid {

    /**
     * Given a String consisting of '(' and ')', return the minimum number of brackets you need to add to make the
     * parentheses valid. A valid parentheses String is an empty String, AB where A and B are valid or (A) where
     * A is valid.
     * Example: s = "()))((" => 4
     * Explanation: Turning s into ((()))(()) would make it valid.
     * Solution: Since we are only allowed to add parentheses, we simply need to iterate over s and subtract all the
     *           valid ones. This can be done using a Stack or a counter as the content of the Stack will only
     *           ever be opening parentheses.
     *           For every '(', we increment the counter 'open'. If '(' is followed by a ')' we can decrement it. In
     *           the end, 'open' contains the number of opening parentheses without a closing one,
     *           and 'close' vice versa.
     * **/

    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')' && open > 0) {
                open--;
            } else {
                close++;
            }
        }
        return open + close;
    }
}
