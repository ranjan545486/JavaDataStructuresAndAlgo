package tryingsomething.Strings;

/**
 * Created by rmukherj on 9/11/16.
 */
public class KMP {
    private static int[] PrefixTable(String pattern)
    {
        //We will calculate the longest prefix of 0->ip that is also a prefix of the pattern

        int np = pattern.length();
        int[] prefixtable = new int[np];

        int ip = 2;
        int k = 0;

        while (true)
        {
            if (ip >= np)  //We have shifted out of our pattern, we are done.
                break;
            if (pattern.charAt(k) == pattern.charAt(ip - 1))//Our prefix extends
            {
                prefixtable[ip] = (k + 1);
                ip++;
                k++;
                continue;
            }
            if (k > 0)//We have a mismatch, so we need to see if we have a smaller prefix that we can use
            //We already calculated this, so just get it.
            {
                k = prefixtable[ip];
                continue;
            }
            //We have a mismatch, but K = 0, so we dont have a prefix.
            prefixtable[ip] = 0;
            ip++;
        }
        prefixtable[np - 1] = k;
        prefixtable[0] = -1;
        return prefixtable;
    }



    public static int Kmp(String text, String pattern)
    {
        int nt = text.length();
        int np = pattern.length();
        int[] prefixtable = PrefixTable(pattern);

        int it = 0;
        int ip = 0;

        //We will keep looping, untill
        //-->We have found a match (ip > (np -1)
        //--> We have shifted out of our text, not found (it > (nt -np))
        //We have match, step forward in the pattern!
        //We have a mismatch, jump back as much as the sigmatable tells us.

        while (true)
        {
            if (ip > (np - 1))
            {
                return it;
            }
            if (it > (nt - np))
            {
                return -1;
            }
            if (text.charAt(it + ip) == pattern.charAt(ip))
            {
                ip++;
                continue;
            }
            it = (it + (ip - prefixtable[ip]));
            ip = ip > 0 ? prefixtable[ip] : 0;
        }
    }

    public static void main(String[] args) {

        String text = "aabbccdefg";
        String pattern = "ccde";
        int c = KMP.Kmp(text, pattern);
        System.out.println("The pattern found at "+ c);

    }

}
