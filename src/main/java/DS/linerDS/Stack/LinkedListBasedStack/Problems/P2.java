package DS.linerDS.Stack.LinkedListBasedStack.Problems;

import DS.linerDS.Stack.LinkedListBasedStack.Node;

//Problem #2: Postfix Evaluation
//        ● Implement function: double evalaute_postfix(string postfix)
//          ○ Use a linked-list stack implementation
//        ● Input ⇒ Output
//           ○ 52/ ⇒ 2.5
//           ○ 12+3+ ⇒ 6
//           ○ 123*+ ⇒ 7
//           ○ 23*4+ ⇒ 10
//           ○ 135*+72/- ⇒ 12.5
//           ○ 432^^ ⇒ 262144
public class P2 {
    public static LinkedListStack stack = new LinkedListStack();
    public static double sum;

    public void evallaute_postfix(String postFix) {
        for (int i = 0; i < postFix.length(); i++) {
            char chr = postFix.charAt(i);
            if (Character.isDigit(chr)) {
                stack.push(chr);
            } else {
                if (stack.size >= 2) {
                    sum = evaluate(Character.getNumericValue(stack.pop()), Character.getNumericValue(stack.pop()), chr);
                    if (i != postFix.length() - 1) {
                        stack.push((char) sum);
                    }
                } else {
                    System.out.println("Error Expression");
                }
            }

        }
        if (stack.size != 0) {
            System.out.println("Error");
        }
    }

    private static double evaluate(double first, double second, char op) {
        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;

            case '/':
                if (second == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return first - second;
            case '*':
                return first * second;
            case '^':
                return Math.pow(first, second);
        }
        throw new IllegalArgumentException("Invalid operator: " + op);
    }

    public static class LinkedListStack {
        Node<Character> top;
        int size;

        public void push(char c) {
            Node newNode = new Node(c);
            if (top != null) {
                newNode.next = top;
            }
            top = newNode;
            size++;
        }

        public char pop() {
            char c = top.data;
            top = top.next;
            size--;
            return c;
        }
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        p2.evallaute_postfix("52/");
        System.out.println(sum);

    }
}
