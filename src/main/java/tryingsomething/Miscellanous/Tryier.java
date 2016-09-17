package tryingsomething.Miscellanous;

import java.util.Scanner;

/**
 * Created by rmukherj on 9/17/16.
 */
public class Tryier {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int first = scan.nextInt();

        Double second = scan.nextDouble();

        //String third = "";2
//        while (scan.hasNext()){
//            third = scan.next();
//            if("!".equals(third))
//                break;
//        }
        String third = scan.nextLine();
        System.out.println(i+first);
        System.out.println(d+second);
        System.out.print(s+third);
        scan.close();

    }
}
