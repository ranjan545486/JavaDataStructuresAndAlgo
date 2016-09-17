package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/24/16.
 */

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

/** A reference to a file. */
public class TextFileIterable implements Iterable<String> {
    Scanner scanner;
    public TextFileIterable(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {

        }
    }

    /** Begin reading the file, line by line.
     *  The returned Iterator.next() will return a line.
     */
    @Override
    public Iterator<String> iterator() {
        return new TextFileIterator();
    }

    private class TextFileIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}