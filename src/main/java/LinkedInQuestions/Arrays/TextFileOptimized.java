package LinkedInQuestions.Arrays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by rmukherj on 8/24/16.
 *  A reference to a file.
public class TextFile implements Iterable<String>. From 1point 3acres bbs
        {
public TextFile(String fileName) { // please implement this

Begin reading the file, line by line. The returned Iterator.next() will return a line.
@Override
public Iterator<String> iterator() { // please implement this
        ANSWER: An implementation of this using bufferedReader:
 */
public class TextFileOptimized implements Iterable<String>{

    private BufferedReader br;

    public TextFileOptimized(String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(fileName));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                try {
                    br.mark(1);
                    if (br.read() < 0) {
                        return false;
                    }
                    br.reset();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }

            @Override
            public String next() {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    return null;
                }
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }
}