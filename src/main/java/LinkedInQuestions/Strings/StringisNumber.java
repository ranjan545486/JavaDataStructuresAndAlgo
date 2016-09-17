package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/21/16.
 */
public class StringisNumber {

    public static boolean isNumber(String str){
        char[] charNumbers = str.toCharArray();
        char start = '0';
        char end = '9';
        char dot = '.';
        char sign = '-';
        int counter = 0;
        for (char c :
             charNumbers) {
            if(c<start || c>end){
               if(c<start && !(c > end) && (c != dot || c!=sign)&& counter>=str.length()){
                   return false;
                }
            }
            counter++;


            
        }
        return true;
    }

    public static boolean IsNumber(String number)
    {
        int n = number.length(), dots = 0;
        if (number.charAt(0) == '.' || number.charAt(n - 1) == '.' || number.charAt(n - 1) == '-')
            return false;
        if ((number.charAt(0)< 48 || number.charAt(0) > 57) && number.charAt(0) != '-')
            return false;
        for (int i = 1; i < n; i++)
        {
            if (dots > 1)
                return false;
            if (number.charAt(i) < 48 || number.charAt(i) > 57)
            {
                if (number.charAt(i) == '.')
                {
                    if (i == 1 && number.charAt(i) == '-')
                        return false;
                    else
                        dots++;
                }
                else
                    return false;
            }
        }
        return true;
    }

    public boolean isNumberRegex(String str) {
        if(str==null) return false;
        //return str.split("(^-)?\\d+(\\.)*\\d*").length == 0;
        return str.split("(^-)?\\d+(\\.)?\\d*").length == 0;

    }

    public static void main(String[] args) {
        StringisNumber sin = new StringisNumber();
        System.out.println(sin.IsNumber("42.5"));
        System.out.println(sin.isNumberRegex("42.5"));
    }


}
