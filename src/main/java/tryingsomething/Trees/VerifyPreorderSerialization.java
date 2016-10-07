package tryingsomething.Trees;

/**
 * Created by rmukherj on 9/18/16.
 */
import java.util.Stack;
public class VerifyPreorderSerialization
{

    //the idea is to use a stack and push the element into the stack when the
    //the current item is not equal to "#" and when the current item is equal
    //to the "#", then check the top element on the stack
    public boolean isValidSerialization(String preorder)
    {
        Stack<String> stack = new Stack<String>();
        String[] s = preorder.split(",");
        //if the length of array is 0
        //then there is no node in the binary tree
        //return false
        if(s.length==0)
        {
            return false;
        }
        //if the length of the array is 1
        //check if s[0] is equal to "#", then tree consists of null node
        //check if s[0] is not equal to "#", then return false (valid binary
        //tree with single node will have "9,#,#")
        if(s.length==1)
        {
            if(s[0].equals("#"))
                return true;
            else
                return false;
        }
        //push the first element in the array into the stack
        stack.push(s[0]);
        for(int i=1;i<s.length;i++)
        {
            //if s[i] is not equals to "#", then push
            if(!s[i].equals("#"))
            {
                stack.push(s[i]);
            }
            //if s[i] is equals to "#"
            else if(s[i].equals("#"))
            {
                //then check if the top element on the stack is not equals
                //to "#"
                if(!"#".equals(stack.peek()))
                {
                    stack.push(s[i]);
                }
                //if the top element on the stack is equals to "#"
                //then call pushPoundSymbol
                else
                {
                    if(!pushPoundSymbol(stack, s[i]))
                        return false;
                }
            }
        }

        if(stack.size()==1 && "#".equals(stack.peek()))
            return true;
        else
            return false;
    }

    public boolean pushPoundSymbol(Stack<String> stack, String symbol)
    {
        //if the stack is empty or the top element in the stack is not equals
        //to "#" then push the symbol on to the stack
        if(stack.isEmpty() || !"#".equals(stack.peek()))
        {
            stack.push(symbol);
        }
        else
        {
            //check if the size of the stack is greater than 1
            if(stack.size()>1)
            {
                //pop the top element that ie "#" and check if the next top
                //element is not "#"
                stack.pop();
                //if the top element is not "#" then pop the top element
                //else return false
                if(!"#".equals(stack.peek()))
                    stack.pop();
                else
                    return false;
                return pushPoundSymbol(stack, "#");
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        VerifyPreorderSerialization v = new VerifyPreorderSerialization();
        String serializedString = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        //String serializedString = "4,#,#,1";
        System.out.println(v.isValidSerialization(serializedString));
    }
}
