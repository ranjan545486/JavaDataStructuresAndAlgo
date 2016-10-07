package tryingsomething.OOPS;

import java.util.Scanner;

/**
 * Created by rmukherj on 9/10/16.
 */
public class Practice1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int ip = 0;
        for (int i = 0; i < input ; i++) {
            Scanner s = new Scanner(System.in);
            int is = s.nextInt();
            ip = ip+is;
        }

        System.out.println(ip);
    }
}
