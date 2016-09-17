package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/21/16.
 */
public class SmallestNextCharacter {
    public static char findNextChar(char[] list, char c) {
        assert list.length > 0;
        int left = 0, right = list.length - 1;
        char result = list[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == c) {
                if (mid < list.length - 1) return list[mid+1];
                else return result;
            }
            else if (list[mid] < c) {
                left = mid + 1;
            }
            else {//list[mid] > c
                result = list[mid];
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] list = {'c', 'f', 'j', 'p', 'v'};
        char[] target = {'a', 'c', 'f', 'k', 'v', 'z'};
        for (char c : target) System.out.println(c + " -> " + findNextChar(list, c));
    }
}
