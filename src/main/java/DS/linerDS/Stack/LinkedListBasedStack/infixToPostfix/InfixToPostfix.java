package DS.linerDS.Stack.LinkedListBasedStack.infixToPostfix;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            // If the character is an operand, append it to the postfix expression
            if (Character.isLetterOrDigit(c)) {
                postfixExpression.append(c);
            }
            // If the character is an opening parenthesis, push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is a closing parenthesis, pop elements from the stack and append them to the postfix expression
            // until an opening parenthesis is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
                }
                // Remove the opening parenthesis from the stack
                stack.pop();
            }
            // If the character is an operator, pop operators from the stack and append them to the postfix expression
            // until an operator with lower precedence is encountered, then push the current operator to the stack
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop any remaining operators from the stack and append them to the postfix expression
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
            }
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String infixExpression = sc.nextLine();
//        String infixExpression = "a+b*c-(d/e+f)*g";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}