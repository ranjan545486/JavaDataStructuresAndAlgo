package tryingsomething.HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by rmukherj on 9/24/16.
 */
public class LimitAndWeightArray {
    public int[] limitAndWeight(int[] array, int weight){
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for(int i=0;i<array.length;i++){
            int index = array[i];
            for(int j= i+1;j<array.length;j++){
                if(index+array[j] == weight){
                    result[0] = index;
                    result[1] = array[j];
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        LimitAndWeightArray lma = new LimitAndWeightArray();
        int[] array = {1, 2, 4, 5};
        int weight = 5;
        int[] results = lma.limitAndWeight(array, weight);

        IntStream stream = Arrays.stream(results);
       // stream.forEach(x-> System.out.println(x));
        lma.limandweight(array,weight);

    }

    public void limandweight(int[] array, int limit){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] r = new int[2];

        for(int i = 0;i<array.length;i++){
            if(hm.containsKey(array[i])){
                //System.out.println(array[i] + ", "+hm.get(array[i]));
                System.out.println(hm.get(array[i]) +","+ array[i]);
            } else{
                hm.put(limit - array[i], array[i]);
            }
        }

    }



}
