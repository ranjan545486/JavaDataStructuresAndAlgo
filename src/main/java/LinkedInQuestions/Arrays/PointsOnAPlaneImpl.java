package LinkedInQuestions.Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rmukherj on 8/20/16.
 */
public class PointsOnAPlaneImpl {
    List<Point> plane;

    PointsOnAPlaneImpl(){
        this.plane = new ArrayList<Point>();
    }

    /**
     * Stores a given point in an internal data structure
     */
    public void addPoint(Point point){
        plane.add(point);
    }

    /**
     * For given 'center' point returns a subset of 'm' stored points that are
     * closer to the center than others.
     *
     * E.g. Stored: (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
     *
     * findNearest(new Point(0, 0), 3) -> (0, 1), (0, 2), (0, 3)
     */
    Collection<Point> findNearest(Point center, int m){

        List<Integer> distanceList = new ArrayList<Integer>();
        PriorityQueue<Point> distanceQueue = new PriorityQueue<Point>();
        for(int i=0;i<plane.size();i++){
            double distance = getDistance(center,plane.get(i) );
            plane.get(i).setDistFromCenter(distance);
            distanceQueue.add(plane.get(i));
        }
        List<Point> result = new ArrayList<Point>();
        for(int i =0;i<m;i++){
            result.add(distanceQueue.poll());
        }
        return result;

    }

    private double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getY()-point1.getY(),2) - Math.pow(point2.getX() - point1.getX(),2));
    }


    public class Point implements Comparable<Point>{
        int x;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (Double.compare(point.distFromCenter, distFromCenter) != 0) return false;
            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = x;
            result = 31 * result + y;
            temp = Double.doubleToLongBits(distFromCenter);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        int y;
        double distFromCenter;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        //setters and getters
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }


        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }



        public double getDistFromCenter() {
            return distFromCenter;
        }

        public void setDistFromCenter(double distFromCenter) {
            this.distFromCenter = distFromCenter;
        }


        Point(int x, int y){
            this.x=x;
            this.y=y;
        }


        @Override
        public int compareTo(Point p) {
            if(this.distFromCenter ==p.getDistFromCenter())
                return 0;
            if(this.distFromCenter > p.getDistFromCenter())
                return 1;
            else
                return -1;
        }
    }
}
