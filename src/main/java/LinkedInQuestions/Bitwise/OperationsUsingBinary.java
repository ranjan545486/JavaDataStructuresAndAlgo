package LinkedInQuestions.Bitwise;

/**
 * Created by rmukherj on 8/15/16.
 */
public class OperationsUsingBinary {
    public static int Add(int a, int b)
    {
        if(b==0)
            return a;
        int c = a^b;
        int carriage = (a&b)<<1;
        return Add(c,carriage);

    }

    public static int Sub(int a, int b)
    {
        int x = ~b;
        //x.Dump();
        return Add(a, Add(x, 1));
    }

    public static int Mul(int a, int b)
    {
        int r = 0;
        while (b != 0)
        {
            int temp = b & 1;

            if (temp!= 0)
            {
                r = r + a;
            }
            a= a << 1;
            b= b >> 1;
            if (temp == 0)
            {
                r = a;
                break;
            }
        }

        return r;
    }

    public int divide(int dividend, int divisor) {
        //handle special cases
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);

        int result = 0;
        while (pDividend >= pDivisor) {
            //calculate number of left shifts
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException(
                    "Division by 0 is undefined: " + a + "/" + b);
        }
        int sign = 1;
        int x = 0;
        if (a < 0) {
            a = -a;
            x = ~(int)a;
            sign = -sign;
        }
        if (b < 0) {
            b = -b;
            sign = -sign;
        }
        double result = 0;
        while (a >= 0) {
            a -= b;
            result++;
        }
        return (result - 1) * sign;
    }

    public static int divideWithoutSymbol(int numerator, int denominator){
        int counter = 0;
        int addedUp = 0;

        while(addedUp <= denominator-numerator){
            addedUp += numerator;
            counter++;
        }

        return counter;
    }
    int divi(long m, long n)
    {

        //m = Math.abs(m);
        //n = Math.abs(n);
//        if(m==0 || n==0 || m<n)
//            return 0;
        if(m==0 || n==0)
            return 0;
        int sign = 1;
        if (m < 0) {
            m = -m;
            sign = -sign;
        }
        if (n < 0) {
            n = -n;
            sign = -sign;
        }

        if(m<n){
            return 0;
        }

        long  a,b;
        int f=0;
        a=n;b=1;

        f=1;
        while(a<=m)
        {
            b = b<<1;
            a = a<<1;

        }

        if(f>0)
        {
            b = b>>1;
            a = a>>1;
        }

        b = b + divi(m-a,n);
        return (int)b *sign;
    }

    public static void main(String[] args) {
        long a = -16;
        long b = 2;
        OperationsUsingBinary ob = new OperationsUsingBinary();
        System.out.println(ob.divi(a,b));
        System.out.println(ob.Mul((int)a,(int)b));
        System.out.println(ob.Add((int)a,(int)b));
        System.out.println(ob.divide(a,b));
        System.out.println(ob.Sub((int)a,(int)b));
        System.out.println(powerBinary(5,-3));
        System.out.println(ob.pow(5,-3));


    }

    /**
     * Returns a^b, as the standard mathematical exponentiation function

    public double pow(double a, int b) {}

    Interviewer looking for log(n) solution, right on first attempt.

            - duskan February 22, 2014 in United States | Report Duplicate | Flag
     */

    private static double powerBinary(double a, int b){

        if(b == 0)
            return 1;
        if(b == 1)
            return a;
        else if(b%2 == 0)
            return powerBinary(a,b/2) * powerBinary(a,b/2);
        else
            return a* powerBinary(a,b/2) * powerBinary(a,b/2);

    }

    //correct solution.
    double pow(double a, int b) {

        int exp=Math.abs(b),i;
        double base=a;

        if(exp==0) return 1.0;

        i=1;

        while((exp>=1) && (i< Math.abs(b)) ){
            if(exp > 1) {
                exp = exp/2;
                i= i*2;
                base = base*base;
            } else {
                i=i+1;
                base = base*a;
            }
        }

        if(b<0)
        return 1/base;
        else
        return base;

    }
}
