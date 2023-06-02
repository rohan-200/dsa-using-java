package stack_pack;

import java.util.Stack;

import stack_pack.MyStack.StackOverflowException;
import stack_pack.MyStack.StackUnderflowException;

public class PostfixEvaluator {

    public static int evaluate(String expression) throws IllegalArgumentException, StackOverflowException, StackUnderflowException {
        String[] tokens = expression.split(" ");
        MyStack<Integer> stack = new MyStack<>(tokens.length);
        // Stack<Integer> stack = new Stack<>();

        System.out.println(stack.size());
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                // Token is a number
                int num = Integer.parseInt(token);
                stack.push(num);
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Token is an operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands");
                }

                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            } else {
                // Token is not a number or operator
                throw new IllegalArgumentException("Invalid expression: invalid token " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }

        return stack.pop();
    }
}

