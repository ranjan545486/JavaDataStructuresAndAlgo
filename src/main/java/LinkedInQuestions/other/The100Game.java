package LinkedInQuestions.other;

/**
 * Created by rmukherj on 8/22/16.
 */
public class The100Game{
    boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger*maxChoosableInteger + maxChoosableInteger) / 2 < desiredTotal) {
            // Neither player can win.
            return false;
        }
        int[] numbers = new int[maxChoosableInteger];
        for (int i = 0; i < maxChoosableInteger; ++i) {
            numbers[i] = i + 1;
        }
        return canWin(numbers, desiredTotal);
    }

    boolean canWin(int[] numbers, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        for(int i = 0; i < numbers.length; ++i) {
            int newTotal = desiredTotal - numbers[i];
            if (!canWin(remove(numbers, i), newTotal)) {
                return true;
            }
        }
        return false;
    }

    int[] remove(int[] a, int k) {
        int[] b = new int[a.length-1];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (i != k) {
                b[j++] = a[i];
            }
        }
        return b;
    }

    public static void main(String[] args){
        The100Game game = new The100Game();
        System.out.println("\nPlayer-"+(game.canIWin(3,1)?"1":"2")+" wins!");
    }
}
