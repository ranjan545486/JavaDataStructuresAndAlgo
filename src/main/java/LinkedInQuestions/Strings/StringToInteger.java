package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/21/16.
 */
public class StringToInteger {
    //This method uses the regex to check for the number.
    public boolean isNumber(String str) {
        if(str==null) return false;
        return str.split("(^-)?\\d+(\\.)*\\d*").length == 0;
    }
/*Most obvious way to inspect each character and check
1. Each character is number or '.' or '-'
2. There has to be only '.'
3. '-' has to appear first
Instead I chose the regex way
*/
}
