package tryingsomething.HashTables;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmukherj on 9/15/16.
 */
public class MostCommonElementInArray {

    public static void main(String[] args) {
        MostCommonElementInArray mscea = new MostCommonElementInArray();
        System.out.println(mscea.findMostCommonElementInArray(new int[]{1,2,3,4,5,6,7,7,7,7,8}));
    }

    public int findMostCommonElementInArray(int[] a){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : a) {
            Integer count = map.get(i);
            map.put(i, count != null ? count+1 : 0);
        }

        Integer popular = Collections.max(map.entrySet(),
                (o1, o2) -> o1.getValue().compareTo(o2.getValue())).getKey();

        return popular;
    }
}
