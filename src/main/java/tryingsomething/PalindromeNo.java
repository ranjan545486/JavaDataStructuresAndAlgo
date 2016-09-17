package tryingsomething;

/**
 * Created by rmukherj on 8/3/16.
 */
public class PalindromeNo {

    public boolean reverse(int num){
        assert num>=0;
        int actual = num;
        int rev = 0;
        while (num!=0){
            rev = rev*10+num%10;
            num = num/10;

        }

        if(actual == rev)
            return true;

        return false;

        //return rev;
    }

    //correct solution as per amazon with all test case pass. But actually wrond
    public static boolean isPal(int orig)
    {
        int copy = orig;
        int reversed = 0;

        while(copy!=0)
        {
            reversed <<= 1;
            reversed |= (copy & 1);
            copy >>>= 1;
        }
        return (reversed == orig);
    }

    public static void main(String[] args){
        PalindromeNo p = new PalindromeNo();
        int nn = 1441;
        System.out.println(p.reverse(141));
        System.out.println(p.isPal(111));


    }
}

/*
int p = x;
        int reverse = 0;

        while(p!=0){
            int r = p%10;
            reverse = reverse*10+r;
            p = p/10;
        }

        if(x == reverse){
            return true;
        }

        return false;
 */

    /*
    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('<', '>');

    }
    static boolean hasBalancedBrackets(String s) {
         if (s.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }

        if ((s.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.empty() || (s.charAt(i) != brackets.get(stack.pop()))) {
                return false;
            }
        }
        return true;


    }

    //all tests passes
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == L_PAREN)   stack.push(L_PAREN);

            else if (s.charAt(i) == L_BRACE)   stack.push(L_BRACE);

            else if (s.charAt(i) == L_BRACKET) stack.push(L_BRACKET);

            else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_PAREN) return false;
            }

            else if (s.charAt(i) == R_BRACE) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACE) return false;
            }

            else if (s.charAt(i) == R_BRACKET) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACKET) return false;
            }

            // ignore all other characters

        }
        return stack.isEmpty();
    }


     */
