package stack_pack;

import java.util.Stack;

import stack_pack.MyStack.StackOverflowException;
import stack_pack.MyStack.StackUnderflowException;

public class PrefixEvaluator {

    public static int evaluate(String expression) throws IllegalArgumentException, StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>(expression.length());

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                // Character is a digit
                int num = Character.getNumericValue(c);
                int j = i - 1;
                while (j >= 0 && Character.isDigit(expression.charAt(j))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(j));
                    j--;
                }
                i = j + 1;
                stack.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Character is an operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands");
                }

                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            } else if (c == ' ') {
                // Ignore whitespace
            } else {
                // Character is not a digit, operator, or whitespace
                throw new IllegalArgumentException("Invalid expression: invalid character " + c);
            }
        }

        System.out.println(stack.size());
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }


        return stack.pop();
    }
}

