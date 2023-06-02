package stack_pack;

public class DriverForStackPack {
    public static void main(String[] args) throws MyStack.StackUnderflowException, MyStack.StackOverflowException {
        /**
         * question 2 driver
         */
        // String expression1 = "((11 + 2) * 3) - 4"; // valid expression
        // String expression1 = "(])"; // valid expression
        // String expression2 = "((1 + 2) * 3 - 4"; // invalid expression

        // if (ExpressionChecker.isValidExpression(expression1)) {
        // System.out.println(expression1 + " is a valid expression.");
        // } else {
        // System.out.println(expression1 + " is an invalid expression.");
        // }

        // if (ExpressionChecker.isValidExpression(expression2)) {
        // System.out.println(expression2 + " is a valid expression.");
        // } else {
        // System.out.println(expression2 + " is an invalid expression.");
        // }

        /**
         * question 3 driver
         */
        // String expression3 = "2 3 + 4 *";
        // String expression4 = "5 6 2 + * 12 /";
        // int result1 = stack_pack.PostfixEvaluator.evaluate(expression3);
        // System.out.println(expression3 + " = " + result1);

        // int result2 = stack_pack.PostfixEvaluator.evaluate(expression4);
        // System.out.println(expression4 + " = " + result2);
        /**
         * question 4 driver
         *
         */

        // String expression5 = "* + 2 3 4";
        // String expression6 = "/ * + 5 6 2 12";
        // int nresult1 = PrefixEvaluator.evaluate(expression5);
        // System.out.println(expression5 + " = " + nresult1);

        // int nresult2 = PrefixEvaluator.evaluate(expression6);
        // System.out.println(expression6 + " = " + nresult2);

        String infixExpression = "25 + ( 3 * 4 ) - 5";
        /*question 5 driver */
        String postfixExpression = InfixToPostfix.convertToPostfix(infixExpression);
        System.out.println(postfixExpression); 
        /*question  6 driver*/
        // String prefixExpression = InfixToPrefix.convertToPrefix(infixExpression);
        // System.out.println(prefixExpression); 

    }
}
