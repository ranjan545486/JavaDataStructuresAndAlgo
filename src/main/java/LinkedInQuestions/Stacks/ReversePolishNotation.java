package LinkedInQuestions.Stacks;

import java.util.*;

/**
 * Created by rmukherj on 8/14/16.
 */
public class ReversePolishNotation {

    private static final Set<String> OPERATORS =
             new HashSet<>(Arrays.asList("+","-","*","/"));

    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(OPERATORS.contains(token)){
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x,y,token));
            } else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int eval(int x, int y, String token) {
        switch(token){
            case "+":return x+y;
            case "-":return x-y;
            case "*":return x*y;
            default: return x/y;
        }
    }

    /*
    Improvised Code
     */
    interface OperatorIC {
        int eval(int x, int y);
    }
    private static final Map<String, OperatorIC> OPERATORSIC =
            new HashMap<String, OperatorIC>() {{
                put("+", new OperatorIC() {
                    public int eval(int x, int y) { return x + y; }
                });
                put("-", new OperatorIC() {
                    public int eval(int x, int y) { return x - y; }
                });
                put("*", new OperatorIC() {
                    public int eval(int x, int y) { return x * y; }
                });
                put("/", new OperatorIC() {
                    public int eval(int x, int y) { return x / y; }
                });
            }};
    public int evalRPNImprovised(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORSIC.containsKey(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORSIC.get(token).eval(x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] str = {"2", "1", "+", "3", "*"};
        System.out.println( rpn.evalRPN(str));
    }
}
