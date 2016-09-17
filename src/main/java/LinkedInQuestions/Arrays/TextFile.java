package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/23/16.
 */
/*
Question:
	Implement a (Java) Iterable object that iterates lines one by one from a text file.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** A reference to a file. */
public class TextFile implements Iterable<String>
{
    List<String> lines;
    public TextFile(String fileName) { // please implement this.
        lines= new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String thisline = null;
            while((thisline=br.readLine())!=null){
                lines.add(thisline);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /** Begin reading the file, line by line. The returned Iterator.next() will return a line. */
    @Override
    public Iterator<String> iterator() { // please implement this
        return lines.iterator();
    }

    public static void main(String[] args){
        TextFile tf = new TextFile("test.txt");
        Iterator<String> ir = tf.iterator();//List implements Iterator.
        while(ir.hasNext()){
            System.out.println(ir.next());
        }
    }
}