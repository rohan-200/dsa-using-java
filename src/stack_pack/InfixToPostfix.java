package stack_pack;

import java.util.Stack;

import stack_pack.MyStack.StackOverflowException;
import stack_pack.MyStack.StackUnderflowException;

public class InfixToPostfix {
        public static String convertToPostfix(String infixExpression) throws StackUnderflowException, StackOverflowException {
            String[] tokens = infixExpression.split(" ");
        MyStack<String> operatorStack = new MyStack<>(tokens.length);
        StringBuilder postfixExpressionBuilder = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String currentChar = tokens[i];

            if (tokens[i].matches("-?\\d+")) {
                // If the character is a digit, append it to the postfix expression
                postfixExpressionBuilder.append(tokens[i]);
                postfixExpressionBuilder.append(" ");
                continue;
            }

            switch (currentChar) {
                case "+":
                case "-":
                case "*":
                case "/":
                    // If the character is an operator, pop operators with higher or equal precedence from the stack
                    while (!operatorStack.isEmpty() && hasHigherOrEqualPrecedence(operatorStack.peek(), currentChar)) {
                        postfixExpressionBuilder.append(operatorStack.pop());
                        postfixExpressionBuilder.append(" ");
                    }
                    operatorStack.push(currentChar);
                    break;
                case "(":
                    // If the character is a left parenthesis, push it to the stack
                    operatorStack.push(currentChar);
                    break;
                case ")":
                    // If the character is a right parenthesis, pop operators from the stack until the matching left parenthesis is found
                    while (!operatorStack.isEmpty() && operatorStack.peek() != "(") {
                        postfixExpressionBuilder.append(operatorStack.pop());
                        postfixExpressionBuilder.append(" ");
                    }
                    operatorStack.pop(); // Pop the left parenthesis from the stack
                    break;
            }
        }

        // Pop any remaining operators from the stack and append them to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfixExpressionBuilder.append(operatorStack.pop());
            postfixExpressionBuilder.append(" ");
        }

        return postfixExpressionBuilder.toString();
    }

    private static boolean hasHigherOrEqualPrecedence(String operator1, String operator2) {
        int operator1Precedence = getOperatorPrecedence(operator1);
        int operator2Precedence = getOperatorPrecedence(operator2);
        return operator1Precedence >= operator2Precedence;
    }

    private static int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 3;
        }
    }
}

