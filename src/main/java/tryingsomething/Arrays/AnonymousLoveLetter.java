package tryingsomething.Arrays;

/**
 * Created by rmukherj on 9/11/16.
 * You have written an anonymous love letter and you don't want your handwriting to be recognized.
 Since you don't have a printer within reach, you are trying to write this letter by copying
 and pasting characters from a newspaper.

 Given a string L representing the letter and a string N representing the newspaper,
 return true if the L can be written entirely from N and false otherwise.
 The letter includes only ascii characters.
 O(1)

 def isLoveLetterReproducible(L, M):
 charMap = int array of size
 charCount = 0

 for i from 0 to L.length:
 charCode = int(L.charAt(i))
 if (charMap[charCode] == 0):
 charCount++
 charMap[charCode]++

 for i from 0 to N.length:
 charCode = int(L.charAt(i))
 if (charMap[charCode] > 0):
 charMap[charCode]--
 if (charMap[charCode] == 0):
 charCount--
 if (charCount == 0):
 return true

 return false
 */
public class AnonymousLoveLetter {

    public boolean isLoveLetterReproducible(String message, String article){
        int[] availableChars = new int[256];
        for(int r=0;r<article.length();r++){
            int asciiCode = (int)(article.charAt(r));
            availableChars[asciiCode]++;

        }

        for(int r=0;r<message.length();r++){
            int asciiCode = (int)(message.charAt(r));
            availableChars[asciiCode]--;
            if(availableChars[asciiCode]<0)
                return false;
        }

        return true;
    }
}
