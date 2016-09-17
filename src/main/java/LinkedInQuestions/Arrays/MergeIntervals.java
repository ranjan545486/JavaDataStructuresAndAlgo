package LinkedInQuestions.Arrays;

import LinkedInQuestions.other.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rmukherj on 8/21/16.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if(intervals==null||intervals.size()==0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.lowerBound!=i2.lowerBound)
                    return i1.lowerBound-i2.lowerBound;
                else
                    return i1.upperBound-i2.upperBound;
            }
        });

        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.lowerBound>pre.lowerBound){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.lowerBound, Math.max(pre.upperBound, curr.upperBound));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }
}
