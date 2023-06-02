package stack_pack;

import stack_pack.MyStack.StackOverflowException;
import stack_pack.MyStack.StackUnderflowException;

public class InfixToPrefix {
    public static String convertToPrefix(String infixExpression) throws StackUnderflowException, StackOverflowException {
        if (infixExpression == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = infixExpression.length() - 1; i >= 0; i--) {
            sb.append(infixExpression.charAt(i));
        }
        String postfixExpression = InfixToPostfix.convertToPostfix(String.valueOf(sb));
        StringBuilder sb1 = new StringBuilder();
        for (int i = postfixExpression.length() - 1; i >= 0; i--) {
            sb1.append(postfixExpression.charAt(i));
        }
        return sb1.toString();
    }
}
