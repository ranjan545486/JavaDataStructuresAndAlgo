package tryingsomething.Miscellanous;

/**
 * Created by rmukherj on 9/18/16.
 */
public class LandscapeAndPortrait {
    final int R;
    final int V;
    final int x;

    public LandscapeAndPortrait(int r, int v, int x) {
        R = r;
        V = v;
        this.x = x;
    }


    final
    public int findMax(int m, int R, int V, int x, char[] arr){
        int count = 0, sum = 0;
        for(char c : arr){
            sum = sum+ getCost(c,R, V, m);
        }

        count = count + x/sum * arr.length;
        x = x% sum;
        if(count > 0){
            x = x+ m;
        }

        if(x<V)
            return count;
        sum = 0;
        int b = 0;

        for(char c: arr){
            if(getCost(c,R,V,m)+sum<x){
                sum = sum + getCost(c,R,V,m);
                count++;
            } else {
                sum = sum - getCost(arr[b],R,V,m)+ getCost(c,R,V,m);
                b++;
            }
        }

        return count;
    }

    private int getCost(char c, int R, int V, int m) {
        int cost = V+m;
        if(c=='L'){

            cost = cost+R;
        }

        return cost;
    }

}
