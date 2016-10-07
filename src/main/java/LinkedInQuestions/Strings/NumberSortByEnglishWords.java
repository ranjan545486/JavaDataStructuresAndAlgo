package LinkedInQuestions.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rmukherj on 10/4/16.
 */
public class NumberSortByEnglishWords {
    public static void main(String[] args) {
        Integer[] input = {1,22,44,3456,9999};
        final String[] array = {
                "one", "twotwo", "fourfour",
                "threefourfivesix","ninenineninenine"
        };

        final Map<Integer, String> map = createMap(input, array);
        Arrays.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        System.out.println(Arrays.toString(input));
    }

    private static <K, V> Map<K, V> createMap(K k[], V v[])
    {
        Map<K, V> map = new LinkedHashMap<K, V>();
        for (int i=0; i<k.length; i++)
        {
            map.put(k[i], v[i]);
        }
        return map;
    }
}
