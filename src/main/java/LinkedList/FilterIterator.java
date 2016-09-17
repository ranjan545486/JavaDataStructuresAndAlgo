package LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rmukherj on 8/22/16.
 */
public class FilterIterator {
    private Iterator iter;
    private boolean hasCached;
    private T cached;

    FilterIterator(Iterator i){
        this.iter = i;
    }

    public boolean hasNext() {
        if ( hasCached ) return true;
        //iterate until you find one and set hasCached and cached
        return false;
    }

    public T next() {
        if ( hasCached ) {
            hasCached = false;
            return cached;
        }
        //iterate until next matches
        return null;
    }

    public static void main(String [] args)
    {
        List ls = Arrays.asList("Test", "Hello", "World", "This is a long string");
        FilterIterator fi = new FilterIterator(ls.iterator());
        while(fi.hasNext())
        {
            System.out.println(fi.next());
        }
    }
}