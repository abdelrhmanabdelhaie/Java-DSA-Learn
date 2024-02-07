package DS.linerDS.Stack.LinkedListBasedStack.infixToPostfix;

import java.util.Stack;

public class iToP {
    public StringBuilder postFix = new StringBuilder();
    public Stack<Character> stack = new Stack<>();

    public void convertToPostfix(String infix) {
        for (int i = 0; i < infix.length(); i++) { //O(n)
            Character chr = infix.charAt(i);
            if (Character.isLetterOrDigit(chr)) {
                postFix.append(chr);
            } else if (chr == '(') {
                stack.push(chr);
            } else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postFix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(chr) <= precedence(stack.peek())) {
                    postFix.append(stack.pop());
                }
                stack.push(chr);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
            }
            postFix.append(stack.pop());
        }
    }

    public int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*c-(d/e+f)*g";
        iToP iToP = new iToP();
        iToP.convertToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + iToP.postFix);
    }

}
