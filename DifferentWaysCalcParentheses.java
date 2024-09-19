import java.util.ArrayList;
import java.util.List;

public class DifferentWaysCalcParentheses {

    /**
     * For a given expression consisting of numbers from [0, 99] and operators +/-/*, return a list of all possible
     * results if brackets could be placed.
     * Example: expression = "2 - 1 - 1" => (0, 2)
     * Explanation: ((2 - 1) - 1) = 0
     *              (2 - (1 - 1)) = 2
     * Solution: We can recursively split the expression at each operator and pass the left and right substrings
     *           as parameter. Eventually, we'll end up in the base case of the expression consisting of
     *           a single number. We collect the results of each half in lists and iterate over them to
     *           evaluate the (sub)expression.
     * **/

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        if (expression.length() == 0) return results;

        if (expression.length() == 1 || expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);
            if (Character.isDigit(curChar)) continue;

            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

            for (int leftVal : left) {
                for (int rightVal : right) {
                    switch (curChar) {
                        case '+' -> results.add(leftVal + rightVal);
                        case '-' -> results.add(leftVal - rightVal);
                        case '*' -> results.add(leftVal * rightVal);
                    }
                }
            }
        }
        return results;
    }
}
