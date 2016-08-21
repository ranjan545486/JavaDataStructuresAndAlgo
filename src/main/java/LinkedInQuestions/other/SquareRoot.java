package LinkedInQuestions.other;

/**
 * Created by rmukherj on 8/14/16.
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(0.16)); // 0.4
    }

    public static double findSquareRoot(double value) {
        double low = 0;
        double high = value;
        double mid = value > 1.0 ? (low + high) / 2 : 1.0;
        while (Math.abs(value - mid * mid) > 0.000001) {
            if (mid * mid == value) {
                return mid;
            }
            if (mid * mid > value) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }
}
