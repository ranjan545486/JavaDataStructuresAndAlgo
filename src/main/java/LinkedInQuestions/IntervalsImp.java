package LinkedInQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rmukherj on 8/20/16.
 */
public class IntervalsImp implements Intervals {
    List<Point> list = new ArrayList<Point>();

    @Override
    public void addInterval(int from, int to) {
        list.add(new Point(from,to));

    }

    @Override
    public int getTotalCoveredLength() {
        Collections.sort(list);

        int totalLen = 0;
        Point lastPoint = new Point(0, 0);

        for (Point point : list) {

            if (point.x > lastPoint.y) {   //located apart
                totalLen += point.y - point.x;
                lastPoint = point;

            } else if (point.x == lastPoint.x && lastPoint.y < point.y) { //start from same origin

                totalLen += point.y - lastPoint.y;

                lastPoint = point;


            } else if (point.x < lastPoint.y && point.y > lastPoint.y) { //in between
                totalLen += point.y - lastPoint.y;
                lastPoint = point;
            }


        }

        return totalLen;
    }
    public static void main(String... args) {
        IntervalsImp obj = new IntervalsImp();
//        obj.addInterval(3, 6);
//        obj.addInterval(8, 9);
//        obj.addInterval(1, 5);
//        obj.addInterval(1, 3);
//        obj.addInterval(1, 8);
//        obj.addInterval(3, 10);
//        obj.addInterval(15, 25);
obj.addInterval(1,3);
        obj.addInterval(2,5);
        obj.addInterval(8,9);

        System.out.println(obj.getTotalCoveredLength());
    }


}

class Point implements Comparable<Point> {

    public int x, y;


    Point(int x, int y) {
        if (x > y)
            throw new IllegalArgumentException("x can't be greater than y");

        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        return o == null ? 0 : (this.x - o.x);
    }
}
