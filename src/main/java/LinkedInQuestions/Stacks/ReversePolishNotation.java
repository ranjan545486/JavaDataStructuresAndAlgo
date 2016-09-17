package LinkedInQuestions.Stacks;

import java.util.*;

/**
 * Created by rmukherj on 8/14/16.
 */
public class ReversePolishNotation {

    private static final Set<String> OPERATORS =
             new HashSet<>(Arrays.asList("+","-","*","/"));

    public double evalRPN(String[] tokens){
        Stack<Double> stack = new Stack<>();
        for(String token:tokens){
            if(OPERATORS.contains(token)){
                Double y = stack.pop();
                Double x = stack.pop();
                stack.push(eval(x,y,token));
            } else{
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

    private double eval(double x, double y, String token) {
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
//    interface OperatorIC {
//        int eval(Double x, Double y);
//    }
//    private static final Map<String, OperatorIC> OPERATORSIC =
//            new HashMap<String, OperatorIC>() {{
//                put("+", new OperatorIC() {
//                    public int eval(Double x, Double y) { return x + y; }
//                });
//                put("-", new OperatorIC() {
//                    public int eval(Double x, Double y) { return x - y; }
//                });
//                put("*", new OperatorIC() {
//                    public int eval(Double x, Double y) { return x * y; }
//                });
//                put("/", new OperatorIC() {
//                    public int eval(Double x, Double y) { return x / y; }
//                });
//            }};
    public Double evalRPNImprovised(String[] tokens) {
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                Double y = stack.pop();
                Double x = stack.pop();
                stack.push((double) eval(x, y,token));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] str = {"2", "1", "+", "3.3", "*"};
        System.out.println( rpn.evalRPN(str));
    }
}
