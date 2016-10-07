package tryingsomething.OOPS;

import java.util.*;


/**
 * Created by rmukherj on 10/6/16.
 */
public class TimeData {
    public int timeDatae(Calendar d, int value, int memory){
        Map<Calendar, Integer> map = new HashMap<>();
        map.put(d,value);
        //System.out.println(map);

        for(Calendar data : map.keySet()){
            if((data.get(data.HOUR)>=1 &&
                    data.get(data.MINUTE)>=30) &&
                    (data.get(data.HOUR)<=2 &&
                            data.get(data.MINUTE)<=30)){
                int v = map.get(data);
                memory = memory + v;

            }
        }
        System.out.println(memory);
        return memory;
    }

    public static void main(String[] args) {
        int value= 0;
        Calendar u = Calendar.getInstance();

        u.set(Calendar.HOUR, 1);
        u.set(Calendar.MINUTE,30);
        TimeData td = new TimeData();
        value = td.timeDatae(u, 12, value);
        u.set(Calendar.HOUR, 2);
        u.set(Calendar.MINUTE,30);
        td.timeDatae(u, 15, value);


    }
}
