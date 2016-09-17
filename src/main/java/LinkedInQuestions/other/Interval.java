package LinkedInQuestions.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rmukherj on 8/14/16.
 */
class IntervalCollection {

    int lowesrtLowerBound;//Stores the lowest lower bound in collection
    int highestUpperBound;//Stores highest upper bound in collection.

    List<Interval> intervalList = new ArrayList<Interval>();

    public void insertInterval(int lowerBound, int upperBound) {

        if (lowerBound >= upperBound) {
            System.out.println("Invalid input");
            return;
        }

        Interval interval = new Interval(lowerBound, upperBound);
        if (intervalList.size() == 0) {
            System.out.println("Base case");
            intervalList.add(interval);
            updateLowestAndHighest(lowerBound, upperBound);
            return;
        }

        if (lowerBound <= lowesrtLowerBound && upperBound >= highestUpperBound) {
            System.out.println("Interval that covers all other intervals in the list");
            intervalList.clear();
            intervalList.add(interval);
            updateLowestAndHighest(lowerBound, upperBound);
            return;
        }

        Interval mergeCandidate1 = null;
        Interval mergeCandidate2 = null;

        for (Interval in : intervalList) {

            if (in.equals(interval))
                return;//Duplicate

            if (mergeCandidate1 == null && in.lowerBound <= lowerBound) {
                mergeCandidate1 = in;
            }

            if (mergeCandidate2 == null && in.upperBound >= upperBound) {
                mergeCandidate2 = in;
            }

            if (mergeCandidate1 != null && mergeCandidate2 != null) {
                break;
            }
        }

        if (mergeCandidate1 != null && mergeCandidate2 != null) {
            System.out.println("Merge candidates identified");
            Interval i = new Interval(mergeCandidate1.lowerBound, mergeCandidate2.upperBound);
            intervalList.add(i);
            updateLowestAndHighest(i.lowerBound, i.upperBound);
            intervalList.remove(mergeCandidate1);
            intervalList.remove(mergeCandidate2);

        } else {
            System.out.println("Adding a new item");
            intervalList.add(interval);
        }

    }

    private void updateLowestAndHighest(int lowerBound, int upperBound) {
        if (lowerBound < lowesrtLowerBound) {
            lowesrtLowerBound = lowerBound;
        }

        if (upperBound > highestUpperBound) {
            highestUpperBound = upperBound;
        }
    }

    public void print() {
        Collections.sort(intervalList);//Optional:Sorting just to see the intervals in order.
        for (Interval in : intervalList) {
            System.out.println(in);
        }
        System.out.println("\n");
    }
}

public class Interval implements Comparable<Interval>
{//Implemented Comparable just in case if we want to Sort the collection.
   public int lowerBound;
    public int upperBound;

    public Interval(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;;
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");
        builder.append(lowerBound).append(", ").append(upperBound).append(" ]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (this == object)
            return true;

        if (!(object instanceof Interval)) {
            return false;
        }

        Interval receivedInterVal = (Interval) object;

        return this.lowerBound == receivedInterVal.lowerBound && this.upperBound == receivedInterVal.upperBound;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + upperBound + lowerBound;
    }

    @Override
    public int compareTo(Interval that) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == that)
            return EQUAL;

        if (this.lowerBound == that.lowerBound && this.upperBound == that.upperBound) {
            return EQUAL;
        }

        if (this.lowerBound < that.lowerBound) {
            return BEFORE;
        }

        return AFTER;
    }

    public static void main(String[] args) {
        IntervalCollection intervalCollection = new IntervalCollection();

        intervalCollection.insertInterval(-10, -1);
        intervalCollection.print();
        intervalCollection.insertInterval(0, 2);
        intervalCollection.print();

        intervalCollection.insertInterval(4, 10);
        intervalCollection.print();

        //intervalCollection.insertInterval(4, 10);
        intervalCollection.insertInterval(-5, 1);

        intervalCollection.print();

        intervalCollection.insertInterval(-4, 1);
        intervalCollection.print();

        intervalCollection.insertInterval(-11, 11);
        intervalCollection.print();


    }
}
