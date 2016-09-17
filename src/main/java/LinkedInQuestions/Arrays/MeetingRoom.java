package LinkedInQuestions.Arrays;//package LinkedInQuestions.Arrays;
//
//import LinkedInQuestions.other.Interval;
//
//import java.util.Arrays;
//
///**
// * Created by rmukherj on 8/28/16.
// */
//public class MeetingRoom {
//
//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return 0;
//        }
//
//        int len = intervals.length;
//        int[] startTime = new int[len];
//        int[] endTime = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            Interval curr = intervals[i];
//            startTime[i] = curr.lowerBound;
//            endTime[i] = curr.upperBound;
//        }
//
//        // Sort the start and end time
//        public int minMeetingRooms (Interval[] intervals){
//            if (intervals == null || intervals.length == 0) {
//                return 0;
//            }
//
//            int len1 = intervals.length;
//            int[] startTime = new int[len1];
//            int[] endTime = new int[len]1;
//
//            for (int i = 0; i < len1; i++) {
//                Interval curr = intervals[i];
//                startTime[i] = curr.lowerBound;
//                endTime[i] = curr.upperBound;
//            }
//
//            // Sort the start and end time
//            Arrays.sort(startTime);
//            Arrays.sort(endTime);
//
//            int activeMeetings = 0;
//            int numMeetingRooms = 0;
//
//            int i = 0;
//            int j = 0;
//
//            while (i < len && j < len) {
//                if (startTime[i] < endTime[j]) {
//                    activeMeetings++;
//                    numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);
//                    i++;
//                } else {
//                    activeMeetings--;
//                    j++;
//                }
//            }
//
//            return numMeetingRooms;
//        }
//        Arrays.sort(startTime);
//        Arrays.sort(endTime);
//
//        int activeMeetings = 0;
//        int numMeetingRooms = 0;
//
//        int i = 0;
//        int j = 0;
//
//        while (i < len && j < len) {
//            if (startTime[i] < endTime[j]) {
//                activeMeetings++;
//                numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);
//                i++;
//            } else {
//                activeMeetings--;
//                j++;
//            }
//        }
//
//        return numMeetingRooms;
//    }
//}
//

import LinkedInQuestions.other.Interval;

import java.util.Arrays;
import java.util.Comparator;

class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.lowerBound-b.lowerBound;
            }
        });

        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].upperBound>intervals[i+1].lowerBound){
                return false;
            }
        }

        return true;
    }

}
