package LinkedInQuestions.Stacks;

import java.util.Stack;

/**
 * Created by rmukherj on 8/21/16.
 */
public class InfixToPostfix {
    int GetOperatorPriority(char op)
    {
        int priority = 0;

        switch (op)
        {
            case '+':
            case '-':
                priority = 0;
                break;
            case '*':
            case '/':
                priority = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid Operator");
        }

        return priority;
    }

    boolean IsOperator(char ch)
    {
        return
                (ch == '+' ||
                        ch == '-' ||
                        ch == '*' ||
                        ch == '/');
    }

    String InfixToPostfixExpression(String infixExpression)
    {
        String postfixExpression = "";
        Stack<Character> operatorStack = null;

        for (Character ch : infixExpression.toCharArray())
        {
            if (!IsOperator(ch))
            {
                postfixExpression += ch;
            }
            else
            {
                if (!operatorStack.empty())
                {
                    while (!operatorStack.empty() &&
                            (GetOperatorPriority(operatorStack.peek()) >= GetOperatorPriority(ch)))
                    {
                        char opFromStack = operatorStack.peek();
                        operatorStack.pop();

                        postfixExpression += opFromStack;
                    }
                }

                operatorStack.push(ch);
            }
        }

        if (!operatorStack.empty())
        {
            char opFromStack = operatorStack.peek();
            operatorStack.pop();
            postfixExpression += opFromStack;
        }

        return postfixExpression;
    }
}
