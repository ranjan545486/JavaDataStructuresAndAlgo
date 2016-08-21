package LinkedInQuestions.Arrays;

import java.util.HashSet;

/**
 * Created by rmukherj on 8/20/16.
 */
public class GeneratePermutations {

    // Define other methods and classes here
    void Generate(
            char[] input, char[] output, HashSet<Character> selectedChars, int index)
    {
        if(index == input.length)
        {
            System.out.println(output);
            return;
        }

        for(char c : input)
        {
            if(!selectedChars.contains(c))
            {
                output[index] = c;
                selectedChars.add(c);
                Generate(input, output, selectedChars, index + 1);
                selectedChars.remove(c);
            }
        }

    }

    // Define other methods and classes here
    void GeneratePerm(
            Integer[] input, Integer[] output, HashSet<Integer> selectedIntegers, Integer index)
    {
        if(index == input.length)
        {
            for(int i=0;i<output.length;i= i+output.length){
                for(int j=i;j<3;j++){
                    System.out.print(output[j] + " ");
                }
                System.out.println("");
            }


            //System.out.println(output);
            return;
        }

        for(Integer c : input)
        {
            if(!selectedIntegers.contains(c))
            {
                output[index] = c;
                selectedIntegers.add(c);
                GeneratePerm(input, output, selectedIntegers, index + 1);
                selectedIntegers.remove(c);
            }
        }

    }

    public static void main(String[] args) {
        GeneratePermutations gp = new GeneratePermutations();
        gp.GeneratePerm(new Integer[]{1,2,3},new Integer[3], new HashSet<Integer>(),0);
        gp.Generate(new char[]{'a','b','c'},new char[3],new HashSet<Character>(),0);
    }
}
