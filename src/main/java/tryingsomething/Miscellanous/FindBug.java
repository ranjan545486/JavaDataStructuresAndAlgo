package tryingsomething.Miscellanous;

/**
 * Created by rmukherj on 9/3/16.
 */
public class FindBug {

    public static void MakeTheNumbersMatch(int a, int b, int x, int y){
        while(a!=x || b!=y)
        {
            //missing condition
            if(a!=x){
                if(a> x)
                {
                    a--;
                }
                else
                {
                    a++;
                }
            }

            if(b!=y) {
                if (b > y) {
                    b--;
                } else {
                    b++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a=1,x=5,b=7,y=2;
        MakeTheNumbersMatch(a,b,x,y);
    }

}
