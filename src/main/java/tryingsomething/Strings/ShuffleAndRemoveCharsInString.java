package tryingsomething.Strings;

import java.util.Scanner;

/**
 * Created by rmukherj on 9/18/16.
 */
public class ShuffleAndRemoveCharsInString {
            public static void main(String[] args)
            {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter a String");
                String userInput = in.nextLine();
                String answer = "";
                boolean stillSimilar = true;

                char[] inputArray = userInput.toCharArray();
                while (stillSimilar)
                {
                    for (int i = 0; i < inputArray.length - 1; i++)
                    {
                        if (inputArray[i] == inputArray[i + 1])
                        {
                            char tmp = inputArray[i + 1];
                            inputArray[i + 1] = inputArray[(i + 2) % inputArray.length];
                            inputArray[i + 2] = tmp;
                        }
                    }
                    stillSimilar = isSimilar(inputArray);
                }

                for (int i = 0; i < inputArray.length; i++)
                {
                    answer += inputArray[i];
                }
                System.out.println(answer);

            }

            public static boolean isSimilar(char[] input)
            {
                for (int i = 0; i < input.length - 1; i++)
                {
                    if (input[i] == input[i + 1]) {
                        return true;
                    }
                }
                return false;
            }
        }


